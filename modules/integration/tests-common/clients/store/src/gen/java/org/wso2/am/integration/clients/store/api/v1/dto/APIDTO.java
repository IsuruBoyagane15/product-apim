/*
 * WSO2 API Manager - Developer Portal
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Developer Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.store.v1/src/main/resources/devportal-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the API, you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_devportal\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown below to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_devportal\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_devportal\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for devportal REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_password>&scope=<scopes separated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<gateway_port>/token ``` **Sample request** ``` curl https://localhost:8243/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:subscribe apim:api_key\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:subscribe apim:api_key\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5bc0161b8aa7e701d7bf) 
 *
 * The version of the OpenAPI document: v2
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.store.api.v1.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.wso2.am.integration.clients.store.api.v1.dto.APIAdditionalPropertiesDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.APIBusinessInformationDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.APIEndpointURLsDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.APIIngressURLsDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.APIMonetizationInfoDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.APIOperationsDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.APITiersDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.AdvertiseInfoDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.LabelDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.ScopeInfoDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* APIDTO
*/

public class APIDTO {
        public static final String SERIALIZED_NAME_ID = "id";
        @SerializedName(SERIALIZED_NAME_ID)
            private String id;

        public static final String SERIALIZED_NAME_NAME = "name";
        @SerializedName(SERIALIZED_NAME_NAME)
            private String name;

        public static final String SERIALIZED_NAME_DESCRIPTION = "description";
        @SerializedName(SERIALIZED_NAME_DESCRIPTION)
            private String description;

        public static final String SERIALIZED_NAME_CONTEXT = "context";
        @SerializedName(SERIALIZED_NAME_CONTEXT)
            private String context;

        public static final String SERIALIZED_NAME_VERSION = "version";
        @SerializedName(SERIALIZED_NAME_VERSION)
            private String version;

        public static final String SERIALIZED_NAME_PROVIDER = "provider";
        @SerializedName(SERIALIZED_NAME_PROVIDER)
            private String provider;

        public static final String SERIALIZED_NAME_API_DEFINITION = "apiDefinition";
        @SerializedName(SERIALIZED_NAME_API_DEFINITION)
            private String apiDefinition;

        public static final String SERIALIZED_NAME_WSDL_URI = "wsdlUri";
        @SerializedName(SERIALIZED_NAME_WSDL_URI)
            private String wsdlUri;

        public static final String SERIALIZED_NAME_LIFE_CYCLE_STATUS = "lifeCycleStatus";
        @SerializedName(SERIALIZED_NAME_LIFE_CYCLE_STATUS)
            private String lifeCycleStatus;

        public static final String SERIALIZED_NAME_IS_DEFAULT_VERSION = "isDefaultVersion";
        @SerializedName(SERIALIZED_NAME_IS_DEFAULT_VERSION)
            private Boolean isDefaultVersion;

        public static final String SERIALIZED_NAME_TYPE = "type";
        @SerializedName(SERIALIZED_NAME_TYPE)
            private String type;

        public static final String SERIALIZED_NAME_TRANSPORT = "transport";
        @SerializedName(SERIALIZED_NAME_TRANSPORT)
            private List<String> transport = null;

        public static final String SERIALIZED_NAME_OPERATIONS = "operations";
        @SerializedName(SERIALIZED_NAME_OPERATIONS)
            private List<APIOperationsDTO> operations = null;

        public static final String SERIALIZED_NAME_AUTHORIZATION_HEADER = "authorizationHeader";
        @SerializedName(SERIALIZED_NAME_AUTHORIZATION_HEADER)
            private String authorizationHeader;

        public static final String SERIALIZED_NAME_SECURITY_SCHEME = "securityScheme";
        @SerializedName(SERIALIZED_NAME_SECURITY_SCHEME)
            private List<String> securityScheme = null;

        public static final String SERIALIZED_NAME_TAGS = "tags";
        @SerializedName(SERIALIZED_NAME_TAGS)
            private List<String> tags = null;

        public static final String SERIALIZED_NAME_TIERS = "tiers";
        @SerializedName(SERIALIZED_NAME_TIERS)
            private List<APITiersDTO> tiers = null;

        public static final String SERIALIZED_NAME_HAS_THUMBNAIL = "hasThumbnail";
        @SerializedName(SERIALIZED_NAME_HAS_THUMBNAIL)
            private Boolean hasThumbnail = false;

