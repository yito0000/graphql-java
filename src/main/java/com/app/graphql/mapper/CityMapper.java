package com.app.graphql.mapper;

import com.app.graphql.dto.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    City findById(Integer id);
}
