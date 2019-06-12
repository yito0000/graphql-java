package com.app.graphql.component;

import com.app.graphql.entity.City;
import com.app.graphql.repository.CityRepository;
import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLDataFetchers {

    @Autowired
    private CityRepository cityRepository;

    public DataFetcher getCityDataFetcher() {
        return environment -> {
            String id = environment.getArgument("id");
            City city = cityRepository.findById(Integer.parseInt(id));
            return convertCityToMap(city);
        };
    }

    private Map<String, String> convertCityToMap(City city) {
        return ImmutableMap.of("ID", city.getId().toString(),
                "Name", city.getName(),
                "CountryCode", city.getCountryCode(),
                "District", city.getDistrict(),
                "Population",city.getPopulation().toString());
    }

}
