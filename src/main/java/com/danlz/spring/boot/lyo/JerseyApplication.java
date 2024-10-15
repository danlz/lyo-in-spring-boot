package com.danlz.spring.boot.lyo;

import com.danlz.spring.boot.lyo.generated.servlet.Application;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.ResourceShapeFactory;

import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Jersey application without HK2.
 *
 * @see Application
 */
@OpenAPIDefinition(info = @Info(title = "OSLC Server", version = "1.0.0"), servers = @Server(url = "/oslc/"))
public class JerseyApplication extends jakarta.ws.rs.core.Application {

    private final Set<Class<?>> resourceClasses = new HashSet<>();

    @SuppressWarnings("unchecked")
    public JerseyApplication() throws URISyntaxException, OslcCoreApplicationException, NoSuchFieldException, IllegalAccessException {
        final String BASE_URI = "http://localhost/validatingResourceShapes";
        for (final Map.Entry<String, Class<?>> entry : Application.getResourceShapePathToResourceClassMap().entrySet()) {
            ResourceShapeFactory.createResourceShape(BASE_URI, OslcConstants.PATH_RESOURCE_SHAPES, entry.getKey(), entry.getValue());
        }

        Field field = Application.class.getDeclaredField("RESOURCE_CLASSES");
        field.setAccessible(true);
        Object value = field.get(null);
        this.resourceClasses.addAll((Set<Class<?>>) value);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return resourceClasses;
    }
}
