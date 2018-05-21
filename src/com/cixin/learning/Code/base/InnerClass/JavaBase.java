package com.cixin.learning.Code.base.InnerClass;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class JavaBase {
    private String str = "baseOne";
    private String str2 = "baseOne2";
    private static String name = "baseName";
    private static String nickName = "baseNickName";
    private class ChirldBaseOne {
        private String str = "one";
        /*
        //报错：内部类不能有静态成员
        private static String name = "chirldOneName";
        */

        public void printStr() {
            System.out.println("Str is: "+str+" "+this.str+"    "+new JavaBase().str+"  "+str2);  //静态内部类不能直接访问外部类的非静态成员，但可以通过 new 外部类().成员 的方式访问
           }
    }

    public class ChirldBaseTwo {
        private String str = "two";
        private String name = "chirldOneName";
        public void printStr() {
            System.out.println("Str is: "+this.str);
        }
    }

    public static class ChirldThree {
        private String str = "ChirldThree";
        private String name = "chirldTwoName";
        public void printStr() {
            //静态内部类不能直接访问外部类的非静态成员，但可以通过 new 外部类().成员 的方式访问
            System.out.println("Str is: "+this.str+"    "+new JavaBase().str+"  "+new JavaBase().str2+" "+this.str);

            //如果外部类的静态成员与内部类的成员名称相同，可通过类名.静态成员访问外部类的静态成员；如果外部类的静态成员与内部类的成员名称不相同，则可通过成员名直接调用外部类的静态成员
            System.out.println("name is: "+this.name+"  "+JavaBase.name+"   "+nickName);
        }
    }

    public static void main(String[] args) {
        System.out.println("This is Test!");
        JavaBase javaBase = new JavaBase();
        ChirldBaseOne cbo = javaBase.new ChirldBaseOne();
        ChirldBaseTwo jbt = javaBase.new ChirldBaseTwo();

        cbo.printStr();
        jbt.printStr();
        /*
        //报错:不能这样创建
        ChirldBaseOne cbo2 = new ChirldBaseOne();
        cbo2.printStr();
        */

        //创建静态内部类的对象时，不需要外部类的对象，可以直接创建 内部类 对象名= new 内部类();
        ChirldThree ct = new ChirldThree();
        ct.printStr();
    }
}