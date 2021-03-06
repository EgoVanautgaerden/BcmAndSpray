/*************************************************************************************
 *
 * Generated on Fri Mar 29 10:58:52 CET 2013 by Spray ResizeFeature.xtend
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
import bcmspray3.shapes.PortShape;

public abstract class BcmSpray3ResizePortFeatureBase extends DefaultResizeShapeFeature {

    SprayLayoutManager layoutManager;

    public BcmSpray3ResizePortFeatureBase(final IFeatureProvider fp) {
        super(fp);
        layoutManager = new PortShape(fp).getShapeLayout();
    }

    public class ResizeConfiguration_PortShape extends DefaultResizeConfiguration {

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
        return new ResizeConfiguration_PortShape();
    }
}
