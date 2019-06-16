package com.app.graphql.dto;

import lombok.Data;

@Data
public class City {

    private Integer id;

    private String name;

    private String countryCode;

    private String district;

    private Integer population;
}
