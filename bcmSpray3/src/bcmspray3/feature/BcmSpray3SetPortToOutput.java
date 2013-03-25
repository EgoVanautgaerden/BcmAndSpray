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

import bcm.*;
import bcmspray3.styles.OutputPortStyle;

public class BcmSpray3SetPortToOutput extends AbstractCustomFeature{
	private boolean hasDoneChanges = false;

	public BcmSpray3SetPortToOutput(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	//change port to output
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Object bo = getBusinessObjectForPictogramElement(pes[0]);
		if (bo instanceof Port){
			ISprayStyle a = new OutputPortStyle();
			Style b = a.getStyle(getDiagram());
			GraphicsAlgorithm c = pes[0].getGraphicsAlgorithm();
			c.setStyle(b);
			pes[0].setGraphicsAlgorithm(c);
			((Port) bo).setType(PortType.OUT);
		}
		hasDoneChanges=true;
	}
	
	@Override
	//Can only change a port to output if it is an input port and if only one is slected
	public boolean canExecute(ICustomContext context){
		boolean check = false;
		PictogramElement[] pes = context.getPictogramElements();
		Object bo = getBusinessObjectForPictogramElement(pes[0]);
		if (bo instanceof Port){
			if (((Port)bo).getType().equals(PortType.IN) && pes.length == 1){
				check = true;
			}
		}
		return check;
	}
	
	@Override
	public String getName() {
		return "porttype OUT";
	}
	 
	@Override
	public String getDescription() {
		return "Set the porttype of a port to OUTPUT";
	}
	
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }

}
