package com.base.Exceptions;

public class PersonNotFound extends BaseException {
    public PersonNotFound(String personId) {
        super(404, "Person with id " + personId + " was not found.");
    }
}
