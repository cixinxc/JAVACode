package com.cixin.learning.Code.base.InnerClass;

/**
 * Created by cixinxc on 2017/2/27.
 */
public class Test {

    public static void changeBallName(Ball b, int a) {
        b.name = "aaa";
    }
    public static void changeBallName(int a, Ball b) {
        b.name = "aaa";
    }
    public static void main(String[] arg) {
        /*
        Ball b1 = new Ball("ball  1");
        System.out.println("b1' name is : "+b1);
        System.out.println("b1' name is : "+b1.name);
        changeBallName(b1, 1);
        System.out.println("b1' name is : "+b1.name);
        System.out.println("b1' name is : "+b1);

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;

        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s2);
        System.out.println(s1 == s5.intern());
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
        */
        Ball ball = new Ball();
        Balls balls = new Balls();
        System.out.println(ball.getId()+"     "+balls.getId());
        System.out.println("name    "+ball.name+"     "+balls.name);

        balls.show1();
        balls.show2();
    }
}
class Ball {
    private int id = 1;
    public String name = "1";
    public Ball() {
        System.out.print("\nBall' 构造");
    }
    public Ball(String name) {
        this.name = name;
    }
    public int getId() {
        System.out.println("Ball' getId()");
        return id;
    }
    public void setId(int id) {
        System.out.println("Ball' setId()");
        this.id = id;
    }

    public void show1() {
        System.out.print("\nball show1  ");
    }
    public void show2() {
        System.out.print("\nball show2  ");
    }
}

class Balls extends Ball {
    private int id = 2;
    public String name = "2";
    public Balls() {
        //super();
        System.out.println("Balls' 构造");
    }
    public int getId() {
        System.out.println("Balls' getId()");
        return id;
    }
    public void setId(int id) {
        System.out.println("Balls' setId()");
        this.id = id;
    }
    public void show1() {
        super.show1();
        System.out.println("balls show1");
    }
}
