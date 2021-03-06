/*************************************************************************************
 *
 * Generated on Fri Mar 29 10:58:52 CET 2013 by Spray PropertySection.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import java.util.List;
import bcm.Port;
import bcm.PortType;
import bcm.Port;

public abstract class PortTypeSectionBase extends GFPropertySection implements ITabbedPropertyConstants {

    protected Port   bc = null;
    protected CCombo typeWidget;

    /**
     * {@inheritDoc}
     */
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        final Composite composite = factory.createFlatFormComposite(parent);
        FormData data;

        typeWidget = factory.createCCombo(composite);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        typeWidget.setLayoutData(data);

        CLabel valueLabel = factory.createCLabel(composite, "Type");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(typeWidget, -HSPACE);
        data.top = new FormAttachment(typeWidget, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void refresh() {
        typeWidget.removeSelectionListener(nameListener);
        typeWidget.setItems(getEnumerationFeatureValues());
        typeWidget.setText(getFeatureAsText());
        typeWidget.addSelectionListener(nameListener);
    }

    /**
     * 
     * @return An Array of all the String representations of Multiplicity enumeration values
     */
    protected String[] getEnumerationFeatureValues() {
        List<PortType> values = PortType.VALUES;
        String[] ret = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            ret[i] = ((PortType) values.get(i)).getName();
        }
        return ret;
    }

    //        value = ( bc.isType() ? "true" : "false" );

    /**
     * 
     * @return The string representation of the current value of 'sourceMultiplicity' of the selected Association
     */
    protected String getFeatureAsText() {
        final PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            final EObject bo = (EObject) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a Port
            if (bo == null) {
                return "unknown ";
            }
            bc = (Port) bo;
            if (bc.getType() == null) {
                return "Null value for type";
            }
            return bc.getType().getName();
        }
        return "unknown ";
    }

    private SelectionListener nameListener = new SelectionAdapter() {
                                               public void widgetSelected(SelectionEvent event) {
                                                   TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
                                                   editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
                                                       @Override
                                                       protected void doExecute() {
                                                           changePropertyValue();
                                                       }
                                                   });
                                               }
                                           };

    protected void changePropertyValue() {
        int index = typeWidget.getSelectionIndex();
        PortType value = (PortType) PortType.VALUES.get(index);
        bc.setType(value);
    }
}
