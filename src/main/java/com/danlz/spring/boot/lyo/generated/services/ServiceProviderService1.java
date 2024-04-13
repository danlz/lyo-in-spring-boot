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

package com.danlz.spring.boot.lyo.generated.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.apache.wink.json4j.JSONArray;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.lyo.oslc4j.core.OSLC4JConstants;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import com.danlz.spring.boot.lyo.generated.RestDelegate;
import com.danlz.spring.boot.lyo.generated.ServerConstants;
import com.danlz.spring.boot.lyo.generated.Oslc_rmDomainConstants;
import com.danlz.spring.boot.lyo.generated.Oslc_rmDomainConstants;
import com.danlz.spring.boot.lyo.generated.servlet.ServiceProviderCatalogSingleton;
import com.danlz.spring.boot.lyo.generated.Person;
import com.danlz.spring.boot.lyo.generated.Requirement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_SHAPES_NAMSPACE)
@Path("requirements")
public class ServiceProviderService1
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;
    @Inject  private RestDelegate delegate;

    private static final Logger log = LoggerFactory.getLogger(ServiceProviderService1.class);

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public ServiceProviderService1()
    {
        super();
    }

    private void addCORSHeaders (final HttpServletResponse httpServletResponse) {
        //UI preview can be blocked by CORS policy.
        //add select CORS headers to every response that is embedded in an iframe.
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }

    @OslcQueryCapability
    (
        title = "QueryCapability1",
        label = "QueryCapability1",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH,
        resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
        usages = {}
    )
    @GET
    @Path("query")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @Operation(
        summary = "Query capability for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        description = "Query capability for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        responses = { 
            @ApiResponse(description = "default response", content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE), @Content(mediaType = MediaType.TEXT_HTML)})
        }
    )
    public Requirement[] queryRequirements(
                                                    
                                                     @QueryParam("oslc.where") final String where,
                                                     @QueryParam("oslc.prefix") final String prefix,
                                                     @QueryParam("oslc.paging") final String pagingString,
                                                     @QueryParam("page") final String pageString,
                                                     @QueryParam("oslc.pageSize") final String pageSizeString) throws IOException, ServletException
    {
        boolean paging=false;
        int page=0;
        int pageSize=20;
        if (null != pagingString) {
            paging = Boolean.parseBoolean(pagingString);
        }
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != pageSizeString) {
            pageSize = Integer.parseInt(pageSizeString);
        }

        // Start of user code queryRequirements
        // Here additional logic can be implemented that complements main action taken in RestDelegate
        // End of user code

        List<Requirement> resources = delegate.queryRequirements(httpServletRequest, where, prefix, paging, page, pageSize);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getAbsolutePath())
            .queryParam("oslc.paging", "true")
            .queryParam("oslc.pageSize", pageSize)
            .queryParam("page", page);
        if (null != where) {
            uriBuilder.queryParam("oslc.where", where);
        }
        if (null != prefix) {
            uriBuilder.queryParam("oslc.prefix", prefix);
        }
        httpServletRequest.setAttribute("queryUri", uriBuilder.build().toString());
        if ((OSLC4JUtils.hasLyoStorePagingPreciseLimit() && resources.size() >= pageSize) 
            || (!OSLC4JUtils.hasLyoStorePagingPreciseLimit() && resources.size() > pageSize)) {
            resources = resources.subList(0, pageSize);
            uriBuilder.replaceQueryParam("page", page + 1);
            httpServletRequest.setAttribute(OSLC4JConstants.OSLC4J_NEXT_PAGE, uriBuilder.build().toString());
        }
        return resources.toArray(new Requirement [resources.size()]);
    }

    @GET
    @Path("query")
    @Produces({ MediaType.TEXT_HTML })
    @Operation(
        summary = "Query capability for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        description = "Query capability for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        responses = { 
            @ApiResponse(description = "default response", content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE), @Content(mediaType = MediaType.TEXT_HTML)})
        }
    )
    public void queryRequirementsAsHtml(
                                    
                                       @QueryParam("oslc.where") final String where,
                                       @QueryParam("oslc.prefix") final String prefix,
                                       @QueryParam("oslc.paging") final String pagingString,
                                       @QueryParam("page") final String pageString,
                                       @QueryParam("oslc.pageSize") final String pageSizeString) throws ServletException, IOException
    {
        boolean paging=false;
        int page=0;
        int pageSize=20;
        if (null != pagingString) {
            paging = Boolean.parseBoolean(pagingString);
        }
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != pageSizeString) {
            pageSize = Integer.parseInt(pageSizeString);
        }

        // Start of user code queryRequirementsAsHtml
        // End of user code

        List<Requirement> resources = delegate.queryRequirements(httpServletRequest, where, prefix, paging, page, pageSize);

        if (resources!= null) {
            // Start of user code queryRequirementsAsHtml_setAttributes
            // End of user code

            UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getAbsolutePath())
                .queryParam("oslc.paging", "true")
                .queryParam("oslc.pageSize", pageSize)
                .queryParam("page", page);
            if (null != where) {
                uriBuilder.queryParam("oslc.where", where);
            }
            if (null != prefix) {
                uriBuilder.queryParam("oslc.prefix", prefix);
            }
            httpServletRequest.setAttribute("queryUri", uriBuilder.build().toString());

        if ((OSLC4JUtils.hasLyoStorePagingPreciseLimit() && resources.size() >= pageSize) 
            || (!OSLC4JUtils.hasLyoStorePagingPreciseLimit() && resources.size() > pageSize)) {
                resources = resources.subList(0, pageSize);
                uriBuilder.replaceQueryParam("page", page + 1);
                httpServletRequest.setAttribute(OSLC4JConstants.OSLC4J_NEXT_PAGE, uriBuilder.build().toString());
            }
            httpServletRequest.setAttribute("resources", resources);
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/danlz/spring/boot/lyo/generated/requirementscollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
            return;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

}
