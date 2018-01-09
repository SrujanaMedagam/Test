package com.valuelabs.strings;

public final class ImmutableClass {
	private int id;
	private String name;
	private Address address;

	private ImmutableClass(int id, String name,Address address) {
		this.id = id;
		this.name = name;
		this.address=address;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public Address getAddress(){
		return address;
	}

	public static ImmutableClass createNewInstance(int id, String name,Address address) {
		return new ImmutableClass(id, name,address);
	}

	public String toString() {
		return id + "-" + name+"-"+address.getState();
	}

}
