package com.cixin.learning.jvm;

import java.io.*;

/**
 * @author cixinxc
 * @create 2018-05-23 22:44
 * @desc ���Բ��洴����������ַ���
 **/
public class NewObject {
    public static void main(String[] args) {
        // 1.new�ؼ���

        MyClass object1 = new MyClass("Object1");
        System.out.println(object1.getStr());
        try {
            // 2.ʹ��Class���newInstance()��
            MyClass object2 = (MyClass)Class.forName("com.cixin.learning.jvm.MyClass").newInstance();
            object2.setStr("object2");
            System.out.println(object2.getStr());
            // 3. ʹ��Constructor���newInstance()��
            MyClass object3 = (MyClass) com.cixin.learning.jvm.MyClass.class.newInstance();
            object3.setStr("object3");
            System.out.println(object3.getStr());

            System.out.println("2  "+object2);
            System.out.println("3  "+object3);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // 4. ʹ��clone()��
        MyClass object4 = object1.clone();
        System.out.println(object4.getStr());
        // 5. ʹ�÷����л���
        File file = new File("D:\\WorkSpace\\INTJWS\\JavaLearning\\src\\com\\cixin\\learning\\jvm\\file\\out.txt");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(object1);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("oos�ر�ʧ�ܣ�"+e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("�Ҳ����ļ���"+e.getMessage());
        } finally{
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("fos�ر�ʧ�ܣ�"+e.getMessage());
            }
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fis);
                try {
                    MyClass object5 = (MyClass)ois.readObject();
                    System.out.println(object5.getStr());
                    System.out.println("5  "+object5);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("ois�ر�ʧ�ܣ�"+e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("�Ҳ����ļ���"+e.getMessage());
        } finally{
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("fis�ر�ʧ�ܣ�"+e.getMessage());
            }
        }
        System.out.println("1  "+object1);

        System.out.println("4  "+object4);
        
    }
}

class MyClass implements Cloneable, Serializable {

    //private static final long serialVersionUID = 1L;

    private String str;

    public void setStr(String str) {
        this.str = str;
    }

    public MyClass() {

    }

    public MyClass(String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }

    @Override
    public MyClass clone() {
        return new MyClass(this.str);
    }


}

