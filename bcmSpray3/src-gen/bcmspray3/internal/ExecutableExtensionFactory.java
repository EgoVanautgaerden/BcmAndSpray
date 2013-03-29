/*************************************************************************************
 *
 * Generated on Fri Mar 29 10:58:52 CET 2013 by Spray ExecutableExtensionFactory.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package bcmspray3.internal;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import bcmspray3.Activator;

public class ExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Bundle getBundle() {
        return Activator.getDefault().getBundle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Injector getInjector() {
        return Activator.getDefault().getInjector();
    }

}
