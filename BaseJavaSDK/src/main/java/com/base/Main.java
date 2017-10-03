package com.base;

import com.base.Exceptions.BaseException;
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
            User user = base.getUser("BN");
            System.out.println(user.getName());
        } catch (PersonNotFound personNotFound) {
            System.out.println("Person not found");
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

}
