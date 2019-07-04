package com.dayu.pattern.adapter;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-04 14:42
 */
public class LoginForThirdService extends LoginService {

    public ResultMsg loginForQQ(String openId){
        //1。oepnId是全局唯一的，我们可以把它当作一个用户名（加长）

        //2。密码默认为QQ_EMPTY

        //3。注册（在原有系统里面创建一个用户）
        super.register(openId,null);
        //4。调用原来的登录方法
        ResultMsg msg = super.login(openId, null);


        return msg;
    }

    public ResultMsg loginForWechat(String wid){

        return null;
    }

    public ResultMsg loginForToken(String token){

        return null;
    }


}