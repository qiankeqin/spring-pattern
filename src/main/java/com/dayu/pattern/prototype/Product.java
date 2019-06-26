package com.dayu.pattern.prototype;

import java.io.*;

public class Product implements Cloneable,Serializable{
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
        try {
            return deepClone();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object deepClone() throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Product o = (Product)ois.readObject();

            return o;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
