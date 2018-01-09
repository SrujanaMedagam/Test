package com.valuelabs.threads;

public class TestThread extends Thread{
	public void run(){
		for(int i=1;i<=5;i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
		System.out.println("Thread executed");
	}
	public static void main(String args[]){
		TestThread t = new TestThread();
		t.start();
	}

}
