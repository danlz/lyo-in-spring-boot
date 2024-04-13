// Start of user code Copyright
/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Simple
 *
 * This file is generated by Lyo Designer (https://www.eclipse.org/lyo/)
 */
// End of user code

package com.danlz.spring.boot.lyo.generated.servlet;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.PrefixDefinition;
import org.eclipse.lyo.oslc4j.core.model.Publisher;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.ServiceProviderFactory;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;

import com.danlz.spring.boot.lyo.generated.ServiceProviderInfo;

import com.danlz.spring.boot.lyo.generated.DctermsDomainConstants;
import com.danlz.spring.boot.lyo.generated.FoafDomainConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcDomainConstants;
import com.danlz.spring.boot.lyo.generated.Oslc_rmDomainConstants;
import com.danlz.spring.boot.lyo.generated.services.ServiceProviderService1;

// Start of user code imports
// End of user code

public class ServiceProvidersFactory
{
    private static Class<?>[] RESOURCE_CLASSES =
    {
        ServiceProviderService1.class
    };

    private ServiceProvidersFactory()
    {
        super();
    }

    public static URI constructURI(final String serviceProviderId)
    {
        String basePath = OSLC4JUtils.getServletURI();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("serviceProviderId", serviceProviderId);
        String instanceURI = "serviceProviders/{serviceProviderId}";

        final UriBuilder builder = UriBuilder.fromUri(basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }

    public static URI constructURI(final ServiceProviderInfo serviceProviderInfo)
    {
        return constructURI(serviceProviderInfo.serviceProviderId);
    }

    public static String constructIdentifier(final String serviceProviderId)
    {
        return serviceProviderId;
    }

    public static String constructIdentifier(final ServiceProviderInfo serviceProviderInfo)
    {
        return constructIdentifier(serviceProviderInfo.serviceProviderId);
    }

    public static ServiceProvider createServiceProvider(final ServiceProviderInfo serviceProviderInfo) 
            throws OslcCoreApplicationException, URISyntaxException, IllegalArgumentException {
        // Start of user code init
        // End of user code
        URI serviceProviderURI = constructURI(serviceProviderInfo);
        String identifier = constructIdentifier(serviceProviderInfo);
        String basePath = OSLC4JUtils.getServletURI();
        String title = serviceProviderInfo.name;
        String description = String.format("%s (id: %s; kind: %s)",
            "Service Provider",
            identifier,
            "Service Provider");
        Publisher publisher = null;
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("serviceProviderId", serviceProviderInfo.serviceProviderId);

        ServiceProvider serviceProvider = ServiceProviderFactory.createServiceProvider(basePath,
                                                    "",
                                                    title,
                                                    description,
                                                    publisher,
                                                    RESOURCE_CLASSES,
                                                    parameterMap);

        final PrefixDefinition[] prefixDefinitions =
        {
            new PrefixDefinition(OslcConstants.DCTERMS_NAMESPACE_PREFIX, new URI(OslcConstants.DCTERMS_NAMESPACE)),
            new PrefixDefinition(OslcConstants.OSLC_CORE_NAMESPACE_PREFIX, new URI(OslcConstants.OSLC_CORE_NAMESPACE)),
            new PrefixDefinition(OslcConstants.OSLC_DATA_NAMESPACE_PREFIX, new URI(OslcConstants.OSLC_DATA_NAMESPACE)),
            new PrefixDefinition(OslcConstants.RDF_NAMESPACE_PREFIX, new URI(OslcConstants.RDF_NAMESPACE)),
            new PrefixDefinition(OslcConstants.RDFS_NAMESPACE_PREFIX, new URI(OslcConstants.RDFS_NAMESPACE)),
            new PrefixDefinition(DctermsDomainConstants.DUBLIN_CORE_NAMSPACE_PREFIX, new URI(DctermsDomainConstants.DUBLIN_CORE_NAMSPACE))
,
            new PrefixDefinition(FoafDomainConstants.FOAF_NAMSPACE_PREFIX, new URI(FoafDomainConstants.FOAF_NAMSPACE))
,
            new PrefixDefinition(OslcDomainConstants.OSLC_NAMSPACE_PREFIX, new URI(OslcDomainConstants.OSLC_NAMSPACE))
,
            new PrefixDefinition(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_SHAPES_NAMSPACE_PREFIX, new URI(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_SHAPES_NAMSPACE))
        };
        serviceProvider.setPrefixDefinitions(prefixDefinitions);

        serviceProvider.setAbout(serviceProviderURI);
        serviceProvider.setIdentifier(identifier);
        serviceProvider.setCreated(new Date());
        serviceProvider.setDetails(new URI[] {serviceProviderURI});

        // Start of user code finalize
        // End of user code
        return serviceProvider;
    }
}
