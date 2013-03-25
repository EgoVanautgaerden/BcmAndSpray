/*************************************************************************************
 *
 * Generated on Mon Mar 25 16:34:01 CET 2013 by Spray MoveFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

import org.eclipselabs.spray.runtime.graphiti.GraphitiProperties;
import org.eclipselabs.spray.runtime.graphiti.ISprayConstants;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayFixedLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayTopLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayDiagramLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.shape.SprayLayoutManager;
import bcmspray3.shapes.ComponentShape;

public abstract class BcmSpray3MoveComponentFeatureBase extends DefaultMoveShapeFeature {

    SprayLayoutManager layoutManager;

    public BcmSpray3MoveComponentFeatureBase(final IFeatureProvider fp) {
        super(fp);
        layoutManager = new ComponentShape(fp).getShapeLayout();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canMoveShape(IMoveShapeContext context) {
        Shape sourceShape = (Shape) context.getPictogramElement();
        ContainerShape targetContainer = context.getTargetContainer();
        Object source = getBusinessObjectForPictogramElement(sourceShape);
        Object target = getBusinessObjectForPictogramElement(targetContainer);
        // check whether it can move in the same container
        if (sourceShape.eContainer() == targetContainer) {
            if ((SprayLayoutService.getLayoutManager(sourceShape.getContainer()) instanceof SprayFixedLayoutManager)) {
                return true;
            }
            if ((SprayLayoutService.getLayoutManager(sourceShape.getContainer()) instanceof SprayTopLayoutManager)) {
                return true;
            }
            if ((SprayLayoutService.getLayoutManager(sourceShape.getContainer()) instanceof SprayDiagramLayoutManager)) {
                return true;
            }
            return false;
        }
        return super.canMoveShape(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveShape(IMoveShapeContext context) {
        PictogramElement sourceShape = context.getPictogramElement();
        ContainerShape targetContainer = context.getTargetContainer();
        ContainerShape sourceContainer = context.getSourceContainer();
        Object sourceParent = getBusinessObjectForPictogramElement(sourceContainer);
        Object source = getBusinessObjectForPictogramElement(sourceShape);
        Object target = getBusinessObjectForPictogramElement(targetContainer);
        if (sourceShape.eContainer() == targetContainer) {
            super.moveShape(context);
            return;
        }
    }
}
