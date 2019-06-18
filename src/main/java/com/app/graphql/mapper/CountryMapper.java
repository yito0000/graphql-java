package com.app.graphql.mapper;

import com.app.graphql.dto.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountryMapper {

    @Select("select * from country where code = #{code}")
    Country findByCode(String code);

}
