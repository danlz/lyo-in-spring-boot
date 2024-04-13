package com.danlz.spring.boot.lyo;

import com.danlz.spring.boot.lyo.generated.Requirement;
import com.danlz.spring.boot.lyo.generated.RestDelegate;
import com.danlz.spring.boot.lyo.generated.ServiceProviderInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Spring variant of the {@link RestDelegate}.
 */
@Service
public class SpringRestDelegate extends RestDelegate {

    public List<ServiceProviderInfo> getServiceProviderInfos() {
        ServiceProviderInfo spi = new ServiceProviderInfo();
        spi.serviceProviderId = "1";
        spi.name = "Requirements Service Provider";

        return List.of(spi);
    }

    @Override
    public List<Requirement> queryRequirements(HttpServletRequest httpServletRequest, String where, String prefix, boolean paging, int page, int limit)
    {
        List<Requirement> resources = new ArrayList<>();

        try {
            Requirement req1 = new Requirement(new URI("http://localhost:8080/oslc/requirements/1"));
            req1.setIdentifier("req1");
            req1.setCreated(new Date());
            req1.setTitle("Requirement 1");
            req1.setDescription("Description of requirements 1");
            resources.add(req1);

            Requirement req2 = new Requirement(new URI("http://localhost:8080/oslc/requirements/2"));
            req2.setIdentifier("req2");
            req2.setCreated(new Date());
            req2.setTitle("Requirement 2");
            req2.setDescription("Description of requirements 2");
            resources.add(req2);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Could not build requirements list", e);
        }

        return resources;
    }

}
