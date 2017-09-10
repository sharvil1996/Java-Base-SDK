package com.base;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Clients.HttpClientInterface;
import com.base.Http.Clients.OkHttpClient;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;

import java.util.HashMap;
import java.util.Map;

public class BaseClient {

    private static final String API_URL = "https://swapi.co/api";

    protected HttpClientInterface httpClient;

    protected Map<String, String> defaultHeaders;

    BaseClient() {
        this.httpClient = new OkHttpClient();
        this.defaultHeaders = new HashMap<>();
    }

    public BaseClient(HttpClientInterface httpClient)
    {
        this();
        this.httpClient = httpClient;
    }

    public BaseClient(HttpClientInterface httpClient, Map<String, String> defaultHeaders)
    {
        this(httpClient);
        this.defaultHeaders = defaultHeaders;
    }

    public Response sendRequest(String endpoint, String method) throws BaseHttpException {
        String url = BaseClient.buildUrl(endpoint);

        Request request = makeRequest(url, method);
        return this.httpClient.send(request);
    }

    protected static String buildUrl(String endpoint) {
        return BaseClient.API_URL.concat(endpoint);
    }

    protected Request makeRequest(String url, String method) {
        Request request = new Request(url, method);
        request.setHeaders(this.defaultHeaders);
        return request;
    }

}
