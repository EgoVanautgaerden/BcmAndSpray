/*************************************************************************************
 *
 * Generated on Tue Mar 26 14:46:35 CET 2013 by Spray AddConnectionFromDslFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.services.IGaService;
import org.eclipselabs.spray.runtime.graphiti.features.AbstractAddConnectionFeature;
import org.eclipselabs.spray.runtime.graphiti.styles.ISprayStyle;
import bcmspray3.styles.BcmSpray3DefaultStyle;
import org.eclipselabs.spray.runtime.graphiti.shape.ISprayConnection;
import bcmspray3.shapes.ConnectionShape;
import com.google.common.base.Function;

import bcm.PConnection;
import bcm.BcmPackage;
import bcmspray3.Activator;

@SuppressWarnings("unused")
public abstract class BcmSpray3AddPConnectionFeatureBase extends AbstractAddConnectionFeature {

    public BcmSpray3AddPConnectionFeatureBase(final IFeatureProvider fp) {
        super(fp);
        gaService = Activator.get(IGaService.class);
    }

    /**
     * {@inheritDoc}
     * 
     * @return <code>true</code> if given business object is an {@link PConnection} and context is of type {@link IAddConnectionContext}
     */
    @Override
    public boolean canAdd(IAddContext context) {
        if (context instanceof IAddConnectionContext && context.getNewObject() instanceof PConnection) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PictogramElement add(IAddContext context) {
        IAddConnectionContext addConContext = (IAddConnectionContext) context;
        // TODO: Domain object
        PConnection addedDomainObject = (PConnection) context.getNewObject();
        ISprayStyle style = new BcmSpray3DefaultStyle();
        ISprayConnection connection = new ConnectionShape(getFeatureProvider());
        Connection result = (Connection) connection.getConnection(getDiagram(), style, addConContext.getSourceAnchor(), addConContext.getTargetAnchor());

        // create link and wire it
        peService.setPropertyValue(result, PROPERTY_MODEL_TYPE, BcmPackage.Literals.PCONNECTION.getName());
        link(result, addedDomainObject);
        for (ConnectionDecorator conDecorator : result.getConnectionDecorators()) {
            link(conDecorator, addedDomainObject);
        }

        setDoneChanges(true);
        updatePictogramElement(result);

        return result;
    }

}
