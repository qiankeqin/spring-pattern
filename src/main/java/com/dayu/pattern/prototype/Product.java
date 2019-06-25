package com.dayu.pattern.prototype;

public class Product implements Cloneable{
    private String name;
    private PcC pcC;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PcC getPcC() {
        return pcC;
    }

    public void setPcC(PcC pcC) {
        this.pcC = pcC;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
