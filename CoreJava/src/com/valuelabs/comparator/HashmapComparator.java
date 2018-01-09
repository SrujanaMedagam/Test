package com.valuelabs.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class HashmapComparator {
	public static void main(String args[]) {
		//TreeSet<Student> al=new TreeSet<Student>(new AgeComparator());
	TreeSet<Student> al = new TreeSet<Student>(new NameComparator() );
		al.add(new Student(101, "Srujana", 33));
		al.add(new Student(106, "Srujana", 29));
		al.add(new Student(106, "Prema", 27));
		for(Student s:al){
			System.out.println("Name Compare::"+s);
		}
		/*TreeSet<Student> al2=new TreeSet<Student>(new AgeComparator());
		//ArrayList al = new ArrayList();
			al2.add(new Student(101, "Srujana", 43));
			al2.add(new Student(106, "Chandana", 33));
			al2.add(new Student(106, "prema", 27));
			for(Student s1:al2){
				System.out.println("Age Compare::"+s1);
			}
			*/
		
		/*TreeSet<Empl> nameComp = new TreeSet<Empl>(new MyNameComp());
        nameComp.add(new Empl("Ram",3000));
        nameComp.add(new Empl("John",6000));
        nameComp.add(new Empl("Crish",2000));
        nameComp.add(new Empl("Tom",2400));
        for(Empl e:nameComp){
            System.out.println(e);
        }*/
		
		
		/*Collections.sort(al, new NameComparator());
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			Student st = (Student) itr.next();
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		System.out.println("sorting by age...");

		Collections.sort(al, new AgeComparator());
		Iterator itr2 = al.iterator();
		while (itr2.hasNext()) {
			Student st = (Student) itr2.next();
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}*/

	}

	

}
