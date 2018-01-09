package com.valuelabs.strings;

public class ImmutableClassTest {

	public static void main(String[] args) {
		ImmutableClass im = ImmutableClass.createNewInstance(1, "Srujan",new Address("AP"));
		System.out.println(im);
		modifyImmutableClassObject(im.getId(),im.getName(),im.getAddress());
		System.out.println(im);
	
			

	}

	private static void modifyImmutableClassObject(int id1, String name1,Address address) {
		id1=2;
		name1="Sai";
		address=new Address("TS");
	}

}
