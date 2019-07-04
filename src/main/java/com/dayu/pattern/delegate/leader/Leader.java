package com.dayu.pattern.delegate.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-04 12:42
 */
public class Leader implements IEmployee{

    private Map<String,IEmployee> employeeMap = new HashMap<>();

    public Leader() {
        employeeMap.put("加密",new Employee1());
        employeeMap.put("解密",new Employee2());
    }

    @Override
    public void doing(String cmd){
        //分配给员工干货
        employeeMap.get(cmd).doing(cmd);
    }
}