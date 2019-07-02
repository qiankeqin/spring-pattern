package com.dayu.pattern.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiankeqin
 * @Description: Jdbc模板
 * @date 2019-07-02 13:18
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> execQuery(String sql, Object[] values){

        try{
            //1.获取连接
            Connection connection = dataSource.getConnection();
            //2.创建语句集
            PreparedStatement ps = connection.prepareStatement(sql);
            //3.执行语句集，并且获得结果集
            ResultSet resultSet = ps.executeQuery();
            //4.解析语句集
            List<Object> result = new ArrayList<>();
            int rowNum = 1;
            while(resultSet.next()){
                result.add(processResult(resultSet,rowNum));
                rowNum ++;
            }
            //5.关闭结果集
            resultSet.close();
            //6.关闭语句集
            ps.close();
            //7.关闭连接
            connection.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public abstract Object processResult(ResultSet rs,int rowNum);


}
