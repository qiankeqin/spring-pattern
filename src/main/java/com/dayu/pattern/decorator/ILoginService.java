package com.dayu.pattern.decorator;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-04 19:30
 */
public interface ILoginService {
    ResultMsg register(String username, String password);

    ResultMsg login(String username, String password);
}
