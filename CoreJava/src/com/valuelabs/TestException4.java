package com.valuelabs;


import java.io.IOException;

public class TestException4 {

	public void start() throws IOException{		
	}
	
	public void foo() throws NullPointerException{
		
	}
}

class TestException5 extends TestException4{
	
	public void start() throws RuntimeException{
	}
	
	public void foo() throws RuntimeException{
		
	}
}