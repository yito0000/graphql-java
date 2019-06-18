package com.app.graphql.dto.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Continent {
    Asia("Asia"),
    Europe("Europe"),
    North_America("North America"),
    Africa("Africa"),
    Oceania("Oceania"),
    Antarctica("Antarctica"),
    South_America("South America");

    private final String value;


    Continent(String value) {
        this.value = value;
    }

    public static Continent findByValue(String value) {
        return Arrays.stream(values())
                .filter(v -> v.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

}
