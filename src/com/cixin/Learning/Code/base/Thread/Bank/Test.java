package com.cixin.Learning.Code.base.Thread.Bank;

/**
 * Created by cixinxc on 2017/2/23.
 */
public class Test {
    public static void main(String[] arg) {
        Bank bank = new Bank();

        Thread t1 = new MoneyThread(bank);// ������ȡǮ
        Thread t2 = new MoneyThread(bank);// ��ȡ���ȡǮ

        t1.start();
        t2.start();
    }
}
