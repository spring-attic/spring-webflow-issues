package spring.workshop.webflow.config;

import com.sun.faces.config.FacesInitializer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.faces.mvc.JsfView;
import org.springframework.faces.webflow.JsfResourceRequestHandler;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.HashSet;
import java.util.Set;

/**
 * JSF Configuration (no web.xml required any more).
 */
@Configuration
public class JsfConfiguration {

    /**
     * Initialize JavaServer Faces.
     * @return the jsf initializer
     */
    @Bean
    public JsfContextInitializer jsfContextInitializer() {
        return new JsfContextInitializer ();
    }

    public static class JsfContextInitializer extends ServletRegistrationBean  {

        @Override
        public void onStartup ( ServletContext servletContext ) throws ServletException {

            servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX",
                    ".xhtml");
            servletContext.setInitParameter(
                    "javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
            servletContext.setInitParameter(
                    "javax.faces.STATE_SAVING_METHOD", "server");
            servletContext.setInitParameter(
                    "com.sun.faces.forceLoadConfiguration", "true");
            servletContext.setInitParameter("javax.faces.PROJECT_STAGE",
                    "Development");
            servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
            servletContext.setInitParameter(
                    "javax.faces.FACELETS_REFRESH_PERIOD", "1");
            servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
            servletContext.setInitParameter ( "primefaces.THEME", "bootstrap" );

            FacesInitializer facesInitializer = new FacesInitializer ();

            Set<Class<?>> clazz = new HashSet<> ();
            clazz.add(JsfConfiguration.class);
            facesInitializer.onStartup(clazz, servletContext);

        }
    }
}
