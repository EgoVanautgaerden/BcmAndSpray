/*************************************************************************************
 *
 * Generated on Thu Mar 21 09:28:26 CET 2013 by Spray FeatureProvider.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.diagram;

//author: Ego Vanautgaerden

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

import org.eclipselabs.spray.runtime.graphiti.GraphitiProperties;
import org.eclipselabs.spray.runtime.graphiti.features.DefaultDeleteFeature;
import org.eclipselabs.spray.runtime.graphiti.features.DefaultFeatureProvider;
import org.eclipselabs.spray.runtime.graphiti.features.DefaultRemoveFeature;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayFixedLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.containers.OwnerPropertyDeleteFeature;
import bcm.BcmPackage;
import bcm.Component;
import bcm.PConnection;
import bcm.Port;
import bcmspray3.feature.BcmSpray3AddPConnectionFeature;
import bcmspray3.feature.BcmSpray3AddPortFeature;
import bcmspray3.features.BcmSpray3AddComponentFeature;
import bcmspray3.features.BcmSpray3CopyFeature;
import bcmspray3.features.BcmSpray3CreateComponentFeature;
import bcmspray3.features.BcmSpray3CreatePConnectionFeature;
import bcmspray3.features.BcmSpray3CreatePortFeature;
import bcmspray3.features.BcmSpray3DirectEditComponentFeature;
import bcmspray3.features.BcmSpray3DirectEditPConnectionFeature;
import bcmspray3.features.BcmSpray3DirectEditPortFeature;
import bcmspray3.features.BcmSpray3LayoutComponentFeature;
import bcmspray3.features.BcmSpray3LayoutPortFeature;
import bcmspray3.features.BcmSpray3PasteFeature;
import bcmspray3.features.BcmSpray3ResizeComponentFeature;
import bcmspray3.features.BcmSpray3ResizePortFeature;
import bcmspray3.features.BcmSpray3UpdateComponentFeature;
import bcmspray3.features.BcmSpray3UpdatePConnectionFeature;
import bcmspray3.features.BcmSpray3UpdatePortFeature;

@SuppressWarnings("unused")
public abstract class BcmSpray3FeatureProviderBase extends DefaultFeatureProvider {
    public BcmSpray3FeatureProviderBase(final IDiagramTypeProvider dtp) {
        super(dtp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IAddFeature getAddFeature(final IAddContext context) {
        // is object for add request a EClass or EReference?
        final EObject bo = (EObject) context.getNewObject();
        final String reference = (String) context.getProperty(PROPERTY_REFERENCE);
        final String alias = (String) context.getProperty(PROPERTY_ALIAS);
        if (bo.eClass() == BcmPackage.Literals.COMPONENT && alias == null) {
            if (reference == null) {
                return new BcmSpray3AddComponentFeature(this);
            }
        }
        if (bo.eClass() == BcmPackage.Literals.PORT && alias == null) {
            if (reference == null) {
                return new BcmSpray3AddPortFeature(this);
            }
        }
        if (bo.eClass() == BcmPackage.Literals.PCONNECTION && alias == null) {
            if (reference == null) {
                return new BcmSpray3AddPConnectionFeature(this);
            }
        }
        return super.getAddFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ICopyFeature getCopyFeature(ICopyContext context) {
        return new BcmSpray3CopyFeature(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ICreateFeature[] getCreateFeatures() {
        return new ICreateFeature[]{new BcmSpray3CreateComponentFeature(this), new BcmSpray3CreatePortFeature(this)};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ICreateConnectionFeature[] getCreateConnectionFeatures() {
        return new ICreateConnectionFeature[]{new BcmSpray3CreatePConnectionFeature(this)};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUpdateFeature getUpdateFeature(final IUpdateContext context) {
        final PictogramElement pictogramElement = context.getPictogramElement();
        String alias;
        if (pictogramElement instanceof Shape) {
            Shape dslShape = SprayLayoutService.findDslShape(pictogramElement);
            alias = peService.getPropertyValue(dslShape, PROPERTY_ALIAS);
        } else {
            alias = peService.getPropertyValue(pictogramElement, PROPERTY_ALIAS);
        }
        //    if (pictogramElement instanceof ContainerShape) {
        final EObject bo = (EObject) getBusinessObjectForPictogramElement(pictogramElement);
        if (bo == null) {
            return null;
        }
        if (bo.eClass() == BcmPackage.Literals.COMPONENT && alias == null) { // 11
            return new BcmSpray3UpdateComponentFeature(this);
        }
        if (bo.eClass() == BcmPackage.Literals.PORT && alias == null) { // 11
            return new BcmSpray3UpdatePortFeature(this);
        }
        if (bo instanceof PConnection && alias == null) { // 33
            return new BcmSpray3UpdatePConnectionFeature(this);
        }
        //        }
        return super.getUpdateFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ILayoutFeature getLayoutFeature(final ILayoutContext context) {
        final PictogramElement pictogramElement = context.getPictogramElement();
        final EObject bo = (EObject) getBusinessObjectForPictogramElement(pictogramElement);
        if (bo == null) {
            return null;
        }
        final String alias = peService.getPropertyValue(pictogramElement, PROPERTY_ALIAS);
        if (bo.eClass() == BcmPackage.Literals.COMPONENT && alias == null) {
            return new BcmSpray3LayoutComponentFeature(this);
        }
        if (bo.eClass() == BcmPackage.Literals.PORT && alias == null) {
            return new BcmSpray3LayoutPortFeature(this);
        }
        return super.getLayoutFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IRemoveFeature getRemoveFeature(final IRemoveContext context) {
        // Spray specific DefaultRemoveFeature
        final PictogramElement pictogramElement = context.getPictogramElement();
        return new DefaultRemoveFeature(this);
    }

    public IDeleteFeature getDeleteFeature(final IDeleteContext context) {
        final PictogramElement pictogramElement = context.getPictogramElement();
        final EObject bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo == null) {
            return null;
        }
        final String reference = peService.getPropertyValue(pictogramElement, PROPERTY_REFERENCE);
        final String alias = peService.getPropertyValue(pictogramElement, PROPERTY_ALIAS);

        if (bo.eClass() == BcmPackage.Literals.COMPONENT && alias == null) {
            if (reference == null) {
                return new DefaultDeleteFeature(this);
            }
        }
        if (bo.eClass() == BcmPackage.Literals.PORT && alias == null) {
            if (reference == null) {
                return new DefaultDeleteFeature(this);
            }
        }
        if (bo.eClass() == BcmPackage.Literals.PCONNECTION && alias == null) {
            if (reference == null) {
                return new DefaultDeleteFeature(this);
            }
        }

        return new DefaultDeleteFeature(this);
    }

    /** 
     * Ensure that any shape with property {@link ISprayConstants#CAN_MOVE} set to false will not have a move feature.
     */
    /**
     * {@inheritDoc}
     */
    @Override
    public IMoveShapeFeature getMoveShapeFeature(final IMoveShapeContext context) {
        final Shape shape = context.getShape();
        final ContainerShape parent = shape.getContainer();
        EObject eObject = getBusinessObjectForPictogramElement(shape);
        ContainerShape targetContainer = context.getTargetContainer();
        EObject target = getBusinessObjectForPictogramElement(targetContainer);
        if (eObject instanceof Component) {
            return new bcmspray3.features.BcmSpray3MoveComponentFeature(this);
        }

        if (eObject instanceof Port) {
            return new bcmspray3.features.BcmSpray3MovePortFeature(this);
        }

        return super.getMoveShapeFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IPasteFeature getPasteFeature(IPasteContext context) {
        return new BcmSpray3PasteFeature(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
        final PictogramElement pictogramElement = context.getPictogramElement();
        final EObject bo = (EObject) getBusinessObjectForPictogramElement(pictogramElement);
        if (bo == null) {
            return null;
        }
        if (SprayLayoutService.isCompartment(pictogramElement)) {
            return null;
        }
        String alias = null;
        if (pictogramElement instanceof Shape) {
            Shape dslShape = SprayLayoutService.findDslShape(pictogramElement);
            alias = peService.getPropertyValue(dslShape, PROPERTY_ALIAS);
        } else {
            alias = peService.getPropertyValue(pictogramElement, PROPERTY_ALIAS);
        }
        if (bo.eClass() == BcmPackage.Literals.COMPONENT && alias == null) {
            return new BcmSpray3DirectEditComponentFeature(this);
        }
        if (bo.eClass() == BcmPackage.Literals.PORT && alias == null) {
            return new BcmSpray3DirectEditPortFeature(this);
        }
        if (bo.eClass() == BcmPackage.Literals.PCONNECTION && alias == null) {
            return new BcmSpray3DirectEditPConnectionFeature(this);
        }
        return super.getDirectEditingFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ICustomFeature[] getCustomFeatures(final ICustomContext context) {
        final EObject bo = (EObject) getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
        if (bo == null) {
            return new ICustomFeature[0];
        }
        final String alias = GraphitiProperties.get(context.getPictogramElements()[0], PROPERTY_ALIAS);
        return new ICustomFeature[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
        final PictogramElement pictogramElement = context.getPictogramElement();
        final EObject bo = (EObject) getBusinessObjectForPictogramElement(pictogramElement);
        if (bo == null) {
            return null;
        }
        final String alias = peService.getPropertyValue(pictogramElement, PROPERTY_ALIAS);
        if (bo.eClass() == BcmPackage.Literals.COMPONENT && alias == null) {
            return new BcmSpray3ResizeComponentFeature(this);
        }
        if (bo.eClass() == BcmPackage.Literals.PORT && alias == null) {
            return new BcmSpray3ResizePortFeature(this);
        }
        return super.getResizeShapeFeature(context);
    }
}
