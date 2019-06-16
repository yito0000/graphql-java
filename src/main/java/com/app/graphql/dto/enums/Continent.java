package com.app.graphql.dto.enums;

import lombok.Getter;

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
}
