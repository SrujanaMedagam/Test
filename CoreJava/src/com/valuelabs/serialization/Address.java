package com.valuelabs.serialization;

import java.io.Serializable;

public class Address implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String state;
	Address(String state){
		Address.state=state;
	}

}
