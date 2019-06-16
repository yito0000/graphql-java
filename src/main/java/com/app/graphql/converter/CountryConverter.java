package com.app.graphql.converter;

import com.app.graphql.dto.Country;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class CountryConverter {

    public static Map<String, String> convertToMap(Country country) {
        return ImmutableMap.<String, String>builder()
                .put("Code", country.getCode())
                .put("Name", country.getName())
                .put("Continent", country.getContinent().toString())
                .put("Region", country.getRegion())
                .put("SurfaceArea", country.getSurfaceArea().toString())
                .put("GNP", country.getGNP().toString())
                .put("GNPOld", country.getGNPOld().toString())
                .put("LocalName", country.getLocalName())
                .put("GovernmentForm", country.getGovernmentForm())
                .put("HeadOfState", country.getHeadOfState())
                .put("Capital", country.getCapital().toString())
                .put("Code2", country.getCode2()).build();
    }
}
