package com.valuelabs.extanalization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExtranalizationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Employee e=new Employee(1485,"srujana","Hyd");
		FileOutputStream fos=new FileOutputStream("d://student.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(e);
		
		
		FileInputStream fis=new FileInputStream("d://student.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Employee emp = (Employee) ois.readObject();
		System.out.println(emp.eid);
		System.out.println(emp.address);

	}

}
