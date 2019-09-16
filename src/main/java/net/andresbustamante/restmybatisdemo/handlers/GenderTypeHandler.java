package net.andresbustamante.restmybatisdemo.handlers;

import net.andresbustamante.restmybatisdemo.enums.GenderEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderTypeHandler extends BaseTypeHandler<GenderEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, GenderEnum gender, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, gender.getId());
    }

    @Override
    public GenderEnum getNullableResult(ResultSet rs, String s) throws SQLException {
        return GenderEnum.forId(rs.getInt(s));
    }

    @Override
    public GenderEnum getNullableResult(ResultSet rs, int i) throws SQLException {
        return GenderEnum.forId(rs.getInt(i));
    }

    @Override
    public GenderEnum getNullableResult(CallableStatement cs, int i) throws SQLException {
        return GenderEnum.forId(cs.getInt(i));
    }
}
