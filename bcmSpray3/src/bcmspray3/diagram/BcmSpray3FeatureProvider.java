/*************************************************************************************
 *
 * Generated on Wed Mar 20 15:00:30 CET 2013 by Spray FeatureProvider.xtend
 * 
 * This file is an extension point: copy to "src" folder to manually add code to this
 * extension point.
 *
 *************************************************************************************/
package bcmspray3.diagram;

//author: Ego Vanautgaerden

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;

import bcmspray3.feature.*;

public class BcmSpray3FeatureProvider extends BcmSpray3FeatureProviderBase {

    public BcmSpray3FeatureProvider(final IDiagramTypeProvider dtp) {
        super(dtp);
    }
    
    @Override
    //Add my custom features to the graphiti enviroment
    public ICustomFeature[] getCustomFeatures(ICustomContext context) {
        return new ICustomFeature[] { 
        		new BcmSpray3SetPortToInput(this), 
        		new BcmSpray3SetPortToOutput(this), 
        		new BcmSpray3GivePortsFeature(this), 
        		new BcmSpray3GivePortsNumberFeature(this),
        		new BcmSpray3RenameEclassFeature(this),
        		new BcmSpray3GetCreditsFeature(this)
        		};
    }

}