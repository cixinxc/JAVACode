package com.cixin.learning.base.cloneable;

import org.junit.Test;

import java.io.Serializable;

public class Car implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private int weight;
    private String number;
    private  Brand brand;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public Car clone() {
        Car car = new Car();
        car.setNumber(this.getNumber());
        car.setWeight(this.getWeight());
        car.setBrand(this.brand.clone());
        return car;
    }

}
