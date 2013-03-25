package bcmspray3.feature;

//author: Ego Vanautgaerden

import javax.swing.JOptionPane;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipselabs.spray.runtime.graphiti.styles.ISprayStyle;

import bcm.Port;
import bcm.PortType;
import bcmspray3.styles.InputPortStyle;

public class BcmSpray3SetPortToInput extends AbstractCustomFeature{
	private boolean hasDoneChanges = false;

	public BcmSpray3SetPortToInput(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	//Change port tot input
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Object bo = getBusinessObjectForPictogramElement(pes[0]);
		if (bo instanceof Port){
			ISprayStyle a = new InputPortStyle();
			Style b = a.getStyle(getDiagram());
			GraphicsAlgorithm c = pes[0].getGraphicsAlgorithm();
			c.setStyle(b);
			pes[0].setGraphicsAlgorithm(c);
			((Port) bo).setType(PortType.IN);
		}
		hasDoneChanges=true;
	}
	
	@Override
	//Can only be executed if the selected port is an outward port and only one is slected
	public boolean canExecute(ICustomContext context){
		boolean check = false;
		PictogramElement[] pes = context.getPictogramElements();
		Object bo = getBusinessObjectForPictogramElement(pes[0]);
		if (bo instanceof Port){
			if (((Port)bo).getType().equals(PortType.OUT) && pes.length == 1){
				check = true;
			}
		}
		return check;
	}
	
	@Override
	public String getName() {
		return "porttype IN";
	}
	 
	@Override
	public String getDescription() {
		return "Set the porttype of a port to INPUT";
	}
	
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }

}
