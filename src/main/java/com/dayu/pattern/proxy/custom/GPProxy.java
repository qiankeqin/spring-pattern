package com.dayu.pattern.proxy.custom;

import java.lang.reflect.Method;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-28 09:22
 */
public class GPProxy {

    private static final String ln = "\r\n";

    private static final String tab = "    ";


    public static Object newProxyInstance(GPClassLoader classLoader,Class<?>[] interfaces,GPInvocationHandler gpInvocationHandler){
        //1 动态生产源代码.java文件
        generateSrc(interfaces);
        //2。Java文件输出到磁盘

        //3。把生产到Java文件变异成.class文件

        //4。编译生产到.class文件加载到Jvm中

        //5。返回字节码重组以后到新到代理对象

        return null;
    }

    private static void generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.dayu.pattern.proxy.custom;"+ln);
        sb.append("import com.dayu.pattern.proxy.Person;"+ln);
        sb.append("public class $Proxy0 implements "+ interfaces[0].getName() + "{" + ln);
        sb.append(tab + "GPInvocationHandler h;"+ln);
        sb.append(tab + "public $Proxy0(GPInvocationHandler h) {"+ln);
        sb.append(tab + tab + "this.h = h;" + ln);
        sb.append(tab + "}" + ln);

        for (Method method : interfaces[0].getMethods()) {
            sb.append(tab + "public " + method.getReturnType() + " " + method.getName() + "() {"+ln);
            sb.append(tab + tab + "try {" + ln);
            sb.append(tab + tab + tab + "Method m = " + ln);
            sb.append(tab + tab + "} catch(Exception e) {"+ln);
            sb.append(tab + tab + tab + "e.printStackTrace();" + ln);
            sb.append(tab + tab + "}" + ln);
        }

    }
}