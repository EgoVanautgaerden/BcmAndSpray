/*************************************************************************************
 *
 * Generated on Mon Mar 25 16:34:01 CET 2013 by Spray CopyFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.features.AbstractCopyFeature;
import bcm.Bundle;

public abstract class BcmSpray3CopyFeatureBase extends AbstractCopyFeature {

    public BcmSpray3CopyFeatureBase(IFeatureProvider fp) {
        super(fp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCopy(ICopyContext context) {
        final PictogramElement[] pes = context.getPictogramElements();
        // nothing selected
        if (pes == null || pes.length == 0) {
            return false;
        }
        // return true, if all selected elements are a subtypes of Bundle
        for (PictogramElement pe : pes) {
            final Object bo = getBusinessObjectForPictogramElement(pe);
            if (!(bo instanceof Bundle)) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void copy(ICopyContext context) {
        // Copy PictogramElements instead of Objects because of the properties on Shapes.
        PictogramElement[] pes = context.getPictogramElements();
        putToClipboard(pes);
    }
}
