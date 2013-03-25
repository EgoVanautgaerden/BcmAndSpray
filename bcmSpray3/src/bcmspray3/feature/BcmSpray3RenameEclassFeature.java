package bcmspray3.feature;

//author: Ego Vanautgaerden

import javax.swing.JOptionPane;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.*;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import bcm.*;


public class BcmSpray3RenameEclassFeature extends AbstractCustomFeature {

	private boolean hasDoneChanges;

	public BcmSpray3RenameEclassFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}
	
	 @Override
	 public String getName() {
		 return "Rename object";
	 }
	 
	 @Override
	 public String getDescription() {
	     return "Change the name of the object";
	 }
	 
	 @Override
	 public boolean canExecute(ICustomContext context) {
		 // allow rename if exactly one pictogram element
	     // representing a Component or Port or PConnection is selected
		 boolean check = false;
		 PictogramElement[] pes = context.getPictogramElements();
		 if (pes != null && pes.length ==1){
	    	Object bo = getBusinessObjectForPictogramElement(pes[0]);
	    	if ((bo instanceof Component) || (bo instanceof Port) || (bo instanceof PConnection)){
	    		check = true;
	    	}
	    }
	    return check;
	 }
	 
	 @Override
	 public void execute(ICustomContext context) {
	    PictogramElement[] pes = context.getPictogramElements();
	    if (pes != null && pes.length == 1){
	    	Object bo = getBusinessObjectForPictogramElement(pes[0]);
	        //do code for a component
	        if (bo instanceof Component) {
	        	Component eClass = (Component) bo;
	            String currentName = eClass.getName();
	            // ask user for a new class name
	            String newName = JOptionPane.showInputDialog("Give in the new name of the object\nThe original name is: " + eClass.getName(), eClass.getName());
	            //change the name if the new name is not null and if the new name is the same als the origanal => don't change to keep preformance high
	            if (newName != null && !newName.equals(currentName)) {
	            	this.hasDoneChanges = true;
	                eClass.setName(newName);
	                updatePictogramElement(pes[0]);
	            }
	        }
	        //do code for a port
	        if (bo instanceof Port) {
	        	Port eClass = (Port) bo;
	            String currentName = eClass.getName();
	            // ask user for a new class name
	            String newName = JOptionPane.showInputDialog("Give in the new name of the object\nThe original name is: " + eClass.getName(), eClass.getName());
	            //change the name if the new name is not null and if the new name is the same als the origanal => don't change to keep preformance high
	            if (newName != null && !newName.equals(currentName)) {
	            	this.hasDoneChanges = true;
	                eClass.setName(newName);
	                updatePictogramElement(pes[0]);
	            }
	        }
	        //do code for a PConnection
	        if (bo instanceof PConnection) {
	        	PConnection eClass = (PConnection) bo;
	        	String currentName = eClass.getName();
	            // ask user for a new class name
	            String newName = JOptionPane.showInputDialog("Give in the new name of the object\nThe original name is: " + eClass.getName(), eClass.getName());
	            //change the name if the new name is not null and if the new name is the same als the origanal => don't change to keep preformance high
	            if (newName != null && !newName.equals(currentName)) {
	            	this.hasDoneChanges = true;
	                eClass.setName(newName);
	                updatePictogramElement(pes[0]);
	            }
	        }
	    }
	 }
	 
	 @Override
	 public boolean hasDoneChanges() {
		 return this.hasDoneChanges;
	 }
}
