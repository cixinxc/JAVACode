package com.cixin.Learning.Code.base.Abstract;

/**
 * Created by cixinxc on 2017/2/22.
 */
//�����ֻ࣬��֪��Ҫ������Щ���������治֪׼ȷ��ʵ��ϸ��
//����Լ�����࣬�Գ�����Ϊģ�壬����������Ƶ�������
//abstract���γ�����
public abstract class Person {

    //�������п��԰�����ͨ�ķ�����Ҳ����û�г��󷽷�
    public void showMe() {
        System.out.print("\n I am a Person" );
    }
    //���෽������׼����������д
    public void showUse() {
        System.out.println("���෽������׼����������д");
    }

    //abstract���η�����ֻ��������ʵ��          �������󷽷�������ǳ�����
    public abstract void abFunction();
}
