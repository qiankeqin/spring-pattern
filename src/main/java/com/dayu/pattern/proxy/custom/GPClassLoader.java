package com.dayu.pattern.proxy.custom;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-28 09:24
 */
public class GPClassLoader extends ClassLoader{

    private File classPathFile ;

    public GPClassLoader() {
        String path = GPClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;

        if(classPathFile!= null){
            File classFile = new File(classPathFile ,name.replaceAll("\\.","/") + ".class");
            if(classFile.exists()){
                int len;
                byte[] buf = new byte[1024];
                try(FileInputStream fis =  new FileInputStream(classFile);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream()){
                    while((len = fis.read(buf))!=-1){
                        bos.write(buf,0,len);
                    }
                    return defineClass(className,bos.toByteArray(),0,bos.size());
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}