package com.base.Models;

public class User {
    /**
     * User name.
     */
    protected String name;

    /**
     * User height.
     */
    protected String height;

    /**
     * User mass.
     */
    protected String mass;

    public User(String name, String height, String mass) {
        this.name = name;
        this.height = height;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public User setHeight(String height) {
        this.height = height;
        return this;
    }

    public String getMass() {
        return mass;
    }

    public User setMass(String mass) {
        this.mass = mass;
        return this;
    }
}