        public static final String SERIALIZED_NAME_ADDITIONAL_PROPERTIES = "additionalProperties";
        @SerializedName(SERIALIZED_NAME_ADDITIONAL_PROPERTIES)
            private List<APIAdditionalPropertiesDTO> additionalProperties = null;

        public static final String SERIALIZED_NAME_MONETIZATION = "monetization";
        @SerializedName(SERIALIZED_NAME_MONETIZATION)
            private APIMonetizationInfoDTO monetization;

        public static final String SERIALIZED_NAME_INGRESS_U_R_LS = "ingressURLs";
        @SerializedName(SERIALIZED_NAME_INGRESS_U_R_LS)
            private List<APIIngressURLsDTO> ingressURLs = null;

        public static final String SERIALIZED_NAME_ENDPOINT_U_R_LS = "endpointURLs";
        @SerializedName(SERIALIZED_NAME_ENDPOINT_U_R_LS)
            private List<APIEndpointURLsDTO> endpointURLs = null;

        public static final String SERIALIZED_NAME_BUSINESS_INFORMATION = "businessInformation";
        @SerializedName(SERIALIZED_NAME_BUSINESS_INFORMATION)
            private APIBusinessInformationDTO businessInformation;

        public static final String SERIALIZED_NAME_LABELS = "labels";
        @SerializedName(SERIALIZED_NAME_LABELS)
            private List<LabelDTO> labels = null;

        public static final String SERIALIZED_NAME_ENVIRONMENT_LIST = "environmentList";
        @SerializedName(SERIALIZED_NAME_ENVIRONMENT_LIST)
            private List<String> environmentList = null;

        public static final String SERIALIZED_NAME_SCOPES = "scopes";
        @SerializedName(SERIALIZED_NAME_SCOPES)
            private List<ScopeInfoDTO> scopes = null;

        public static final String SERIALIZED_NAME_AVG_RATING = "avgRating";
        @SerializedName(SERIALIZED_NAME_AVG_RATING)
            private String avgRating;

        public static final String SERIALIZED_NAME_ADVERTISE_INFO = "advertiseInfo";
        @SerializedName(SERIALIZED_NAME_ADVERTISE_INFO)
            private AdvertiseInfoDTO advertiseInfo;

        public static final String SERIALIZED_NAME_IS_SUBSCRIPTION_AVAILABLE = "isSubscriptionAvailable";
        @SerializedName(SERIALIZED_NAME_IS_SUBSCRIPTION_AVAILABLE)
            private Boolean isSubscriptionAvailable;

        public static final String SERIALIZED_NAME_CATEGORIES = "categories";
        @SerializedName(SERIALIZED_NAME_CATEGORIES)
            private List<String> categories = null;

        public static final String SERIALIZED_NAME_KEY_MANAGERS = "keyManagers";
        @SerializedName(SERIALIZED_NAME_KEY_MANAGERS)
            private Object keyManagers;

        public static final String SERIALIZED_NAME_CREATED_TIME = "createdTime";
        @SerializedName(SERIALIZED_NAME_CREATED_TIME)
            private String createdTime;

        public static final String SERIALIZED_NAME_LAST_UPDATED_TIME = "lastUpdatedTime";
        @SerializedName(SERIALIZED_NAME_LAST_UPDATED_TIME)
            private String lastUpdatedTime;


        public APIDTO id(String id) {
        
        this.id = id;
        return this;
        }

    /**
        * UUID of the api 
    * @return id
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "01234567-0123-0123-0123-012345678901", value = "UUID of the api ")
    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


        public APIDTO name(String name) {
        
        this.name = name;
        return this;
        }

    /**
        * Name of the API
    * @return name
    **/
      @ApiModelProperty(example = "CalculatorAPI", required = true, value = "Name of the API")
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


        public APIDTO description(String description) {
        
        this.description = description;
        return this;
        }

    /**
        * A brief description about the API
    * @return description
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "A calculator API that supports basic operations", value = "A brief description about the API")
    
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


        public APIDTO context(String context) {
        
        this.context = context;
        return this;
        }

    /**
        * A string that represents thecontext of the user&#39;s request
    * @return context
    **/
      @ApiModelProperty(example = "CalculatorAPI", required = true, value = "A string that represents thecontext of the user's request")
    
    public String getContext() {
        return context;
    }


    public void setContext(String context) {
        this.context = context;
    }


        public APIDTO version(String version) {
        
        this.version = version;
        return this;
        }

