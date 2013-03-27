/*************************************************************************************
 *
 * Generated on Wed Mar 27 10:58:41 CET 2013 by Spray UpdateConnectionFromDslFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.emf.ecore.EObject;
import com.google.common.base.Function;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.IGaService;
import org.eclipselabs.spray.runtime.graphiti.features.AbstractUpdateFeature;

import bcm.PConnection;
import bcmspray3.Activator;

public abstract class BcmSpray3UpdatePConnectionFeatureBase extends AbstractUpdateFeature {

    public BcmSpray3UpdatePConnectionFeatureBase(final IFeatureProvider fp) {
        super(fp);
        gaService = Activator.get(IGaService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canUpdate(final IUpdateContext context) {
        // return true, if linked business object is a EClass
        final PictogramElement pictogramElement = context.getPictogramElement();
        final EObject bo = getBusinessObjectForPictogramElement(pictogramElement);
        return (bo instanceof PConnection) && (!(pictogramElement instanceof Diagram));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IReason updateNeeded(final IUpdateContext context) {
        final PictogramElement pictogramElement = context.getPictogramElement();
        final EObject bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (!(bo instanceof PConnection)) {
            return Reason.createFalseReason();
        }
        PConnection eClass = (PConnection) bo;

        return Reason.createTrueReason();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean update(IUpdateContext context) {
        final PictogramElement pictogramElement = context.getPictogramElement();
        final PConnection eClass = (PConnection) getBusinessObjectForPictogramElement(pictogramElement);

        if (pictogramElement instanceof Connection) {
            final Connection conShape = (Connection) pictogramElement;
            for (ConnectionDecorator dec : conShape.getConnectionDecorators()) {
                final GraphicsAlgorithm gAlg = dec.getGraphicsAlgorithm();
                searchChilds(gAlg, eClass);
            }
        }

        return true;
    }

    protected void searchChilds(GraphicsAlgorithm gAlg, PConnection eClass) {
        if (gAlg instanceof Text) {
            Text text = (Text) gAlg;
            String id = peService.getPropertyValue(gAlg, TEXT_ID);
            if (id.equals("assocText")) {
                text.setValue(eClass.getName());
            }
        }
        for (GraphicsAlgorithm gAlgChild : gAlg.getGraphicsAlgorithmChildren()) {
            searchChilds(gAlgChild, eClass);
        }
    }

    protected String getValue(final String type, final PConnection eClass) {
        String result = "";
        return result;
    }
}
