package com.app.graphql.component;

import com.app.graphql.converter.CityConverter;
import com.app.graphql.converter.CountryConverter;
import com.app.graphql.dto.City;
import com.app.graphql.dto.Country;
import com.app.graphql.repository.CityRepository;
import com.app.graphql.repository.CountryRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLDataFetchers {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    public DataFetcher getCityDataFetcher() {
        return environment -> {
            String id = environment.getArgument("id");
            City city = cityRepository.findById(Integer.parseInt(id));
            return CityConverter.convertToMap(city);
        };
    }

    public DataFetcher getCountryDataFetcher() {
        return environment -> {
            String code = environment.getArgument("code");
            Country country = countryRepository.findByCode(code);
            return CountryConverter.convertToMap(country);
        };
    }

}
