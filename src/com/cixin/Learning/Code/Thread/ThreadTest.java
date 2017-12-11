package com.cixin.Learning.Code.Thread;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

class ThreadOne extends Thread {
	private String flag = "";
	
	private Data data;  
	
	public ThreadOne(String flag) {
		this.flag = flag;
	}   
	
	public ThreadOne(Data data)     
	{          this.data = data;     }
//	public int get
	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		for(int i=0; i<58 ;i++) {
			System.out.println(flag + ":   i=" + i + "   ");
		}
	}
}

class ThreadTwo implements Runnable {
	private String flag = "";
	
	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		for(int i=0; i<58 ;i++) {
			System.out.println(flag + ":   i=" + i);
		}
	}
}

class ThreadThree implements Callable<String> {
	private String id;
	ThreadThree(String id) {
		this.id = id;
	}
	@Override
	public String call() {
		return "Success:"+id;
	}
}

class Data {
	private int data = 0;
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return this.data;
	}
}

public class ThreadTest {
	public static void main(String arg[]) {
		System.out.println("main function:");
//		
//		ThreadOne tdone = new ThreadOne();
//		tdone.start();
//		for(int i=0;i<200;i++)
//			for(int j=0;j<200;j++)
//				;
//		tdone.setFlag("aaaa");
	//	ThreadOne tdone2 = new ThreadOne();
	//	tdone2.start();
		
//		ThreadTwo tt = new ThreadTwo();
//		Thread Thread = new Thread(tt);
//		Thread.start();
//		
//		for(int i=0;i<200;i++)
//			for(int j=0;j<400;j++)
//				;
//		tt.setFlag("aaaa");
		/*
		Data data = new Data();
		ThreadOne tdone = new ThreadOne(data);
		tdone.start();
		for(int i=0;i<200;i++)
			for(int j=0;j<200;j++)
				;
		data.setData(33);
		
		for(int i=0;i<400;i++)
			for(int j=0;j<200;j++)
				;
		tdone.setFlag("aaaa");
		*/
		String aa = "qq";
		ThreadOne tdones = new ThreadOne(aa);
		tdones.start();
		aa = "ssss";
        tdones.interrupt();
		Thread t = new Thread(new ThreadTwo());
		//t.start();
		System.out.println("main function end:");
        //as(1, AA::as)

        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
        Car car = Car.create( Car::new );

	}

	static int num = 1;
    public static int as(int a, int b) {
        return 2;
    }

}

class Car {
    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }
}

class TestSample {
    public static int re() {
        return 1;
    }
}

interface A{
    default int sum(int a, int b) {
        return a+b;
    }
}
class AA {
    public static int as(int a, int b) {
        return a+b;
    }
}

