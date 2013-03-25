/*************************************************************************************
 *
 * Generated on Wed Mar 20 14:21:17 CET 2013 by Spray AddConnectionFromDslFeature.xtend
 * 
 * This file is an extension point: copy to "src" folder to manually add code to this
 * extension point.
 *
 * Remove from auto generation by Ego Vanautgaerden to add the warnings for connections
 * This was on 20/03/2013 14u30
 *************************************************************************************/
package bcmspray3.feature;

//author: Ego Vanautgaerden

import javax.swing.JOptionPane;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import bcm.*;
import bcmspray3.features.BcmSpray3AddPConnectionFeatureBase;

public class BcmSpray3AddPConnectionFeature extends BcmSpray3AddPConnectionFeatureBase {
    public BcmSpray3AddPConnectionFeature(IFeatureProvider fp) {
        super(fp);
    }
    
    @Override
    //function changed so you only can add connection if it goes from an outward port to an inward port
    public boolean canAdd(IAddContext context){
    	boolean check = super.canAdd(context);
    	if (check){
    		//if it is an new PConnection
    		if (context.getNewObject() instanceof PConnection){
    			PConnection a = (PConnection) context.getNewObject();
    			//Show message if the connection starts from an inward port
    			if (check == true && a.getSource().getType().equals(PortType.IN)){
    				check = false;
    				JOptionPane.showMessageDialog(null, "You can't start a connection from an incomeing port");
    			}
    			//Show message if the connection stops on an outward port
    			if (check == true && a.getTarget().getType().equals(PortType.OUT)){
    				check = false;
    				JOptionPane.showMessageDialog(null, "You can't end a connection on an outgoinging port");
    			}
    		}
    	}
    	return check;
    }
}
