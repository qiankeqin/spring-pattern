package com.dayu.pattern.template;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiankeqin
 * @Description: Jdbc模板
 * @date 2019-07-02 13:18
 */
public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> execQuery(String sql,RowMapper rowMapper, Object[] values){

        try{
            //1.获取连接
            Connection connection = getConnection();
            //2.创建语句集
            PreparedStatement ps = createPreparedStatement(connection,sql);
            //3.执行语句集，并且获得结果集
            ResultSet resultSet = executeQuery(ps,values);
            //4.解析语句集
            List<?> result = processResult(rowMapper, resultSet);
            //5.关闭结果集
            closeResult(resultSet);
            //6.关闭语句集
            closeStatement(ps);
            //7.关闭连接
            closeConnection(connection);
            //8.返回
            return result;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    public abstract Object processResult(ResultSet rs,int rowNum);

    public List<?> processResult(RowMapper rowMapper,ResultSet resultSet) throws Exception {
        List<Object> result = new ArrayList<>();

        int rowNum = 1;
        while(resultSet.next()){
            result.add(rowMapper.mapRow(resultSet, rowNum));
            rowNum ++;
        }
        return result;
    }

    private Connection getConnection() throws SQLException {
        Connection connection = this.dataSource.getConnection();
        return connection;
    }

    private PreparedStatement createPreparedStatement(Connection conn,String sql) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        return preparedStatement;
    }

    private ResultSet executeQuery(PreparedStatement ps,Object[] values) throws SQLException {
        for(int i=0;i<values.length;i++){
            ps.setObject(i,values[i]);
        }
        return ps.executeQuery();
    }

    private void closeStatement(Statement st) throws SQLException {
        st.close();
    }

    private void closeResult(ResultSet rs) throws SQLException {
        rs.close();
    }

    private void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
