/*************************************************************************************
 *
 * Generated on Thu Mar 28 13:50:59 CET 2013 by Spray DiagramTypeProvider.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public abstract class BcmSpray3DiagramTypeProviderBase extends AbstractDiagramTypeProvider {
    protected IToolBehaviorProvider[] toolBehaviorProviders;

    public BcmSpray3DiagramTypeProviderBase() {
        super();
        setFeatureProvider(new BcmSpray3FeatureProvider(this));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders = new IToolBehaviorProvider[]{new BcmSpray3ToolBehaviorProvider(this)};
        }
        return toolBehaviorProviders;
    }

}
