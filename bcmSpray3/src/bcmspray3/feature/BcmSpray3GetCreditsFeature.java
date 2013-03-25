package bcmspray3.feature;

import javax.swing.JOptionPane;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

public class BcmSpray3GetCreditsFeature extends AbstractCustomFeature{
	
	private boolean hasDoneChanges = false;
	
	public BcmSpray3GetCreditsFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	//function to give back the credits (me)
	public void execute(ICustomContext context) {
		String message = "";
		message += "Programmed by: EgoVanautgaerden\n";
		message += "For the KULeuven departement werktuigkunde\n";
		message += "At 21/03/2013";
		this.hasDoneChanges = true;
		JOptionPane.showMessageDialog(null, message);
	}
	
	@Override
	//function to check if there is only one element to get the ports of before it is allowd to give them back
	public boolean canExecute(ICustomContext context){
		return true;
	}
	
	@Override
	public String getName() {
		return "Credits";
	}
	 
	@Override
	public String getDescription() {
		return "Give back the credits";
	}
	
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }

}
