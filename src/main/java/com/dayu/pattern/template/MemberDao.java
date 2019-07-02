package com.dayu.pattern.template;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-02 13:30
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Object processResult(ResultSet rs, int rowNum) {
        Member member = new Member();
        try {
            member.setUserName(rs.getString("username"));
            member.setPassword(rs.getString("password"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return member;
    }
}