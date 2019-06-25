package com.dayu.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeC implements Cloneable{

    private String name ;
    private List list = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeC pro = new PrototypeC();
        pro.setList(new ArrayList());
        pro.setName("hello");
        pro.getList().add("1");
        System.out.println(pro);

        Object clone = pro.clone();
        PrototypeC clone1 = (PrototypeC) clone;
        System.out.println(clone1);
        System.out.println(clone);
        System.out.println("array="+((PrototypeC) clone).getList().get(0));
    }
}
