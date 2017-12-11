package com.cixin.Learning.Code.Thread;

public class TestSynchronized {
    public void test1() {
        synchronized(this) {
            int i = 5;
            while( i-- > 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try{
                    Thread.sleep(500);
                } catch (InterruptedException ie){
                }
            }
        }
    }

    public synchronized void isSyncA() {
        int i = 105;
        while( i-- > 0){
            System.out.println(Thread.currentThread().getName() + " : " + i);
            /*
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ie){
            }*/
        }
    }

    public   void isSyncB(){
        int i = 105;
        synchronized(this)
        {
        while( i-- > 0){
            System.out.println(Thread.currentThread().getName() + " : " + i);
            /*
            try {
                Thread.sleep(500);
            }catch (InterruptedException ie){
            }*/
        }}
    }

    public static synchronized void cSyncA(){
        int i = 105;
        while( i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            /*
            try{
                Thread.sleep(500);
            }catch (InterruptedException ie){
            }*/
        }
    }
    public static void cSyncB() {
        int i = 105;
        synchronized(Integer.class){}   // ������
        synchronized(TestSynchronized.class)
        {
        }
        while( i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            /*
            try{
                Thread.sleep(500);
            }catch (InterruptedException ie){
            }*/
        }
    }
    public static void main(String[] args) {    final TestSynchronized myt1 = new TestSynchronized();
        final TestSynchronized x = new TestSynchronized();
        final TestSynchronized y = new TestSynchronized();
        //ͬһ��ʵ������ͬ��synchronized��������������Լ����ͬһ�����󡪡�������������a. x.isSyncA()��x.isSyncB()
         /*
         Thread test1 = new Thread(  new Runnable() {  public void run() { x.isSyncA();  }  }, "test1"  );
         Thread test2 = new Thread(  new Runnable() {  public void run() { x.isSyncB();   }  }, "test2"  );
*/
        //ͬһ��ʵ������ͬ��synchronized��������������Լ������ͬ�Ķ��󡪡�������������a. x.isSyncA()��x.isSyncB()
         /*
         Thread test1 = new Thread(  new Runnable() {  public void run() { x.isSyncA();  }  }, "test1"  );
         Thread test2 = new Thread(  new Runnable() {  public void run() { x.isSyncA();   }  }, "test2"  );
*/
        //��ͬ��ʵ����ͬһ��synchronized������������û��Լ������ͬ�Ķ��󡪡�������������b. x.isSyncA()��y.isSyncA()
        /*
         Thread test1 = new Thread(  new Runnable() {  public void run() {  x.isSyncB();  }  }, "test1"  );
         Thread test2 = new Thread(  new Runnable() {  public void run() { y.isSyncB();   }  }, "test2"  );
*/

        //��ͬ��ʵ������ͬ��static synchronized��������������Լ������ͬ�Ķ���������c. x.cSyncA()��y.cSyncB()
         /*
         Thread test1 = new Thread(  new Runnable() {  public void run() {  x.isSyncA();  }  }, "test1"  );
         Thread test2 = new Thread(  new Runnable() {  public void run() { y.isSyncB();   }  }, "test2"  );
*/
        //��ͬ��ʵ������ͬ��static synchronized��������������Լ������ͬ�Ķ���������c. x.cSyncA()��y.cSyncB()
         /*
        Thread test1 = new Thread(  new Runnable() {  public void run() {  x.cSyncA();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() { y.cSyncB();   }  }, "test2"  );
        */
        //��ͬ��ʵ������ͬ��static synchronized��������������Լ������ͬ�Ķ���������c. x.cSyncA()��y.cSyncB()
         /*
        Thread test1 = new Thread(  new Runnable() {  public void run() {  x.cSyncA();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() { y.cSyncA();   }  }, "test2"  );
*/
        //��ͬ��ʵ������ͬ��static synchronized��������������Լ������ͬ�Ķ���������c. x.cSyncA()��y.cSyncB()
         /**/
        Thread test1 = new Thread(  new Runnable() {  public void run() {  x.cSyncA();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() { x.cSyncB();   }  }, "test2"  );

        //��ͬ��ʵ������ͬ��static synchronized��������������Լ������ͬ�Ķ���������c. x.cSyncA()��y.cSyncB()
         /*
        Thread test1 = new Thread(  new Runnable() {  public void run() {  x.cSyncA();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() { x.cSyncA();   }  }, "test2"  );
*/
        //��ʵ���޹أ�����������������Ӱ�졪��d. x.isSyncA()��Something.cSyncA()
        /*
        Thread test1 = new Thread(  new Runnable() {  public void run() {  x.isSyncA();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() {y.cSyncA();   }  }, "test2"  );
*/
        //��ͬʵ��������������������Ӱ�졪��d. x.isSyncA()��Something.cSyncA()
        /*
        Thread test1 = new Thread(  new Runnable() {  public void run() {  x.isSyncA();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() {x.cSyncA();   }  }, "test2"  );
*/
        test1.start();
        test2.start();

    }

}