    /**
        * The version of the API
    * @return version
    **/
      @ApiModelProperty(example = "1.0.0", required = true, value = "The version of the API")
    
    public String getVersion() {
        return version;
    }


    public void setVersion(String version) {
        this.version = version;
    }


        public APIDTO provider(String provider) {
        
        this.provider = provider;
        return this;
        }

    /**
        * If the provider value is not given user invoking the api will be used as the provider. 
    * @return provider
    **/
      @ApiModelProperty(example = "admin", required = true, value = "If the provider value is not given user invoking the api will be used as the provider. ")
    
    public String getProvider() {
        return provider;
    }


    public void setProvider(String provider) {
        this.provider = provider;
    }


        public APIDTO apiDefinition(String apiDefinition) {
        
        this.apiDefinition = apiDefinition;
        return this;
        }

    /**
        * Swagger definition of the API which contains details about URI templates and scopes 
    * @return apiDefinition
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "{\"paths\":{\"/substract\":{\"get\":{\"x-auth-type\":\"Application & Application User\",\"x-throttling-tier\":\"Unlimited\",\"parameters\":[{\"name\":\"x\",\"required\":true,\"type\":\"string\",\"in\":\"query\"},{\"name\":\"y\",\"required\":true,\"type\":\"string\",\"in\":\"query\"}],\"responses\":{\"200\":{}}}},\"/add\":{\"get\":{\"x-auth-type\":\"Application & Application User\",\"x-throttling-tier\":\"Unlimited\",\"parameters\":[{\"name\":\"x\",\"required\":true,\"type\":\"string\",\"in\":\"query\"},{\"name\":\"y\",\"required\":true,\"type\":\"string\",\"in\":\"query\"}],\"responses\":{\"200\":{}}}}},\"swagger\":\"2.0\",\"info\":{\"title\":\"CalculatorAPI\",\"version\":\"1.0.0\"}}", value = "Swagger definition of the API which contains details about URI templates and scopes ")
    
    public String getApiDefinition() {
        return apiDefinition;
    }


    public void setApiDefinition(String apiDefinition) {
        this.apiDefinition = apiDefinition;
    }


        public APIDTO wsdlUri(String wsdlUri) {
        
        this.wsdlUri = wsdlUri;
        return this;
        }

    /**
        * WSDL URL if the API is based on a WSDL endpoint 
    * @return wsdlUri
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "http://www.webservicex.com/globalweather.asmx?wsdl", value = "WSDL URL if the API is based on a WSDL endpoint ")
    
    public String getWsdlUri() {
        return wsdlUri;
    }


    public void setWsdlUri(String wsdlUri) {
        this.wsdlUri = wsdlUri;
    }


        public APIDTO lifeCycleStatus(String lifeCycleStatus) {
        
        this.lifeCycleStatus = lifeCycleStatus;
        return this;
        }

    /**
        * This describes in which status of the lifecycle the API is.
    * @return lifeCycleStatus
    **/
      @ApiModelProperty(example = "PUBLISHED", required = true, value = "This describes in which status of the lifecycle the API is.")
    
    public String getLifeCycleStatus() {
        return lifeCycleStatus;
    }


    public void setLifeCycleStatus(String lifeCycleStatus) {
        this.lifeCycleStatus = lifeCycleStatus;
    }


        public APIDTO isDefaultVersion(Boolean isDefaultVersion) {
        
        this.isDefaultVersion = isDefaultVersion;
        return this;
        }

