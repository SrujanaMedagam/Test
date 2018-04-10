package com.valuelabs.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestSerialization {
	final public static void main(String args[]) throws IOException{
		Address add=new Address("AP");
		Student st=new Student(1, "Srujana","Srujana", "Hyd",add);
		FileOutputStream fos=new FileOutputStream("d://student.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(st);
		System.out.println("Serilaized");
		oos.close();
		fos.close();
		System.out.println("sruajan");
		
		
		
	}

}
