/*************************************************************************************
 *
 * Generated on Thu Mar 28 13:50:59 CET 2013 by Spray PasteFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipselabs.spray.runtime.graphiti.features.AbstractPasteFeature;
import bcm.BcmPackage;
import bcm.Bundle;
import bcm.Component;
import bcm.PConnection;
import bcmspray3.diagram.BcmSpray3ModelService;

public abstract class BcmSpray3PasteFeatureBase extends AbstractPasteFeature {

    protected BcmSpray3ModelService modelService;

    public BcmSpray3PasteFeatureBase(IFeatureProvider fp) {
        super(fp);
        modelService = BcmSpray3ModelService.getModelService(fp.getDiagramTypeProvider());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canPaste(IPasteContext context) {
        // TODO: only support pasting directly in the diagram
        PictogramElement[] pes = context.getPictogramElements();
        if (pes.length != 1 || !(pes[0] instanceof Diagram)) {
            return false;
        }
        // can paste, if all objects on the clipboard are PictogramElements with link on subclasses of Bundle
        Object[] fromClipboard = getFromClipboard();
        if (fromClipboard == null || fromClipboard.length == 0) {
            return false;
        }
        for (Object object : fromClipboard) {
            if (!(object instanceof PictogramElement)) {
                return false;
            } else if (!(getBusinessObjectForPictogramElement((PictogramElement) object) instanceof Bundle)) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paste(IPasteContext context) {
        // already verified, that pasting is allowed just directly in the diagram
        PictogramElement[] pes = context.getPictogramElements();
        Diagram diagram = (Diagram) pes[0];

        // get the PictogramElements from the clipboard and the linked business object.
        Object[] objects = getFromClipboard();
        for (Object object : objects) {
            PictogramElement pictogramElement = (PictogramElement) object;
            Bundle boRef = (Bundle) getBusinessObjectForPictogramElement(pictogramElement);
            Bundle bo = EcoreUtil.copy(boRef);
            addBusinessObjectToContainer(bo, pictogramElement);

            // create a new AddContext for the creation of a new shape.
            AddContext ac = new AddContext(new AddContext(), bo);
            ac.setLocation(0, 0); // for simplicity paste at (0, 0)
            ac.setTargetContainer(diagram); // paste on diagram
            // copy all properties from the shape (e.g. ALIAS etc.)
            for (Property prop : pictogramElement.getProperties()) {
                ac.putProperty(prop.getKey(), prop.getValue());
            }
            getFeatureProvider().addIfPossible(ac);
        }
    }

    protected void addBusinessObjectToContainer(Bundle bo, PictogramElement pe) {
        final Bundle model = modelService.getModel();
        final String alias = Graphiti.getPeService().getPropertyValue(pe, PROPERTY_ALIAS);
        if (bo.eClass() == BcmPackage.Literals.COMPONENT && alias == null) {
            model.getComponents().add((Component) bo);
        }
        if (bo.eClass() == BcmPackage.Literals.COMPONENT && "OuterComponent".equals(alias)) {
            model.getComponents().add((Component) bo);
        }
        if (bo.eClass() == BcmPackage.Literals.PORT && alias == null) {
            throw new UnsupportedOperationException("No create behavior defined");
        }
        if (bo.eClass() == BcmPackage.Literals.PCONNECTION && "Connection".equals(alias)) {
            model.getConnections().add((PConnection) bo);
        }
    }
}
