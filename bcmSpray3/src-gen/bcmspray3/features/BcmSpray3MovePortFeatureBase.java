/*************************************************************************************
 *
 * Generated on Fri Mar 29 10:58:52 CET 2013 by Spray MoveFeature.xtend
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
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

import org.eclipselabs.spray.runtime.graphiti.GraphitiProperties;
import org.eclipselabs.spray.runtime.graphiti.ISprayConstants;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;
import org.eclipselabs.spray.runtime.graphiti.layout.ISprayLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayFitLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayFixedLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayTopLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayDiagramLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.shape.SprayLayoutManager;
import bcmspray3.shapes.PortShape;

import bcm.Component;
import bcm.Port;

public abstract class BcmSpray3MovePortFeatureBase extends DefaultMoveShapeFeature {

    SprayLayoutManager layoutManager;

    public BcmSpray3MovePortFeatureBase(final IFeatureProvider fp) {
        super(fp);
        layoutManager = new PortShape(fp).getShapeLayout();
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
            if ((SprayLayoutService.getLayoutManager(sourceShape.getContainer()) instanceof SprayFitLayoutManager)) {
                return true;
            }
            return false;
        }
        // Can move from containment to another containment compartment
        if (target instanceof Component) {
            if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                String id = GraphitiProperties.get(context.getTargetContainer(), ISprayConstants.TEXT_ID);
                if ((id != null) && (id.equals("properties"))) {
                    return true;
                }
            }
        }
        // Can move from containment to another containment compartment
        if (target instanceof Component) {
            if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                String id = GraphitiProperties.get(context.getTargetContainer(), ISprayConstants.TEXT_ID);
                if ((id != null) && (id.equals("properties2"))) {
                    return true;
                }
            }
        }
        // Can move from containment to another containment compartment
        if (target instanceof Component) {
            if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                String id = GraphitiProperties.get(context.getTargetContainer(), ISprayConstants.TEXT_ID);
                if ((id != null) && (id.equals("properties"))) {
                    return true;
                }
            }
        }
        // Can move from containment to another containment compartment
        if (target instanceof Component) {
            if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                String id = GraphitiProperties.get(context.getTargetContainer(), ISprayConstants.TEXT_ID);
                if ((id != null) && (id.equals("properties2"))) {
                    return true;
                }
            }
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
            final Diagram diagram = this.getDiagram();
            ISprayLayoutManager mgr = SprayLayoutService.getLayoutManager(diagram);
            // TODO: Fixme: Need to layout twice, probably because this is a fit within a fit layout
            //  Only neccesary when contents is moved to xcoordinates < 0
            mgr.layout();
            mgr.layout();
            return;
        }
        if (target instanceof Component) { // For shape  + portShape
            if (SprayLayoutService.isCompartment(targetContainer)) {
                String id = GraphitiProperties.get(targetContainer, ISprayConstants.TEXT_ID);
                if ((id != null) && (id.equals("properties"))) {

                    sourceContainer.getChildren().remove(source);
                    ContainerShape sourceTop = SprayLayoutService.findTopDslShape(sourceContainer);
                    if (sourceTop != null) {
                        SprayLayoutService.getLayoutManager(sourceTop).layout();
                    }
                    // remove from source container and add to target container

                    ((Component) target).getPorts().add((Port) source);
                    sourceShape.getGraphicsAlgorithm().setX(context.getX());
                    sourceShape.getGraphicsAlgorithm().setY(context.getY());
                    targetContainer.getChildren().add((Shape) sourceShape);
                    ContainerShape targetTop = SprayLayoutService.findTopDslShape(targetContainer);
                    if (targetTop != null) {
                        SprayLayoutService.getLayoutManager(targetTop).layout();
                    }
                    return;
                }
            }
        }
        if (target instanceof Component) { // For shape  + portShape
            if (SprayLayoutService.isCompartment(targetContainer)) {
                String id = GraphitiProperties.get(targetContainer, ISprayConstants.TEXT_ID);
                if ((id != null) && (id.equals("properties2"))) {

                    sourceContainer.getChildren().remove(source);
                    ContainerShape sourceTop = SprayLayoutService.findTopDslShape(sourceContainer);
                    if (sourceTop != null) {
                        SprayLayoutService.getLayoutManager(sourceTop).layout();
                    }
                    // remove from source container and add to target container

                    ((Component) target).getPorts().add((Port) source);
                    sourceShape.getGraphicsAlgorithm().setX(context.getX());
                    sourceShape.getGraphicsAlgorithm().setY(context.getY());
                    targetContainer.getChildren().add((Shape) sourceShape);
                    ContainerShape targetTop = SprayLayoutService.findTopDslShape(targetContainer);
                    if (targetTop != null) {
                        SprayLayoutService.getLayoutManager(targetTop).layout();
                    }
                    return;
                }
            }
        }
        if (target instanceof Component) { // For shape  + portShape
            if (SprayLayoutService.isCompartment(targetContainer)) {
                String id = GraphitiProperties.get(targetContainer, ISprayConstants.TEXT_ID);
                if ((id != null) && (id.equals("properties"))) {

                    sourceContainer.getChildren().remove(source);
                    ContainerShape sourceTop = SprayLayoutService.findTopDslShape(sourceContainer);
                    if (sourceTop != null) {
                        SprayLayoutService.getLayoutManager(sourceTop).layout();
                    }
                    // remove from source container and add to target container

                    ((Component) target).getPorts().add((Port) source);
                    sourceShape.getGraphicsAlgorithm().setX(context.getX());
                    sourceShape.getGraphicsAlgorithm().setY(context.getY());
                    targetContainer.getChildren().add((Shape) sourceShape);
                    ContainerShape targetTop = SprayLayoutService.findTopDslShape(targetContainer);
                    if (targetTop != null) {
                        SprayLayoutService.getLayoutManager(targetTop).layout();
                    }
                    return;
                }
            }
        }
        if (target instanceof Component) { // For shape  + portShape
            if (SprayLayoutService.isCompartment(targetContainer)) {
                String id = GraphitiProperties.get(targetContainer, ISprayConstants.TEXT_ID);
                if ((id != null) && (id.equals("properties2"))) {

                    sourceContainer.getChildren().remove(source);
                    ContainerShape sourceTop = SprayLayoutService.findTopDslShape(sourceContainer);
                    if (sourceTop != null) {
                        SprayLayoutService.getLayoutManager(sourceTop).layout();
                    }
                    // remove from source container and add to target container

                    ((Component) target).getPorts().add((Port) source);
                    sourceShape.getGraphicsAlgorithm().setX(context.getX());
                    sourceShape.getGraphicsAlgorithm().setY(context.getY());
                    targetContainer.getChildren().add((Shape) sourceShape);
                    ContainerShape targetTop = SprayLayoutService.findTopDslShape(targetContainer);
                    if (targetTop != null) {
                        SprayLayoutService.getLayoutManager(targetTop).layout();
                    }
                    return;
                }
            }
        }
    }
}
