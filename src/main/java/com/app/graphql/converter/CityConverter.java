package com.app.graphql.converter;

import com.app.graphql.dto.City;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class CityConverter {

    public static Map<String, String> convertToMap(City city) {
        return ImmutableMap.of("ID", city.getId().toString(),
                "Name", city.getName(),
                "CountryCode", city.getCountryCode(),
                "District", city.getDistrict(),
                "Population",city.getPopulation().toString());
    }
}
