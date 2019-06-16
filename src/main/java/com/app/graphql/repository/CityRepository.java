package com.app.graphql.repository;

import com.app.graphql.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityRepository {

    @Select("select * from city where id = #{id}")
    City findById(Integer id);
}
