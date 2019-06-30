package com.dayu.pattern.proxy.custom;

import sun.misc.ProxyGenerator;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-28 09:22
 */
public class GPProxy {

    private static final String ln = "\r\n";

    private static final String tab = "    ";


    public static Object newProxyInstance(GPClassLoader classLoader,Class<?>[] interfaces,GPInvocationHandler gpInvocationHandler) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1 动态生产源代码.java文件
        String src = generateSrc(interfaces);
        //2。Java文件输出到磁盘
        String filePath = GPProxy.class.getResource("").getPath();
        System.out.println(filePath);
        File file = new File(filePath + "$Proxy0.java");
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(src);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //3。把生产到Java文件变异成.class文件
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable iterable = fileManager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, iterable);
        task.call();
        fileManager.close();


        //4。编译生产到.class文件加载到Jvm中
        Class $Proxy0 = classLoader.findClass("$Proxy0");
        Constructor constructor = $Proxy0.getConstructor(GPInvocationHandler.class);
        file.delete();

        //5。返回字节码重组以后到新到代理对象

        return constructor.newInstance(gpInvocationHandler);
    }

    /**
     * 构建源码内容
     * @param interfaces
     * @return
     */
    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.dayu.pattern.proxy.custom;"+ln);
        sb.append("import com.dayu.pattern.proxy.Person;"+ln);
        sb.append("import java.lang.reflect.Method;"+ln);
        sb.append("public class $Proxy0 implements "+ interfaces[0].getName() + "{" + ln);
        sb.append(tab + "GPInvocationHandler h;"+ln);
        sb.append(tab + "public $Proxy0(GPInvocationHandler h) {"+ln);
        sb.append(tab + tab + "this.h = h;" + ln);
        sb.append(tab + "}" + ln);

        for (Method method : interfaces[0].getMethods()) {
            sb.append(tab + "public " + method.getReturnType() + " " + method.getName() + "() {"+ln);
            sb.append(tab + tab + "try {" + ln);
            sb.append(tab + tab + tab + "Method m = " + interfaces[0].getName() + ".class.getMethod(\""+method.getName()+"\",new Class[]{});" + ln);
            sb.append(tab + tab + tab + "this.h.invoke(this,m,null);" + ln);
            sb.append(tab + tab + "} catch(Throwable e) {"+ln);
            sb.append(tab + tab + tab + "e.printStackTrace();" + ln);
            sb.append(tab + tab + "}" + ln);
        }

        sb.append(tab + "}" + ln);
        sb.append("}" + ln);

        return sb.toString();
    }

    private static String tab(int i){
        String tabStr = "";
        while(i-->0){
            tabStr += tab;
        }
        return tabStr;
    }
}