/*************************************************************************************
 *
 * Generated on Thu Mar 28 13:50:59 CET 2013 by Spray ResizeFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.DefaultResizeConfiguration;
import org.eclipselabs.spray.runtime.graphiti.features.DefaultResizeShapeFeature;
import org.eclipselabs.spray.runtime.graphiti.shape.SprayLayoutManager;
import bcmspray3.shapes.ComponentShape;

public abstract class BcmSpray3ResizeComponentFeatureBase extends DefaultResizeShapeFeature {

    SprayLayoutManager layoutManager;

    public BcmSpray3ResizeComponentFeatureBase(final IFeatureProvider fp) {
        super(fp);
        layoutManager = new ComponentShape(fp).getShapeLayout();
    }

    public class ResizeConfiguration_ComponentShape extends DefaultResizeConfiguration {

        public boolean isHorizontalResizeAllowed() {
            return layoutManager.isStretchHorizontal();
        }

        public boolean isVerticalResizeAllowed() {
            return layoutManager.isStretchVertical();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IResizeConfiguration getResizeConfiguration(IResizeShapeContext context) {
        return new ResizeConfiguration_ComponentShape();
    }
}
