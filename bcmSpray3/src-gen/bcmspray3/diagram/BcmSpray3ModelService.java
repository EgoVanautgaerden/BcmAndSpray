/*************************************************************************************
 *
 * Generated on Tue Mar 26 14:46:34 CET 2013 by Spray ModelService.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.diagram;

import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.eclipselabs.spray.runtime.graphiti.ISprayConstants;
import bcm.BcmFactory;
import bcm.Bundle;

/**
 * This class gives access to the domain model root element for a diagram.
 * On first access, a new resource will be created to which the model
 * is added.
 */
public class BcmSpray3ModelService implements ISprayConstants {
    public static final String             FILE_EXTENSION = "bcm";
    protected IPeService                   peService;
    protected IDiagramTypeProvider         dtp;

    static protected BcmSpray3ModelService modelService   = null;

    /**
     * return the model service, create one if it does not exist yet.
     */
    static public BcmSpray3ModelService getModelService(IDiagramTypeProvider dtp) {
        modelService = new BcmSpray3ModelService(dtp);
        return modelService;
    }

    /**
     * return the model service.
     * returns null if there is no model service.
     */
    static public BcmSpray3ModelService getModelService() {
        return modelService;
    }

    protected BcmSpray3ModelService(IDiagramTypeProvider dtp) {
        this.dtp = dtp;
        this.peService = Graphiti.getPeService();
    }

    public Bundle getModel() {
        final Diagram diagram = dtp.getDiagram();
        Resource r = diagram.eResource();
        ResourceSet set = r.getResourceSet();
        EObject bo = (EObject) dtp.getFeatureProvider().getBusinessObjectForPictogramElement(diagram);
        Bundle model = null;
        if (bo != null) {
            // If its a proxy, resolve it
            if (bo.eIsProxy()) {
                if (bo instanceof InternalEObject) {
                    model = (Bundle) set.getEObject(((InternalEObject) bo).eProxyURI(), true);
                }
            } else {
                if (bo instanceof Bundle) {
                    model = (Bundle) bo;
                }
            }
        }

        if (model == null) {
            model = createModel();
        }
        return model;
    }

    public Object getBusinessObject(PictogramElement pe) {
        return dtp.getFeatureProvider().getBusinessObjectForPictogramElement(dtp.getDiagram());
    }

    /**
     * Creates the domain model element and store it in the file. Overwrite to set required properties on creation.
     */
    protected Bundle createModel() {
        final Diagram diagram = dtp.getDiagram();
        try {
            Bundle model = BcmFactory.eINSTANCE.createBundle();
            createModelResourceAndAddModel(model);
            peService.setPropertyValue(diagram, PROPERTY_URI, EcoreUtil.getURI(model).toString());
            // link the diagram with the model element
            dtp.getFeatureProvider().link(diagram, model);
            return model;
        } catch (CoreException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void createModelResourceAndAddModel(final Bundle model) throws CoreException, IOException {
        final Diagram diagram = dtp.getDiagram();
        URI uri = diagram.eResource().getURI();
        uri = uri.trimFragment();
        uri = uri.trimFileExtension();
        uri = uri.appendFileExtension(FILE_EXTENSION);
        ResourceSet rSet = diagram.eResource().getResourceSet();
        final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
        if (file == null || !file.exists()) {
            Resource resource = rSet.createResource(uri);
            resource.setTrackingModification(true);
            resource.getContents().add(model);
        } else {
            final Resource resource = rSet.getResource(uri, true);
            resource.getContents().add(model);
        }
    }
}
