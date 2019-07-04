package com.dayu.pattern.decorator;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-04 19:13
 */
public class DecoratorTest {
    public static void main(String[] args) {
        InputStream is = null;
        //虽然DataInputStram功能更加强大
        //DataInputStream同样要实现inputStream，
        FilterInputStream fis = new DataInputStream(is);
    }
}