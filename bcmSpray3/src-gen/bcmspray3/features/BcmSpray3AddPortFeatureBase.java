/*************************************************************************************
 *
 * Generated on Fri Mar 29 10:58:52 CET 2013 by Spray AddShapeFromDslFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipselabs.spray.runtime.graphiti.features.AbstractAddFeature;
import org.eclipselabs.spray.runtime.graphiti.shape.ISprayShape;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;
import org.eclipselabs.spray.runtime.graphiti.GraphitiProperties;
import bcmspray3.shapes.PortShape;
import bcmspray3.styles.BcmSpray3DefaultStyle;
import org.eclipselabs.spray.runtime.graphiti.styles.ISprayStyle;

import bcm.Port;
import bcm.Component;
import bcm.Port;

@SuppressWarnings("unused")
public abstract class BcmSpray3AddPortFeatureBase extends AbstractAddFeature {
    protected final static String typeOrAliasName = "Port";
    protected Diagram             targetDiagram   = null;

    public BcmSpray3AddPortFeatureBase(final IFeatureProvider fp) {
        super(fp);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canAdd(final IAddContext context) {
        final EObject newObject = (EObject) context.getNewObject();
        if (newObject instanceof Port) {
            // check if user wants to add to a diagram
            if (context.getTargetContainer() instanceof Diagram) {
                return false;
            } else if (context.getTargetContainer() instanceof ContainerShape) {
                // OLD STUFF
                final Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());
                // NEW stuff
                // cls Component refers to this metaClass»
                if (target instanceof bcm.Component) {
                    if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                        String id = GraphitiProperties.get(context.getTargetContainer(), TEXT_ID);
                        if ((id != null) && (id.equals("properties"))) {
                            return true;
                        }
                    }
                }
                // cls Component refers to this metaClass»
                if (target instanceof bcm.Component) {
                    if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                        String id = GraphitiProperties.get(context.getTargetContainer(), TEXT_ID);
                        if ((id != null) && (id.equals("properties2"))) {
                            return true;
                        }
                    }
                }
                // cls Component refers to this metaClass»
                if (target instanceof bcm.Component) {
                    if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                        String id = GraphitiProperties.get(context.getTargetContainer(), TEXT_ID);
                        if ((id != null) && (id.equals("properties"))) {
                            return true;
                        }
                    }
                }
                // cls Component refers to this metaClass»
                if (target instanceof bcm.Component) {
                    if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                        String id = GraphitiProperties.get(context.getTargetContainer(), TEXT_ID);
                        if ((id != null) && (id.equals("properties2"))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PictogramElement add(final IAddContext context) {
        final Port addedModelElement = (Port) context.getNewObject();
        // NEW stuff
        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());
        final ContainerShape targetContainer = context.getTargetContainer();
        final ISprayStyle style = new BcmSpray3DefaultStyle();
        final ISprayShape shape = new PortShape(getFeatureProvider());
        final ContainerShape conShape = shape.getShape(targetContainer, style);
        final IGaService gaService = Graphiti.getGaService();
        gaService.setLocation(conShape.getGraphicsAlgorithm(), context.getX(), context.getY());
        link(conShape, addedModelElement);
        linkShapes(conShape, addedModelElement);

        setDoneChanges(true);
        updatePictogramElement(conShape);
        layout(conShape);

        return conShape;
    }

    protected void linkShapes(ContainerShape conShape, Port addedModelElement) {
        link(conShape, addedModelElement);
        for (Shape childShape : conShape.getChildren()) {
            if (childShape instanceof ContainerShape) {
                linkShapes((ContainerShape) childShape, addedModelElement);
            } else {
                link(childShape, addedModelElement);
            }
        }
    }
}
