package com.valuelabs.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestDeserilized {
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		FileInputStream fis=new FileInputStream("d://student.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Student student = (Student) ois.readObject();
		
		System.out.println("desrerilized");
		System.out.println("id:"+student.id);
		System.out.println("pwd:"+student.pwd);
		
		System.out.println("name:"+student.name);
		System.out.println("contact:"+student.contact);
		System.out.println(student.address);
		ois.close();
		fis.close();
		
		
		
	}
}
 