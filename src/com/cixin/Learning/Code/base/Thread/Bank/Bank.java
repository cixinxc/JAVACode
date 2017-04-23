package com.cixin.Learning.Code.base.Thread.Bank;

/**
 * Created by cixinxc on 2017/2/23.
 */
class MoneyThread extends Thread {
    private Bank bank;

    public MoneyThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println("Money1 取了："+bank.getMoney1(800));
        System.out.println("Money2 取了："+bank.getMoney2(800));
    }
}
public class Bank {
    private int money1 = 1000;
    private int money2 = 1000;
    public synchronized int getMoney1(int number)
    {
        if (number < 0)
        {
            return -1;
        }
        else if (number > money1)
        {
            return -2;
        }
        else if (money1 < 0)
        {
            return -3;
        }
        else
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            money1 -= number;

            System.out.println("1111111111  Left Money: " + money1);
            return number;
        }
    }
    public int getMoney2(int number)
    {
        if (number < 0)
        {
            return -1;
        }
        else if (number > money2)
        {
            return -2;
        }
        else if (money2 < 0)
        {
            return -3;
        }
        else
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            money2 -= number;

            System.out.println("2222222222  Left Money: " + money2);
            return number;
        }
    }
}
