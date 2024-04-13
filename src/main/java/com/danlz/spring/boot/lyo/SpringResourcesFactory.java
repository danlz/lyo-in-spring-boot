package com.danlz.spring.boot.lyo;

import com.danlz.spring.boot.lyo.generated.ResourcesFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Spring variant of the {@link ResourcesFactory}.
 */
@Service
public class SpringResourcesFactory extends ResourcesFactory {

    public SpringResourcesFactory(@Value("${oslc.servletPath}") String basePath) {
        super(basePath);
    }
}
