package com.inmost.pro.testtask.configuration;

import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.faces.webapp.FacesServlet;

@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.PUBLIC_CAPTCHA_KEY", "6LeKO1IaAAAAAJNHcBzmHbOrzfa2aIsNxXCsIwZr");
            servletContext.setInitParameter("primefaces.PRIVATE_CAPTCHA_KEY", "6LeKO1IaAAAAAC9FPOR4p-wyG8RtdzRZLYIK2ien");
        };
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }
}
