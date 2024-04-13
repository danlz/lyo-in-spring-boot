package com.danlz.spring.boot.lyo;

import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class Oslc4jInitializer {

    public Oslc4jInitializer(@Value("${oslc.publicUri}") String publicUri, @Value("${oslc.servletPath}") String servletPath) throws MalformedURLException {
        OSLC4JUtils.setPublicURI(publicUri);
        OSLC4JUtils.setServletPath(servletPath);
    }
}
