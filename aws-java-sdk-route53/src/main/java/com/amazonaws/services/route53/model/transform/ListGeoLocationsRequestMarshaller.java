/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.route53.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.route53.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.XMLWriter;

/**
 * List Geo Locations Request Marshaller
 */
public class ListGeoLocationsRequestMarshaller implements Marshaller<Request<ListGeoLocationsRequest>, ListGeoLocationsRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "/2013-04-01/geolocations?startcontinentcode={StartContinentCode}&startcountrycode={StartCountryCode}&startsubdivisioncode={StartSubdivisionCode}&maxitems={MaxItems}";
        Map<String, String> staticMap = new HashMap<String, String>();
        Map<String, String> dynamicMap = new HashMap<String, String>();

        int index = path.indexOf("?");
        if (index != -1) {
            String queryString = path.substring(index + 1);
            path = path.substring(0, index);

            for (String s : queryString.split("[;&]")) {
                index = s.indexOf("=");
                if (index != -1) {
                    String name = s.substring(0, index);
                    String value = s.substring(index + 1);

                    if (value.startsWith("{") && value.endsWith("}")) {
                        dynamicMap.put(value.substring(1, value.length() - 1), name);
                    } else {
                        staticMap.put(name, value);
                    }
                }
            }
        }

        RESOURCE_PATH_TEMPLATE = path;
        STATIC_QUERY_PARAMS = Collections.unmodifiableMap(staticMap);
        DYNAMIC_QUERY_PARAMS = Collections.unmodifiableMap(dynamicMap);
    }

    public Request<ListGeoLocationsRequest> marshall(ListGeoLocationsRequest listGeoLocationsRequest) {

        if (listGeoLocationsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListGeoLocationsRequest> request = new DefaultRequest<ListGeoLocationsRequest>(listGeoLocationsRequest, "AmazonRoute53");
        request.setHttpMethod(HttpMethodName.GET);

        String uriResourcePath = RESOURCE_PATH_TEMPLATE;
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("StartContinentCode")) {
            String name = DYNAMIC_QUERY_PARAMS.get("StartContinentCode");
            String value = (listGeoLocationsRequest.getStartContinentCode() == null) ? null : StringUtils.fromString(listGeoLocationsRequest.getStartContinentCode());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{StartContinentCode}", (listGeoLocationsRequest.getStartContinentCode() == null) ? "" : StringUtils.fromString(listGeoLocationsRequest.getStartContinentCode())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("StartCountryCode")) {
            String name = DYNAMIC_QUERY_PARAMS.get("StartCountryCode");
            String value = (listGeoLocationsRequest.getStartCountryCode() == null) ? null : StringUtils.fromString(listGeoLocationsRequest.getStartCountryCode());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{StartCountryCode}", (listGeoLocationsRequest.getStartCountryCode() == null) ? "" : StringUtils.fromString(listGeoLocationsRequest.getStartCountryCode())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("StartSubdivisionCode")) {
            String name = DYNAMIC_QUERY_PARAMS.get("StartSubdivisionCode");
            String value = (listGeoLocationsRequest.getStartSubdivisionCode() == null) ? null : StringUtils.fromString(listGeoLocationsRequest.getStartSubdivisionCode());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{StartSubdivisionCode}", (listGeoLocationsRequest.getStartSubdivisionCode() == null) ? "" : StringUtils.fromString(listGeoLocationsRequest.getStartSubdivisionCode())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("MaxItems")) {
            String name = DYNAMIC_QUERY_PARAMS.get("MaxItems");
            String value = (listGeoLocationsRequest.getMaxItems() == null) ? null : StringUtils.fromString(listGeoLocationsRequest.getMaxItems());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{MaxItems}", (listGeoLocationsRequest.getMaxItems() == null) ? "" : StringUtils.fromString(listGeoLocationsRequest.getMaxItems())); 
        }

        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        return request;
    }
}
