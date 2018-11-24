package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

/**
 * Class will automatically be used to configure DispatcherServlet
 *   and Spring application context in the application's servlet context
 */
public class SpittrWebApplicationInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Loading servlet listener
    // Web components: middle-tier, data-tier
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    // Loading Spring application context with beans defined in WebConfig
    // Web components: controllers, view resolvers, handing mappings
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    // Map DispatcherServlet to "/"
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
