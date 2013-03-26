/*************************************************************************************
 *
 * Generated on Tue Mar 26 09:42:40 CET 2013 by Spray CreateConnectionFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.IGaService;
import org.eclipselabs.spray.runtime.graphiti.features.AbstractCreateConnectionFeature;
import org.eclipselabs.spray.runtime.graphiti.containers.SampleUtil;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;
import bcm.BcmFactory;
import bcm.Bundle;
import bcm.PConnection;
import bcm.Port;
import bcmspray3.Activator;
import bcmspray3.diagram.BcmSpray3ImageProvider;

public abstract class BcmSpray3CreatePConnectionFeatureBase extends AbstractCreateConnectionFeature {
    protected static String TITLE         = "Create PConnection";
    protected static String USER_QUESTION = "Enter new PConnection name";

    public BcmSpray3CreatePConnectionFeatureBase(final IFeatureProvider fp) {
        // provide name and description for the UI, e.g. the palette
        super(fp, "PConnection", "Create PConnection");
        gaService = Activator.get(IGaService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCreate(final ICreateConnectionContext context) {
        Anchor targetAnchor = getDslShapeAnchor(context.getTargetPictogramElement());
        if (targetAnchor == null) {
            return false;
        }
        // return true if both anchors belong to an EClass of the right type and those EClasses are not identical
        Anchor sourceAnchor = getDslShapeAnchor(context.getSourcePictogramElement());
        Port source = getPort(sourceAnchor);
        Port target = getPort(targetAnchor);
        if ((source != null) && (target != null) && (source != target)) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canStartConnection(final ICreateConnectionContext context) {
        // return true if start anchor belongs to a EClass of the right type
        Anchor sourceAnchor = getDslShapeAnchor(context.getSourcePictogramElement());
        if (getPort(sourceAnchor) != null) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connection create(final ICreateConnectionContext context) {
        Connection newConnection = null;
        Anchor sourceAnchor = getDslShapeAnchor(context.getSourcePictogramElement());
        Anchor targetAnchor = getDslShapeAnchor(context.getTargetPictogramElement());

        // get EClasses which should be connected
        final Port source = getPort(sourceAnchor);
        final Port target = getPort(targetAnchor);
        // containment reference is not a feature of source
        final Bundle container = org.eclipse.xtext.EcoreUtil2.getContainerOfType(source, Bundle.class);
        if (source != null && target != null) {
            // create new business object
            final PConnection eReference = createPConnection(source, target);
            // add the element to containment reference
            container.getConnections().add(eReference);
            // add connection for business object
            final AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
            addContext.setNewObject(eReference);
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);

            // activate direct editing after object creation
            getFeatureProvider().getDirectEditingInfo().setActive(true);
        }

        return newConnection;
    }

    /**
     * Returns the Port belonging to the anchor, or <code>null</code> if not available.
     */
    protected Port getPort(final Anchor anchor) {
        if (anchor != null) {
            final EObject bo = (EObject) getBusinessObjectForPictogramElement(anchor.getParent());
            if (bo instanceof Port) {
                return (Port) bo;
            }
        }
        return null;
    }

    /**
     * Creates a EReference between two EClasses.
     */
    protected PConnection createPConnection(final Port source, final Port target) {
        // TODO: Domain Object
        final PConnection domainObject = BcmFactory.eINSTANCE.createPConnection();
        domainObject.setSource(source);
        domainObject.setTarget(target);

        setDoneChanges(true);
        return domainObject;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCreateImageId() {
        return BcmSpray3ImageProvider.BCMSPRAY3__CONNECTION16;
    }

    protected Anchor getDslShapeAnchor(PictogramElement pe) {
        if (pe == null) {
            return null;
        }
        Shape dslShape = SprayLayoutService.findDslShape(pe);
        if (dslShape != null) {
            EList<Anchor> anchors = dslShape.getAnchors();
            if (!anchors.isEmpty()) {
                return anchors.get(0);
            }
        }
        return null;
    }
}
