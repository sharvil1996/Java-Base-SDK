package com.base;

import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.PersonNotFound;
import com.base.Http.Clients.HttpClientInterface;
import com.base.Http.Clients.OkHttpClient;
import com.base.Models.User;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HttpClientInterface httpClient = new OkHttpClient();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        BaseClient baseClient = new BaseClient(httpClient, headers);
        Base base = new Base(baseClient);
        try {
            User user = base.getUser("1");
            System.out.println(user.getName());
        } catch (PersonNotFound | BaseHttpException personNotFound) {
            personNotFound.printStackTrace();
        }
    }

}
