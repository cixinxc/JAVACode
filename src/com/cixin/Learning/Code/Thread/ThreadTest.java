package com.cixin.Learning.Code.Thread;

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

	public void run() {
		for(int i=0; i<58 ;i++)
			System.out.println(flag +":   i="+i+"   ");
	}
}

class ThreadTwo implements Runnable {
	private String flag = "";
	
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void run() {
		for(int i=0; i<58 ;i++)
			System.out.println(flag +":   i="+i);
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
		
		System.out.println("main function end:");
	}
}
