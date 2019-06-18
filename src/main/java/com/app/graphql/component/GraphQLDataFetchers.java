package com.app.graphql.component;

import com.app.graphql.converter.CityConverter;
import com.app.graphql.converter.CountryConverter;
import com.app.graphql.dto.City;
import com.app.graphql.dto.Country;
import com.app.graphql.mapper.CityMapper;
import com.app.graphql.mapper.CountryMapper;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLDataFetchers {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CountryMapper countryMapper;

    public DataFetcher getCityDataFetcher() {
        return environment -> {
            String id = environment.getArgument("id");
            City city = cityMapper.findById(Integer.parseInt(id));
            return CityConverter.convertToMap(city);
        };
    }

    public DataFetcher getCountryDataFetcher() {
        return environment -> {
            String code = environment.getArgument("code");
            Country country = countryMapper.findByCode(code);
            System.out.println(country.getIndepYear() == null);
            System.out.println(country.toString());
            return CountryConverter.convertToMap(country);
        };
    }

}
