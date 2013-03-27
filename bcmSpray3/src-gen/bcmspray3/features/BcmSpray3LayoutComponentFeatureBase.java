/*************************************************************************************
 *
 * Generated on Wed Mar 27 10:58:41 CET 2013 by Spray LayoutFromDslFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipselabs.spray.runtime.graphiti.features.AbstractLayoutFeature;
import org.eclipselabs.spray.runtime.graphiti.shape.SprayLayoutManager;
import bcmspray3.shapes.ComponentShape;

import bcm.Component;

public abstract class BcmSpray3LayoutComponentFeatureBase extends AbstractLayoutFeature {

    SprayLayoutManager layoutManager;

    public BcmSpray3LayoutComponentFeatureBase(final IFeatureProvider fp) {
        super(fp);
        layoutManager = new ComponentShape(fp).getShapeLayout();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canLayout(final ILayoutContext context) {
        final PictogramElement pe = context.getPictogramElement();
        if (!(pe instanceof ContainerShape)) {
            return false;
        }
        final EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
        return (businessObjects.size() == 1) && (businessObjects.get(0) instanceof Component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean layout(final ILayoutContext context) {
        return layoutManager.layout(context);
    }
}
