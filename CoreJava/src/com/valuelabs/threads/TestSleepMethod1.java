package com.valuelabs.threads;
class TestSleepMethod1 implements Runnable{  
 public void run(){  
  for(int i=1;i<5;i++){  
    try{
    	//Thread.yield();
    	Thread.sleep(5000);
    	}catch(InterruptedException e){System.out.println(e);}  
    System.out.println(i);  
  }  
 }  
 public static void main(String args[]){  
  TestSleepMethod1 t1=new TestSleepMethod1();  
  TestSleepMethod1 t2=new TestSleepMethod1();  
   Thread t = new Thread(t1);
   Thread t0 = new Thread();
   Thread t4 = new Thread(t1);
  t.start();  
  //t0.start();
  t4.start();
 }  
}   