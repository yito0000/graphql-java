package com.app.graphql.handler;

import com.app.graphql.dto.enums.Continent;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContinentTypeHandler extends BaseTypeHandler<Continent> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Continent parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public Continent getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Continent.findByValue(rs.getString(columnName));
    }

    @Override
    public Continent getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Continent.findByValue(rs.getString(columnIndex));
    }

    @Override
    public Continent getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Continent.findByValue(cs.getString(columnIndex));
    }
}