    /**
        * Get isDefaultVersion
    * @return isDefaultVersion
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "false", value = "")
    
    public Boolean isIsDefaultVersion() {
        return isDefaultVersion;
    }


    public void setIsDefaultVersion(Boolean isDefaultVersion) {
        this.isDefaultVersion = isDefaultVersion;
    }


        public APIDTO type(String type) {
        
        this.type = type;
        return this;
        }

    /**
        * This describes the transport type of the API
    * @return type
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "WS", value = "This describes the transport type of the API")
    
    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


        public APIDTO transport(List<String> transport) {
        
        this.transport = transport;
        return this;
        }

    /**
        * Get transport
    * @return transport
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[\"http\",\"https\"]", value = "")
    
    public List<String> getTransport() {
        return transport;
    }


    public void setTransport(List<String> transport) {
        this.transport = transport;
    }


        public APIDTO operations(List<APIOperationsDTO> operations) {
        
        this.operations = operations;
        return this;
        }

    /**
        * Get operations
    * @return operations
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[]", value = "")
    
    public List<APIOperationsDTO> getOperations() {
        return operations;
    }


    public void setOperations(List<APIOperationsDTO> operations) {
        this.operations = operations;
    }


        public APIDTO authorizationHeader(String authorizationHeader) {
        
        this.authorizationHeader = authorizationHeader;
        return this;
        }

    /**
        * Name of the Authorization header used for invoking the API. If it is not set, Authorization header name specified in tenant or system level will be used. 
    * @return authorizationHeader
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "Authorization", value = "Name of the Authorization header used for invoking the API. If it is not set, Authorization header name specified in tenant or system level will be used. ")
    
    public String getAuthorizationHeader() {
        return authorizationHeader;
    }


    public void setAuthorizationHeader(String authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
    }


        public APIDTO securityScheme(List<String> securityScheme) {
        
        this.securityScheme = securityScheme;
        return this;
        }

    /**
        * Types of API security, the current API secured with. It can be either OAuth2 or mutual SSL or both. If it is not set OAuth2 will be set as the security for the current API. 
    * @return securityScheme
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[\"oauth2\",\"oauth_basic_auth_api_key_mandatory\"]", value = "Types of API security, the current API secured with. It can be either OAuth2 or mutual SSL or both. If it is not set OAuth2 will be set as the security for the current API. ")
    
    public List<String> getSecurityScheme() {
        return securityScheme;
    }


    public void setSecurityScheme(List<String> securityScheme) {
        this.securityScheme = securityScheme;
    }


        public APIDTO tags(List<String> tags) {
        
        this.tags = tags;
        return this;
        }

    /**
        * Search keywords related to the API
    * @return tags
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[\"substract\",\"add\"]", value = "Search keywords related to the API")
    
    public List<String> getTags() {
        return tags;
    }


    public void setTags(List<String> tags) {
        this.tags = tags;
    }


        public APIDTO tiers(List<APITiersDTO> tiers) {
        
        this.tiers = tiers;
        return this;
        }

    /**
        * The subscription tiers selected for the particular API
    * @return tiers
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "The subscription tiers selected for the particular API")
    
    public List<APITiersDTO> getTiers() {
        return tiers;
    }


    public void setTiers(List<APITiersDTO> tiers) {
        this.tiers = tiers;
    }


        public APIDTO hasThumbnail(Boolean hasThumbnail) {
        
        this.hasThumbnail = hasThumbnail;
        return this;
        }

    /**
        * Get hasThumbnail
    * @return hasThumbnail
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "true", value = "")
    
    public Boolean isHasThumbnail() {
        return hasThumbnail;
    }


    public void setHasThumbnail(Boolean hasThumbnail) {
        this.hasThumbnail = hasThumbnail;
    }


        public APIDTO additionalProperties(List<APIAdditionalPropertiesDTO> additionalProperties) {
        
        this.additionalProperties = additionalProperties;
        return this;
        }

    /**
        * Custom(user defined) properties of API 
    * @return additionalProperties
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "{}", value = "Custom(user defined) properties of API ")
    
    public List<APIAdditionalPropertiesDTO> getAdditionalProperties() {
        return additionalProperties;
    }


    public void setAdditionalProperties(List<APIAdditionalPropertiesDTO> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }


        public APIDTO monetization(APIMonetizationInfoDTO monetization) {
        
        this.monetization = monetization;
        return this;
        }

    /**
        * Get monetization
    * @return monetization
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public APIMonetizationInfoDTO getMonetization() {
        return monetization;
    }


    public void setMonetization(APIMonetizationInfoDTO monetization) {
        this.monetization = monetization;
    }


        public APIDTO ingressURLs(List<APIIngressURLsDTO> ingressURLs) {
        
        this.ingressURLs = ingressURLs;
        return this;
        }

    /**
        * Get ingressURLs
    * @return ingressURLs
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<APIIngressURLsDTO> getIngressURLs() {
        return ingressURLs;
    }


    public void setIngressURLs(List<APIIngressURLsDTO> ingressURLs) {
        this.ingressURLs = ingressURLs;
    }


        public APIDTO endpointURLs(List<APIEndpointURLsDTO> endpointURLs) {
        
        this.endpointURLs = endpointURLs;
        return this;
        }

    /**
        * Get endpointURLs
    * @return endpointURLs
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<APIEndpointURLsDTO> getEndpointURLs() {
        return endpointURLs;
    }


    public void setEndpointURLs(List<APIEndpointURLsDTO> endpointURLs) {
        this.endpointURLs = endpointURLs;
    }


        public APIDTO businessInformation(APIBusinessInformationDTO businessInformation) {
        
        this.businessInformation = businessInformation;
        return this;
        }

    /**
        * Get businessInformation
    * @return businessInformation
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public APIBusinessInformationDTO getBusinessInformation() {
        return businessInformation;
    }


    public void setBusinessInformation(APIBusinessInformationDTO businessInformation) {
        this.businessInformation = businessInformation;
    }


        public APIDTO labels(List<LabelDTO> labels) {
        
        this.labels = labels;
        return this;
        }

    /**
        * Labels of micro-gateway environments attached to the API. 
    * @return labels
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "Labels of micro-gateway environments attached to the API. ")
    
    public List<LabelDTO> getLabels() {
        return labels;
    }


    public void setLabels(List<LabelDTO> labels) {
        this.labels = labels;
    }


        public APIDTO environmentList(List<String> environmentList) {
        
        this.environmentList = environmentList;
        return this;
        }

    /**
        * The environment list configured with non empty endpoint URLs for the particular API.
    * @return environmentList
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[\"PRODUCTION\",\"SANDBOX\"]", value = "The environment list configured with non empty endpoint URLs for the particular API.")
    
    public List<String> getEnvironmentList() {
        return environmentList;
    }


    public void setEnvironmentList(List<String> environmentList) {
        this.environmentList = environmentList;
    }


        public APIDTO scopes(List<ScopeInfoDTO> scopes) {
        
        this.scopes = scopes;
        return this;
        }

    /**
        * Get scopes
    * @return scopes
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<ScopeInfoDTO> getScopes() {
        return scopes;
    }


    public void setScopes(List<ScopeInfoDTO> scopes) {
        this.scopes = scopes;
    }


        public APIDTO avgRating(String avgRating) {
        
        this.avgRating = avgRating;
        return this;
        }

    /**
        * The average rating of the API
    * @return avgRating
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "4.5", value = "The average rating of the API")
    
    public String getAvgRating() {
        return avgRating;
    }


    public void setAvgRating(String avgRating) {
        this.avgRating = avgRating;
    }


        public APIDTO advertiseInfo(AdvertiseInfoDTO advertiseInfo) {
        
        this.advertiseInfo = advertiseInfo;
        return this;
        }

    /**
        * Get advertiseInfo
    * @return advertiseInfo
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public AdvertiseInfoDTO getAdvertiseInfo() {
        return advertiseInfo;
    }


    public void setAdvertiseInfo(AdvertiseInfoDTO advertiseInfo) {
        this.advertiseInfo = advertiseInfo;
    }


        public APIDTO isSubscriptionAvailable(Boolean isSubscriptionAvailable) {
        
        this.isSubscriptionAvailable = isSubscriptionAvailable;
        return this;
        }

    /**
        * Get isSubscriptionAvailable
    * @return isSubscriptionAvailable
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "false", value = "")
    
    public Boolean isIsSubscriptionAvailable() {
        return isSubscriptionAvailable;
    }


    public void setIsSubscriptionAvailable(Boolean isSubscriptionAvailable) {
        this.isSubscriptionAvailable = isSubscriptionAvailable;
    }


        public APIDTO categories(List<String> categories) {
        
        this.categories = categories;
        return this;
        }

    /**
        * API categories 
    * @return categories
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "API categories ")
    
    public List<String> getCategories() {
        return categories;
    }


    public void setCategories(List<String> categories) {
        this.categories = categories;
    }


        public APIDTO keyManagers(Object keyManagers) {
        
        this.keyManagers = keyManagers;
        return this;
        }

    /**
        * API Key Managers 
    * @return keyManagers
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "API Key Managers ")
    
    public Object getKeyManagers() {
        return keyManagers;
    }


    public void setKeyManagers(Object keyManagers) {
        this.keyManagers = keyManagers;
    }


        public APIDTO createdTime(String createdTime) {
        
        this.createdTime = createdTime;
        return this;
        }

    /**
        * Get createdTime
    * @return createdTime
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "2020-10-31T13:57:16.229", value = "")
    
    public String getCreatedTime() {
        return createdTime;
    }


    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }


        public APIDTO lastUpdatedTime(String lastUpdatedTime) {
        
        this.lastUpdatedTime = lastUpdatedTime;
        return this;
        }

    /**
        * Get lastUpdatedTime
    * @return lastUpdatedTime
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "2020-10-31T13:57:16.229", value = "")
    
    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }


    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            APIDTO API = (APIDTO) o;
            return Objects.equals(this.id, API.id) &&
            Objects.equals(this.name, API.name) &&
            Objects.equals(this.description, API.description) &&
            Objects.equals(this.context, API.context) &&
            Objects.equals(this.version, API.version) &&
            Objects.equals(this.provider, API.provider) &&
            Objects.equals(this.apiDefinition, API.apiDefinition) &&
            Objects.equals(this.wsdlUri, API.wsdlUri) &&
            Objects.equals(this.lifeCycleStatus, API.lifeCycleStatus) &&
            Objects.equals(this.isDefaultVersion, API.isDefaultVersion) &&
            Objects.equals(this.type, API.type) &&
            Objects.equals(this.transport, API.transport) &&
            Objects.equals(this.operations, API.operations) &&
            Objects.equals(this.authorizationHeader, API.authorizationHeader) &&
            Objects.equals(this.securityScheme, API.securityScheme) &&
            Objects.equals(this.tags, API.tags) &&
            Objects.equals(this.tiers, API.tiers) &&
            Objects.equals(this.hasThumbnail, API.hasThumbnail) &&
            Objects.equals(this.additionalProperties, API.additionalProperties) &&
            Objects.equals(this.monetization, API.monetization) &&
            Objects.equals(this.ingressURLs, API.ingressURLs) &&
            Objects.equals(this.endpointURLs, API.endpointURLs) &&
            Objects.equals(this.businessInformation, API.businessInformation) &&
            Objects.equals(this.labels, API.labels) &&
            Objects.equals(this.environmentList, API.environmentList) &&
            Objects.equals(this.scopes, API.scopes) &&
            Objects.equals(this.avgRating, API.avgRating) &&
            Objects.equals(this.advertiseInfo, API.advertiseInfo) &&
            Objects.equals(this.isSubscriptionAvailable, API.isSubscriptionAvailable) &&
            Objects.equals(this.categories, API.categories) &&
            Objects.equals(this.keyManagers, API.keyManagers) &&
            Objects.equals(this.createdTime, API.createdTime) &&
            Objects.equals(this.lastUpdatedTime, API.lastUpdatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, context, version, provider, apiDefinition, wsdlUri, lifeCycleStatus, isDefaultVersion, type, transport, operations, authorizationHeader, securityScheme, tags, tiers, hasThumbnail, additionalProperties, monetization, ingressURLs, endpointURLs, businessInformation, labels, environmentList, scopes, avgRating, advertiseInfo, isSubscriptionAvailable, categories, keyManagers, createdTime, lastUpdatedTime);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class APIDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    apiDefinition: ").append(toIndentedString(apiDefinition)).append("\n");
    sb.append("    wsdlUri: ").append(toIndentedString(wsdlUri)).append("\n");
    sb.append("    lifeCycleStatus: ").append(toIndentedString(lifeCycleStatus)).append("\n");
    sb.append("    isDefaultVersion: ").append(toIndentedString(isDefaultVersion)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    transport: ").append(toIndentedString(transport)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    authorizationHeader: ").append(toIndentedString(authorizationHeader)).append("\n");
    sb.append("    securityScheme: ").append(toIndentedString(securityScheme)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
    sb.append("    hasThumbnail: ").append(toIndentedString(hasThumbnail)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("    monetization: ").append(toIndentedString(monetization)).append("\n");
    sb.append("    ingressURLs: ").append(toIndentedString(ingressURLs)).append("\n");
    sb.append("    endpointURLs: ").append(toIndentedString(endpointURLs)).append("\n");
    sb.append("    businessInformation: ").append(toIndentedString(businessInformation)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    environmentList: ").append(toIndentedString(environmentList)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
    sb.append("    avgRating: ").append(toIndentedString(avgRating)).append("\n");
    sb.append("    advertiseInfo: ").append(toIndentedString(advertiseInfo)).append("\n");
    sb.append("    isSubscriptionAvailable: ").append(toIndentedString(isSubscriptionAvailable)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    keyManagers: ").append(toIndentedString(keyManagers)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
sb.append("}");
return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(Object o) {
if (o == null) {
return "null";
}
return o.toString().replace("\n", "\n    ");
}

}

