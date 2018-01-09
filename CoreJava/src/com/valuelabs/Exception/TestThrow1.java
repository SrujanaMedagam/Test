package com.valuelabs.Exception;

import java.io.IOException;

public class TestThrow1{  
   static void validate(int age) throws IOException {  
     if(age<18)  
      throw new ArithmeticException("not valid age"); 
    // throw new ArithmeticException("not valid age"); 
     else  
      System.out.println("welcome to vote");  
   }  
   public static void main(String args[]) {
	   try{
      validate(13);  
	   }
	   catch(ArithmeticException e){
		   System.out.println(e);
	   }catch(IOException ae){
		   System.out.println(ae);
	   }
	   //validate(13);  
      System.out.println("rest of the code...");  
  }  
}  