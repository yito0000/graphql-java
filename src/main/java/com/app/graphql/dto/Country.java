package com.app.graphql.dto;

import com.app.graphql.dto.enums.Continent;
import lombok.Data;

@Data
public class Country {

    private String code;

    private String name;

    private Continent continent;

    private String region;

    private Float surfaceArea;

    private Integer population;

    private Float lifeExpectancy;

    private Float GNP;

    private Float GNPOld;

    private String localName;

    private String governmentForm;

    private String headOfState;

    private Integer capital;

    private String code2;
}
