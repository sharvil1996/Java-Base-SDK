package com.base;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Clients.HttpClientInterface;
import com.base.Http.Clients.OkHttpClient;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Request request = new Request("https://swapi.co/api/people/1", Request.METHOD_GET);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        request.setHeaders(headers);

        HttpClientInterface httpClient = new OkHttpClient();

        try {
            Response response = httpClient.send(request);
            System.out.println(response.getBody());
        } catch (BaseHttpException e) {
            e.printStackTrace();
        }
    }

}
