package com.example.nativeandroidtasks.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User_response {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("address")
    @Expose
    public Address address;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("website")
    @Expose
    public String website;
    @SerializedName("company")
    @Expose
    public Company company;

    public class Company {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("catchPhrase")
        @Expose
        public String catchPhrase;
        @SerializedName("bs")
        @Expose
        public String bs;

    }

    public class Address {

        @SerializedName("street")
        @Expose
        public String street;
        @SerializedName("suite")
        @Expose
        public String suite;
        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("zipcode")
        @Expose
        public String zipcode;
        @SerializedName("geo")
        @Expose
        public Geo geo;

        public class Geo {

            @SerializedName("lat")
            @Expose
            public String lat;
            @SerializedName("lng")
            @Expose
            public String lng;

        }

    }
}
