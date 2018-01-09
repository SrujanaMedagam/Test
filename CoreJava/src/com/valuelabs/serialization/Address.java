package com.valuelabs.serialization;

import java.io.Serializable;

public class Address implements Serializable {
	static String state;
	Address(String state){
		this.state=state;
	}

}
