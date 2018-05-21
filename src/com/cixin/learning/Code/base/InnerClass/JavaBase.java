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
        //�����ڲ��಻���о�̬��Ա
        private static String name = "chirldOneName";
        */

        public void printStr() {
            System.out.println("Str is: "+str+" "+this.str+"    "+new JavaBase().str+"  "+str2);  //��̬�ڲ��಻��ֱ�ӷ����ⲿ��ķǾ�̬��Ա��������ͨ�� new �ⲿ��().��Ա �ķ�ʽ����
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
            //��̬�ڲ��಻��ֱ�ӷ����ⲿ��ķǾ�̬��Ա��������ͨ�� new �ⲿ��().��Ա �ķ�ʽ����
            System.out.println("Str is: "+this.str+"    "+new JavaBase().str+"  "+new JavaBase().str2+" "+this.str);

            //����ⲿ��ľ�̬��Ա���ڲ���ĳ�Ա������ͬ����ͨ������.��̬��Ա�����ⲿ��ľ�̬��Ա������ⲿ��ľ�̬��Ա���ڲ���ĳ�Ա���Ʋ���ͬ�����ͨ����Ա��ֱ�ӵ����ⲿ��ľ�̬��Ա
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
        //����:������������
        ChirldBaseOne cbo2 = new ChirldBaseOne();
        cbo2.printStr();
        */

        //������̬�ڲ���Ķ���ʱ������Ҫ�ⲿ��Ķ��󣬿���ֱ�Ӵ��� �ڲ��� ������= new �ڲ���();
        ChirldThree ct = new ChirldThree();
        ct.printStr();
    }
}