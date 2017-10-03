package com.base;

import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Http.Response.Response;

public class BaseExceptionHandler {

    public static Response handle(Response response) throws BaseHttpException {

        if (response.getStatusCode() >= 400) {
            BaseExceptionHandler.throwException(response);
        }

        return response;
    }

    private static void throwException(Response response) throws BaseHttpException {
        int statusCode = response.getStatusCode();
        String message = response.getBody();
        if (statusCode == 404) {
            throw new NotFound(statusCode, message);
        }

        throw new BaseHttpException(statusCode, message);
    }

}
