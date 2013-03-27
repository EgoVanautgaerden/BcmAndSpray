/*************************************************************************************
 *
 * Generated on Wed Mar 27 10:58:41 CET 2013 by Spray CreateShapeFeature.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipselabs.spray.runtime.graphiti.containers.SampleUtil;
import org.eclipselabs.spray.runtime.graphiti.features.AbstractCreateFeature;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;
import org.eclipselabs.spray.runtime.graphiti.GraphitiProperties;
import bcm.Component;
import org.eclipse.graphiti.features.context.IAreaContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import bcm.BcmFactory;
import bcm.Bundle;
import bcm.Component;
import bcmspray3.diagram.BcmSpray3ImageProvider;
import bcmspray3.diagram.BcmSpray3ModelService;

public abstract class BcmSpray3CreateComponentFeatureBase extends AbstractCreateFeature {
    protected static String         TITLE         = "Create ";
    protected static String         USER_QUESTION = "Enter new  name";
    protected BcmSpray3ModelService modelService;
    protected Component             newClass      = null;

    public BcmSpray3CreateComponentFeatureBase(final IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Component", "Create new Component");
        modelService = BcmSpray3ModelService.getModelService(fp.getDiagramTypeProvider());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCreate(final ICreateContext context) {
        final Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());
        // TODO: Respect the cardinality of the containment reference
        if (context.getTargetContainer() instanceof Diagram) {
            return true;
        } else if (context.getTargetContainer() instanceof ContainerShape) {
        }
        // And now the new stuff
        // cls Component refers to this metaClass
        if (target instanceof bcm.Component) {
            if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                String id = GraphitiProperties.get(context.getTargetContainer(), TEXT_ID);
                if ((id != null) && (id.equals("comps"))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] create(final ICreateContext context) {
        newClass = createComponent(context);

        if (newClass == null) {
            return EMPTY;
        }

        // do the add
        addGraphicalRepresentation(context, newClass);

        // activate direct editing after object creation
        getFeatureProvider().getDirectEditingInfo().setActive(true);

        // return newly created business object(s)
        return new Object[]{newClass};
    }

    //       org.eclipse.emf.ecore.impl.EReferenceImpl@6d535ebf (name: components) (ordered: true, unique: true, lowerBound: 0, upperBound: -1) (changeable: true, volatile: false, transient: false, defaultValueLiteral: null, unsettable: false, derived: false) (containment: true, resolveProxies: true) 

    /**
     * Creates a new {@link Component} instance and adds it to the containing type.
     */
    protected Component createComponent(final ICreateContext context) {
        // create Component instance
        final Component newClass = BcmFactory.eINSTANCE.createComponent();
        // ask user for Component name
        String newName = SampleUtil.askString(TITLE, USER_QUESTION, "", null);
        if (newName == null || newName.trim().length() == 0) {
            return null;
        } else {
            newClass.setName(newName);
        }
        ContainerShape targetContainer = context.getTargetContainer();
        boolean isContainment = false;
        final Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());
        //              And now the NEW stuff
        if (target instanceof bcm.Component) {
            bcm.Component domainObject = (bcm.Component) target;
            // containment
            domainObject.getComponents().add(newClass);
            setDoneChanges(true);
            return newClass;
        }
        if (!isContainment) {
            // add the element to containment reference
            Bundle model = modelService.getModel();
            model.getComponents().add(newClass);
        }
        setDoneChanges(true);
        return newClass;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCreateImageId() {
        return BcmSpray3ImageProvider.BCMSPRAY3__ECORE_ECLASS;
    }
}
