package com.dayu.pattern.delegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiankeqin
 * @Description: 相当于项目经理角色，我们只需要配置一个url即可。
 * 其他调用角色（大boss）只需要和项目经理角色打交道即可，即ServletDispatcher
 * @date 2019-07-04 10:59
 */
public class ServletDispatcher {

    private List<Handler> handlerMapping = new ArrayList<>();

    public ServletDispatcher() {
        try{
            Class<?> memberActionClass = MemberAction.class;
            //增加url映射
            handlerMapping.add(new Handler().setController(memberActionClass.newInstance()).setMethod(memberActionClass.getMethod("getMemberbyId",new Class[]{})).setUrl("/web/getMemberbyId.json"));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void doService(HttpServletRequest request, HttpServletResponse response){
        doDispatcher(request,response);
    }

    private void doDispatcher(HttpServletRequest request, HttpServletResponse response){
        //1.获取请求的url
            //如果按照J2EE标准，每个url对应一个Servlet，url由浏览器输入
        String url = request.getRequestURI();
        //2.Servlet拿到url以后，要做权衡（判断和选择）
            //根据用户请求的url，找到这个url对应的一个方法
            //handlerMapping中就是保存着映射关系

        //3.通过拿到Url去handlerMapping（我们把它认为是策略常量）
        Handler exeHandler = null;
        for(Handler handler : handlerMapping){
            if(handler.getUrl().equals(url)){
                exeHandler = handler;
                break;
            }
        }

        //4.将具体的任务分发给method（通过反射去调用对应的方法）
        Object result = null;
        try {
            result = exeHandler.getMethod().invoke(exeHandler.getController(),request.getParameter("param_name"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5.获取到Method执行的结果，通过Response返回出去
        try {
            response.getOutputStream().print(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}