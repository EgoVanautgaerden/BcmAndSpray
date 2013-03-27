/*************************************************************************************
 *
 * Generated on Wed Mar 27 09:02:09 CET 2013 by Spray DirectEditFeature.xtend
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
import bcm.PConnection;

public abstract class BcmSpray3DirectEditPConnectionFeatureBase extends AbstractDirectEditingFeature {

    protected IPeService peService = Graphiti.getPeService();

    public BcmSpray3DirectEditPConnectionFeatureBase(IFeatureProvider fp) {
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
        // support direct editing, if it is a PConnection, and the user clicked
        // directly on the text and not somewhere else in the rectangle
        if (bo instanceof PConnection && ga instanceof Text) {
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
        // return the initial value of the clicked text on the PConnection
        PictogramElement pe = context.getPictogramElement();
        PConnection eClass = (PConnection) getBusinessObjectForPictogramElement(pe);
        Text gAlg = (Text) context.getGraphicsAlgorithm();
        String id = peService.getPropertyValue(gAlg, TEXT_ID);
        if (id.equals("assocText")) {
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
        // set the new value on the PConnection
        final PictogramElement pe = context.getPictogramElement();
        PConnection eClass = (PConnection) getBusinessObjectForPictogramElement(pe);
        Text gAlg = (Text) context.getGraphicsAlgorithm();
        String id = peService.getPropertyValue(gAlg, TEXT_ID);
        if (id.equals("assocText")) {
            eClass.setName(value);
        }
        updatePictogramElement(pe);
    }
}
