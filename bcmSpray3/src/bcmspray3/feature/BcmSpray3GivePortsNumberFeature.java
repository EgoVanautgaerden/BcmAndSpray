package bcmspray3.feature;

//Author: Ego Vanautgaerden

import javax.swing.JOptionPane;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import bcm.*;

public class BcmSpray3GivePortsNumberFeature extends BcmSpray3GivePortsFeature{

	public BcmSpray3GivePortsNumberFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public void execute(ICustomContext context){
		//get the array of objects
		PictogramElement[] pes = context.getPictogramElements();
		Object bo = getBusinessObjectForPictogramElement(pes[0]);
		
		if (bo instanceof Component){
			//get all the ports on the given component (only from component 0 wich is the first (and only) selected component)
			Port[] ports = (Port[]) ((Component)bo).getPorts().toArray();
			
			//make a string with every port named
			String returnVal = "";
			for (int i = 0; i < ports.length; i++){
				returnVal += ports[i].getName() + ":" + ports[i].getType().toString();
				if (!(i == ports.length - 1)){
					returnVal += ", ";
				}
			}
			
			//if there are no ports give an message
			if (returnVal.equals("") || returnVal == null){
				returnVal = "No ports on the given component";
				returnVal += "\nCount: 0";
			} else {
				returnVal += "\nCount: " + ports.length;
			}
			
			//return a simple message
			JOptionPane.showMessageDialog(null, returnVal);
		}
	}
	
	@Override
	public String getName() {
		return "PortsCount";
	}
	 
	@Override
	public String getDescription() {
		return "Give back all the names of ports and how many ports it has";
	}

}
