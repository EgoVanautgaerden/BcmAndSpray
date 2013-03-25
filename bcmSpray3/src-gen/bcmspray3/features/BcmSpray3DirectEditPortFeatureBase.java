/*************************************************************************************
 *
 * Generated on Mon Mar 25 16:34:01 CET 2013 by Spray DirectEditFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.eclipselabs.spray.runtime.graphiti.features.AbstractDirectEditingFeature;
import bcm.Port;

public abstract class BcmSpray3DirectEditPortFeatureBase extends AbstractDirectEditingFeature {

    protected IPeService peService = Graphiti.getPeService();

    public BcmSpray3DirectEditPortFeatureBase(IFeatureProvider fp) {
        super(fp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canDirectEdit(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        // support direct editing, if it is a Port, and the user clicked
        // directly on the text and not somewhere else in the rectangle
        if (bo instanceof Port && ga instanceof Text) {
            return true;
        }
        // direct editing not supported in all other cases
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInitialValue(IDirectEditingContext context) {
        // return the initial value of the clicked text on the Port
        PictogramElement pe = context.getPictogramElement();
        Port eClass = (Port) getBusinessObjectForPictogramElement(pe);
        Text gAlg = (Text) context.getGraphicsAlgorithm();
        String id = peService.getPropertyValue(gAlg, TEXT_ID);
        if (id.equals("portText")) {
            return eClass.getName();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getEditingType() {
        return TYPE_TEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(final String value, final IDirectEditingContext context) {
        // set the new value on the Port
        final PictogramElement pe = context.getPictogramElement();
        Port eClass = (Port) getBusinessObjectForPictogramElement(pe);
        Text gAlg = (Text) context.getGraphicsAlgorithm();
        String id = peService.getPropertyValue(gAlg, TEXT_ID);
        if (id.equals("portText")) {
            eClass.setName(value);
        }
        updatePictogramElement(pe);
    }
}
