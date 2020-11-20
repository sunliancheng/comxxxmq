package com.xxx.designPattern.prototype;

import java.io.Serializable;

public class DeepClone implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String cloneName;
    private String cloneClass;

    public DeepClone(String cloneClass, String cloneName) {
        this.cloneClass = cloneClass;
        this.cloneName = cloneName;
    }

    //
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
