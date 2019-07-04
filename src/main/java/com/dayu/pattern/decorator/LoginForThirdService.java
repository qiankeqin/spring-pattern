package com.dayu.pattern.decorator;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-04 14:42
 */
public class LoginForThirdService implements ILoginForThirdService {

    private ILoginService loginService;

    /**
     * 对LoginService进行包装
     * @param loginService
     */
    public LoginForThirdService(ILoginService loginService) {
        this.loginService = loginService;
    }


    //-----------------------------------
    //-----------------------------------
    // 对原来对方法进行了升级，支持了QQ登录，微信登录等
    //
    //-----------------------------------

    @Override
    public ResultMsg loginForQQ(String openId){
        //1。oepnId是全局唯一的，我们可以把它当作一个用户名（加长）

        //2。密码默认为QQ_EMPTY

        //3。注册（在原有系统里面创建一个用户）
        loginService.register(openId,null);
        //4。调用原来的登录方法
        ResultMsg msg = loginService.login(openId, null);


        return msg;
    }

    @Override
    public ResultMsg loginForWechat(String wid){

        return null;
    }

    @Override
    public ResultMsg loginForToken(String token){

        return null;
    }


    //-----------------------------------
    //-----------------------------------
    // 保留了原来的方法和逻辑
    //
    //-----------------------------------

    @Override
    public ResultMsg register(String username, String password) {
        return loginService.register(username,password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return loginService.login(username,password);
    }
}