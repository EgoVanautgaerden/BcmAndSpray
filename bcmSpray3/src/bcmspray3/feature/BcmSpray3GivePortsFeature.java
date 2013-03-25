package bcmspray3.feature;

//author: Ego Vanautgaerden

import javax.swing.JOptionPane;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import bcm.*;

public class BcmSpray3GivePortsFeature extends AbstractCustomFeature{
	private boolean hasDoneChanges = false;
	
	public BcmSpray3GivePortsFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	//function to give back al the ports on a give component
	public void execute(ICustomContext context) {
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
			}
			hasDoneChanges = true;
			
			//return a simple message
			JOptionPane.showMessageDialog(null, returnVal);
		}
	}
	
	@Override
	//function to check if there is only one element to get the ports of before it is allowd to give them back
	public boolean canExecute(ICustomContext context){
		boolean check = false;
		PictogramElement[] pes = context.getPictogramElements();
		Object bo = getBusinessObjectForPictogramElement(pes[0]);
		if (bo instanceof Component && pes.length == 1){
			check = true;
		}
		return check;
	}
	
	@Override
	public String getName() {
		return "Ports";
	}
	 
	@Override
	public String getDescription() {
		return "Give back all the names of ports";
	}
	
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }

}
