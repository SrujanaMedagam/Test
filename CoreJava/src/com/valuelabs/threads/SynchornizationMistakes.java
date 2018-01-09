package com.valuelabs.threads;
public class SynchornizationMistakes {
    private static int count = 0;
  
    //locking on this object lock
    public synchronized int getCount(){
    	increment();
        return count;
    }
  
    //locking on .class object lock
    public static synchronized void increment(){
       for(int i=0;i<5;i++){
        System.out.println( count++);}
    }
    public static void main(String srgs[]){
    	SynchornizationMistakes s=new SynchornizationMistakes();
    	s.getCount();
    	
    	
    }
    
}

