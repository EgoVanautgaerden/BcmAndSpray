/*************************************************************************************
 *
 * Generated on Thu Mar 28 13:50:59 CET 2013 by Spray ToolBehaviorProvider.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;
import org.eclipselabs.spray.runtime.graphiti.tb.AbstractSprayToolBehaviorProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.services.Graphiti;

import com.google.common.collect.Lists;
import bcmspray3.features.BcmSpray3CreateComponentFeature;
import bcmspray3.features.BcmSpray3CreateConnectionFeature;
import bcmspray3.features.BcmSpray3CreateOuterComponentFeature;
import bcmspray3.features.BcmSpray3CreatePortFeature;

public abstract class BcmSpray3ToolBehaviorProviderBase extends AbstractSprayToolBehaviorProvider {
    protected static final String COMPARTMENT_COMPONETS    = "componets";
    protected static final String COMPARTMENT_CONNECTIONS  = "connections";
    protected static final String COMPARTMENT_BORDER_ITEMS = "border items";

    public BcmSpray3ToolBehaviorProviderBase(final IDiagramTypeProvider dtp) {
        super(dtp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsAlgorithm getSelectionBorder(PictogramElement pe) {
        boolean isFromDsl = SprayLayoutService.isShapeFromDsl(pe);
        if (isFromDsl) {
            ContainerShape container = (ContainerShape) pe;
            if (!container.getChildren().isEmpty()) {
                return container.getChildren().get(0).getGraphicsAlgorithm();
            }
        }
        return super.getSelectionBorder(pe);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void buildCreationTools() {
        buildCreationTool(new BcmSpray3CreateComponentFeature(this.getFeatureProvider()));
        buildCreationTool(new BcmSpray3CreateOuterComponentFeature(this.getFeatureProvider()));
        buildCreationTool(new BcmSpray3CreatePortFeature(this.getFeatureProvider()));
        buildCreationTool(new BcmSpray3CreateConnectionFeature(this.getFeatureProvider()));
        // Compartments
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Iterable<IPaletteCompartmentEntry> buildPaletteCompartments() {
        return Lists.newArrayList(getPaletteCompartment(COMPARTMENT_COMPONETS), getPaletteCompartment(COMPARTMENT_CONNECTIONS), getPaletteCompartment(COMPARTMENT_BORDER_ITEMS), getPaletteCompartment(COMPARTMENT_DEFAULT));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IPaletteCompartmentEntry getPaletteCompartmentForFeature(final IFeature feature) {
        if (feature instanceof BcmSpray3CreateComponentFeature) {
            return getPaletteCompartment(COMPARTMENT_COMPONETS);
        } else if (feature instanceof BcmSpray3CreateOuterComponentFeature) {
            return getPaletteCompartment(COMPARTMENT_COMPONETS);
        } else if (feature instanceof BcmSpray3CreatePortFeature) {
            return getPaletteCompartment(COMPARTMENT_BORDER_ITEMS);
        } else if (feature instanceof BcmSpray3CreateConnectionFeature) {
            return getPaletteCompartment(COMPARTMENT_CONNECTIONS);
        }
        return super.getPaletteCompartmentForFeature(feature);
    }
}
