package com.dayu.pattern.decorator;


/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-04 19:35
 */
public interface ILoginForThirdService extends ILoginService{
    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String wid);

    ResultMsg loginForToken(String token);

}
