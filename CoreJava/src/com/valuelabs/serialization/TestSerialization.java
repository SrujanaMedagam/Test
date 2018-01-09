package com.valuelabs.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestSerialization {
	public static void main(String args[]) throws IOException{
		Student st=new Student(1, "Srujana", "Hyd");
		FileOutputStream fos=new FileOutputStream("student.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(st);
		System.out.println("Serilaized");
		oos.close();
		fos.close();
		
		
		
	}

}
