package com.valuelabs.threads;

public class TestRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=5;i++){
			System.out.println(i);
		}
	System.out.println("Executing");
		
	}
	public static void main(String args[]){
		TestRunnable t1 = new TestRunnable();
		TestRunnable t2 = new TestRunnable();
		/*Thread t1=new Thread(t);
		Thread t2=new Thread(t);*/
		/*t1.run();
		t2.run();*/
		t1.run();
		t2.run();
	}

}
