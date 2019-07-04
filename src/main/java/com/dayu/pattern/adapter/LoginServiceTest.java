package com.dayu.pattern.adapter;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-04 15:04
 */
public class LoginServiceTest {
    public static void main(String[] args) {
        LoginForThirdService service = new LoginForThirdService();
        service.login("hello","123");
        service.loginForQQ("123");
    }
}