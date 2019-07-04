package com.dayu.pattern.delegate.leader;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-04 12:42
 */
public class Boss {

    public static void main(String[] args) {
        Leader leader = new Leader();
        leader.doing("加密");
        leader.doing("解密");

    }
}