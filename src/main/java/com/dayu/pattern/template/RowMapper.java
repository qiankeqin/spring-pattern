package com.dayu.pattern.template;

import java.sql.ResultSet;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-03 08:38
 */
public interface RowMapper<T> {
    public T mapRow(ResultSet rs,int rowNum) throws Exception;
}