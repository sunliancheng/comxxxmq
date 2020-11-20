package com.xxx.designPattern.prototype;

import java.io.*;

public class Prototype implements Cloneable, Serializable {


    public String name = "hello world";

    public DeepClone deepClone = new DeepClone("", "");

    Prototype() {}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;

        //完成对基本数据类型的clone
        deep = super.clone();

        //对引用类型的数据单独处理
        //Prototype deepTarget = (Prototype) deep;
        //deepTarget.deepClone = (DeepClone) deepClone.clone();

        return deep;
    }

    public Prototype deepClone() throws IOException {
        Prototype prototype = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            //把当前这个对象以对象流的方式输出
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            prototype = (Prototype) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bos.close();
            oos.close();
            bis.close();
            ois.close();
        }
        return prototype;

    }
}
