package com.cixin.Learning.Code.base.Thread.Bank;

/**
 * Created by cixinxc on 2017/2/23.
 */
public class Test {
    public static void main(String[] arg) {
        Bank bank = new Bank();

        Thread t1 = new MoneyThread(bank);// 从银行取钱
        Thread t2 = new MoneyThread(bank);// 从取款机取钱

        t1.start();
        t2.start();
    }
}
