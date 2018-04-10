package com.valuelabs.extanalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee implements Externalizable {
	int eid;
	String ename;
	String address;
	public Employee(){
		System.out.println("default constructor");
	}
	public Employee(int eid, String ename, String address) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.address = address;
	}
	@Override
	public void readExternal(ObjectInput oi) throws IOException, ClassNotFoundException {
this.eid = oi.readInt();
		
	}
	@Override
	public void writeExternal(ObjectOutput oo) throws IOException {
oo.writeInt(eid);		
	}
	

}
