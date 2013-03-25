/*************************************************************************************
 *
 * Generated on Mon Mar 25 16:34:01 CET 2013 by Spray ImageProvider.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.diagram;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public abstract class BcmSpray3ImageProviderBase extends AbstractImageProvider {
    // The prefix for all identifiers of this image provider
    public static final String PREFIX                      = "bcmspray3.diagram.";

    // The image identifier for an EReference.
    public static final String BCMSPRAY3__ECORE_ECLASS     = PREFIX + "ecore_eclass";
    // The image identifier for an EReference.
    public static final String BCMSPRAY3__ECORE_EATTRIBUTE = PREFIX + "ecore_eattribute";
    // The image identifier for an EReference.
    public static final String BCMSPRAY3__CONNECTION16     = PREFIX + "connection16";

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addAvailableImages() {
        // register the path for each image identifier
        addImageFilePath(BCMSPRAY3__ECORE_ECLASS, "icons/ecore/EClass.gif");
        addImageFilePath(BCMSPRAY3__ECORE_EATTRIBUTE, "icons/ecore/EAttribute.gif");
        addImageFilePath(BCMSPRAY3__CONNECTION16, "icons/connection16.gif");
    }
}
