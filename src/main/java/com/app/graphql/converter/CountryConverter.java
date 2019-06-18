package com.app.graphql.converter;

import com.app.graphql.dto.Country;
import com.google.common.collect.ImmutableMap;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CountryConverter {

    public static Map<String, String> convertToMap(Country country) {
        Map<String, String> map = new HashMap<>();
        if (country.getCode() != null) map.put("Code", country.getCode());
        if (country.getName() != null) map.put("Name", country.getName());
        if (country.getContinent() != null) map.put("Continent", country.getContinent().toString());
        if (country.getRegion() != null) map.put("Region", country.getRegion());
        if (country.getSurfaceArea() != null) map.put("SurfaceArea", decimalFormat(country.getSurfaceArea()));
        if (country.getIndepYear() != null) map.put("IndepYear", country.getIndepYear().toString());
        if (country.getPopulation() != null) map.put("Population", country.getPopulation().toString());
        if (country.getLifeExpectancy() != null) map.put("LifeExpectancy", decimalFormat(country.getLifeExpectancy()));
        if (country.getGNP() != null) map.put("GNP", decimalFormat(country.getGNP()));
        if (country.getGNPOld() != null) map.put("GNPOld", decimalFormat(country.getGNPOld()));
        if (country.getLocalName() != null) map.put("LocalName", country.getLocalName());
        if (country.getGovernmentForm() != null) map.put("GovernmentForm", country.getGovernmentForm());
        if (country.getHeadOfState() != null) map.put("HeadOfState", country.getHeadOfState());
        if (country.getCapital() != null) map.put("Capital", country.getCapital().toString());
        if (country.getCode2() != null) map.put("Code2", country.getCode2());
        return ImmutableMap.<String, String>builder().putAll(map).build();
    }

    private static String decimalFormat(Float value) {
        return new DecimalFormat("#.00").format(value);
    }

}
