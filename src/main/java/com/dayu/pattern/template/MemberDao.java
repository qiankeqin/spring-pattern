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

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> query(){
        String sql = "select * from member";
        return jdbcTemplate.execQuery(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                try {
                    member.setUserName(rs.getString("username"));
                    member.setPassword(rs.getString("password"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return member;
            }
        },null);
    }
}