package com.danlz.spring.boot.lyo;

import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;

@Configuration
public class WebConfig {

    @Bean
    public ResourceConfig resourceConfig() throws URISyntaxException, OslcCoreApplicationException, NoSuchFieldException, IllegalAccessException {
        return new ResourceConfig() {
            {
                JerseyApplication app = new JerseyApplication();
                registerClasses(app.getClasses());
            }
        };
    }

    /**
     * Skip TLD scanning of some jars to avoid exceptions in logs.
     *
     * @return servlet web server factory
     */
    @Bean
    public ServletWebServerFactory embeddedServletContainerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addTldSkipPatterns("hk2-*.jar", "asm-*.jar");
        return factory;
    }

    /**
     * Register Jersey servlet under a specific path, so that JSPs work.
     *
     * @param resourceConfig resource config
     * @return servlet registration bean
     */
    @Bean
    public ServletRegistrationBean<ServletContainer> jerseyServletRegistration(ResourceConfig resourceConfig,
                                                                               @Value("${oslc.servletPath}") String servletPath) {
        ServletRegistrationBean<ServletContainer> registration = new ServletRegistrationBean<>(
                new ServletContainer(resourceConfig), servletPath + "/*");
        registration.setName("JAX-RS Servlet");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
