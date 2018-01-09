package com.valuelabs.Interface.Absratact;

public class OverLoading {
	public final void add(int x){
		System.out.println("int x");
	}
	public final static void add(double x){
		System.out.println("double x");
	}

	public static  void main(String[] args){
		OverLoading ol=new OverLoading();
		ol.add(4d);
		ol.add(3);
	}

}
