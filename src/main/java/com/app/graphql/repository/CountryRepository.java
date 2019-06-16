package com.app.graphql.repository;

import com.app.graphql.dto.City;
import com.app.graphql.dto.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountryRepository {

    @Select("select * from country where code = #{code}")
    Country findByCode(String code);

}
