package com.cixin.learning.base.cloneable;

import java.io.Serializable;

public class Brand implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand clone() {
        Brand b = new Brand();
        b.setName(this.getName());
        return b;
    }
}
