package com.valuelabs;

public class OverloadingImpl extends Overloading {
	int add(int x,int y){
		System.out.println("two");
		return y;
	}

	public static void main(String[] args) {
		OverloadingImpl i =new OverloadingImpl();
		i.add();
		i.add(5);
		i.add(2, 4);
	}

}
