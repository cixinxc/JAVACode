package com.cixin.Learning.Code.base.Polymorphism;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class Test {
    public static void main(String[] arg) {
        //���ö�̬:һ�㸸������ÿ���ָ����Ķ���
        Person person = new Person();
        Person father = new Father();
        Person mother = new Mother();

        person.showMe();    //���಻�ܵ������෽��
        father.showMe();    //���������д�����еķ���
        mother.showMe();    //������ôӸ���̳еķ���

        //��������ת��
        //�Ӹߵ����ɼ�����Զ����:��ʽת��
        //�ӵ͵�����������գ���Ҫ�ֶ�ǿ��ת��
        Father f = new Father();
        Person p = f;                   //�ɸߵ���
        Mother m1 = (Mother)person;     //�ӵ͵���
        //Mother m2 = (Mother)p;          //�ӵ͵���,������û����,���������л��������
        //Mother m3 = (Mother)father;   //������û����,���������л��������
        //Mother m4 = (Mother)f;          //����������
    }
}
