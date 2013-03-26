/*************************************************************************************
 *
 * Generated on Tue Mar 26 09:42:40 CET 2013 by Spray Filter.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import bcm.Component;

public class ComponentFilterBase extends AbstractPropertySectionFilter {

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean accept(final PictogramElement pe) {
        final EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        if (eObject instanceof Component) {
            return true;
        }
        return false;
    }
}
