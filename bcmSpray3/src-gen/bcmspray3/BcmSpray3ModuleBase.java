/*************************************************************************************
 *
 * Generated on Thu Mar 28 08:08:50 CET 2013 by Spray GuiceModule.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class BcmSpray3ModuleBase extends AbstractGenericModule {
    public Class<? extends IURIEditorOpener> bindIURIEditorOpener() {
        return GlobalURIEditorOpener.class;
    }

    @Override
    public void configure(Binder binder) {
        binder.bind(IStorage2UriMapper.class).to(Storage2UriMapperImpl.class);
        binder.bind(IWorkbench.class).toInstance(PlatformUI.getWorkbench());
        binder.bind(IWorkspace.class).toInstance(ResourcesPlugin.getWorkspace());
        binder.bind(String.class).annotatedWith(Names.named("diagramTypeId")).toInstance("bcmSpray3");
    }
}
