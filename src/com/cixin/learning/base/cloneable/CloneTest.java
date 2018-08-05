package com.cixin.learning.base.cloneable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CloneTest {
    public static void main(String[] args) {
        Brand brand = new Brand();
        brand.setName("宝马");

        Car car1 = new Car();
        Car car2;
        Car car3;
        car1.setNumber("1");
        car1.setWeight(200);
        car1.setBrand(brand);
        car2 = car1.clone();

        System.out.println(car1==car2);
        System.out.println(car1.getBrand()==car2.getBrand());

        try {
            // 读取对象字节数据
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(car1);
            oos.close();
            // 分配内存空间，写入原始对象，生成新对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            //返回新对象，并做类型转换
            car2 = (Car)ois.readObject();
            ois.close();

            ByteArrayInputStream bais2 = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois2 = new ObjectInputStream(bais2);
            car3 = (Car)ois2.readObject();


            System.out.println(car1==car2);
            System.out.println(car1.getBrand()==car2.getBrand());
            System.out.println(car2.getBrand()==car3.getBrand());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
