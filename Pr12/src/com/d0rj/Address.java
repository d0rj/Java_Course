package com.d0rj;

import java.util.StringTokenizer;


public class Address {

    private final String country;
    private final String region;
    private final String city;
    private final String street;
    private final String building;
    private final String housing;
    private final String apartment;

    private static final int countOfMembers = 7;


    private Address(String country, String region, String city, String street, String building, String housing, String apartment) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.building = building;
        this.housing = housing;
        this.apartment = apartment;
    }


    public static Address fromString(String src) throws IllegalArgumentException {
        String[] tokens = src.split(", ");

        if (tokens.length != countOfMembers)
            throw new IllegalArgumentException();

        return new Address(
                tokens[0],
                tokens[1],
                tokens[2],
                tokens[3],
                tokens[4],
                tokens[5],
                tokens[6]
        );
    }


    public static Address fromAnotherString(String src) throws IllegalArgumentException {
        var tokenizer = new StringTokenizer(src, " ,.;-");
        var tokens = new String[7];

        if (tokenizer.countTokens() < countOfMembers)
            throw new IllegalArgumentException();

        for (int i = 0; i < countOfMembers; ++i)
            tokens[i] = tokenizer.nextToken();

        return new Address(
                tokens[0],
                tokens[1],
                tokens[2],
                tokens[3],
                tokens[4],
                tokens[5],
                tokens[6]
        );
    }


    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", housing='" + housing + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
