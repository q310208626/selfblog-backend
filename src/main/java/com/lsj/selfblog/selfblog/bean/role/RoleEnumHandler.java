package com.lsj.selfblog.selfblog.bean.role;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.lsj.selfblog.selfblog.bean.role.BlogRole.ROLE;

public class RoleEnumHandler extends BaseTypeHandler<BlogRole.ROLE> {

    @Override
    public ROLE getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // TODO Auto-generated method stub
        return convert(rs.getString(columnName));
    }

    @Override
    public ROLE getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return convert(rs.getString(columnIndex));
    }

    @Override
    public ROLE getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return convert(cs.getString(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ROLE parameter, JdbcType jdbcType)
            throws SQLException {
        // TODO Auto-generated method stub
                ps.setString(i, parameter.getValue());
    }

    private BlogRole.ROLE convert(String roleValue) {
        if (roleValue == null) {
            return null;
        }

        for (ROLE value : BlogRole.ROLE.values()) {
            if (value.getValue().equals(roleValue)) {
                return value;
            }
        }

        return null;
    }
}
