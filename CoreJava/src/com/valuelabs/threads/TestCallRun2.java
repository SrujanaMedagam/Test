package com.valuelabs.threads;
class TestCallRun2 extends Thread{  
 public void run(){  
  for(int i=1;i<5;i++){  
    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
    System.out.println(i);  
  }  
 }  
 public static void main(String args[]){  
  TestCallRun2 t1=new TestCallRun2();  
  TestCallRun2 t2=new TestCallRun2();  
   /*Thread t=new Thread(t1);
   Thread t3=new Thread(t2);
   t.start();
   t3.start();*/
  t1.run();  
  t2.run(); 
 }  
}  