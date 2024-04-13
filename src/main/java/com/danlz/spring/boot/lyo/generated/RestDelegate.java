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
 */
// End of user code

package com.danlz.spring.boot.lyo.generated;


import com.danlz.spring.boot.lyo.SpringRestDelegate;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletContextEvent;
import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import com.danlz.spring.boot.lyo.generated.servlet.ServiceProviderCatalogSingleton;
import com.danlz.spring.boot.lyo.generated.ServiceProviderInfo;
import com.danlz.spring.boot.lyo.generated.Person;
import com.danlz.spring.boot.lyo.generated.Requirement;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

public class RestDelegate {

    private static final Logger log = LoggerFactory.getLogger(RestDelegate.class);

    
    
    @Inject ResourcesFactory resourcesFactory;
    // Start of user code class_attributes
    // End of user code
    
    public RestDelegate() {
        log.trace("Delegate is initialized");
    }
    
    
    // Start of user code class_methods
    // End of user code

    //The methods contextInitializeServletListener() and contextDestroyServletListener() no longer exits
    //Migrate any user-specific code blocks to the class com.danlz.spring.boot.lyo.generated.servlet.ServletListener
    //Any user-specific code should be found in *.lost files.

    public static ServiceProviderInfo[] getServiceProviderInfos(HttpServletRequest httpServletRequest)
    {
        ServiceProviderInfo[] serviceProviderInfos = {};
        
        // Start of user code "ServiceProviderInfo[] getServiceProviderInfos(...)"
        // TODO Implement code to return the set of ServiceProviders

        SpringRestDelegate delegate = WebApplicationContextUtils.getWebApplicationContext(httpServletRequest.getServletContext()).getBean(SpringRestDelegate.class);
        serviceProviderInfos = delegate.getServiceProviderInfos().toArray(new ServiceProviderInfo[0]);

        // End of user code
        return serviceProviderInfos;
    }

    public List<Requirement> queryRequirements(HttpServletRequest httpServletRequest, String where, String prefix, boolean paging, int page, int limit)
    {
        List<Requirement> resources = null;
        
        
        // Start of user code queryRequirements
        // TODO Implement code to return a set of resources.
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }





    public String getETagFromRequirement(final Requirement aResource)
    {
        String eTag = null;
        // Start of user code getETagFromRequirement
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }

}
