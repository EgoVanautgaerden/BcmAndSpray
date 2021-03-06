/*************************************************************************************
 *
 * Generated on Fri Mar 29 10:58:52 CET 2013 by Spray UpdateShapeFromDslFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.IGaService;
import org.eclipselabs.spray.runtime.graphiti.features.AbstractUpdateFeature;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;

import bcm.Port;
import bcm.Port;
import bcmspray3.Activator;

public abstract class BcmSpray3UpdatePortFeatureBase extends AbstractUpdateFeature {
    public BcmSpray3UpdatePortFeatureBase(final IFeatureProvider fp) {
        super(fp);
        gaService = Activator.get(IGaService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canUpdate(final IUpdateContext context) {
        // return true, if linked business object is a Port
        final PictogramElement pictogramElement = context.getPictogramElement();
        final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        return (bo instanceof Port) && (!(pictogramElement instanceof Diagram));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IReason updateNeeded(final IUpdateContext context) {
        final PictogramElement pictogramElement = context.getPictogramElement();
        final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (!(bo instanceof Port)) {
            return Reason.createFalseReason();
        }
        if (pictogramElement instanceof Shape) {
            Shape shape = (Shape) pictogramElement;
            Port eClass = (Port) bo;
            if (checkUpdateNeededRecursively(shape, eClass)) {
                return Reason.createTrueReason();
            }
            if (shape instanceof ContainerShape) {
                for (Shape childShape : ((ContainerShape) shape).getChildren()) {
                    if (checkUpdateNeededRecursively(childShape, eClass)) {
                        return Reason.createTrueReason();
                    }
                }
            }
        }
        return Reason.createFalseReason();
    }

    protected boolean checkUpdateNeededRecursively(Shape shape, final Port eClass) {
        GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
        if (graphicsAlgorithm instanceof Text) {
            Text text = (Text) graphicsAlgorithm;
            String id = peService.getPropertyValue(graphicsAlgorithm, TEXT_ID);
            if (id != null) {
                if (id.equals("portText")) {
                    String eClassValue = eClass.getName();
                    String gAlgorithmValue = text.getValue();
                    if (eClassValue != null) {
                        if (!eClassValue.equals(gAlgorithmValue)) {
                            return true;
                        }
                    }
                }
            }
        }
        if (shape instanceof ContainerShape) {
            for (Shape child : ((ContainerShape) shape).getChildren()) {
                if (checkUpdateNeededRecursively(child, eClass)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean update(final IUpdateContext context) {
        final PictogramElement pictogramElement = context.getPictogramElement();
        final Port eClass = (Port) getBusinessObjectForPictogramElement(pictogramElement);
        if (pictogramElement instanceof Shape) {
            Shape shape = (Shape) pictogramElement;
            updateChildsRecursively(shape, eClass);
            Shape top = findTopShape(shape);
            SprayLayoutService.getLayoutManager(top).layout();
        }
        return true;

    }

    protected void updateChildsRecursively(Shape shape, final Port eClass) {
        GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
        if (graphicsAlgorithm instanceof Text) {
            Text text = (Text) graphicsAlgorithm;
            String id = peService.getPropertyValue(graphicsAlgorithm, TEXT_ID);
            if (id != null) {
                if (id.equals("portText")) {
                    text.setValue(eClass.getName());
                }
            }
        }

        if (shape instanceof ContainerShape) {
            for (Shape child : ((ContainerShape) shape).getChildren()) {
                updateChildsRecursively(child, eClass);
            }
        }
    }
}
