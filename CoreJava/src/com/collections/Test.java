package com.collections;
import java.util.HashMap;
import java.util.Map;

/*interface i{
	void ma();
}

class Test0{
	public void ma(){
		System.out.println("this is ma() : test0");
	}
}





public class Test extends Test0 implements i {

	public void ma(){
		System.out.println("this is ma() : test");
	}
	public static void main(String[] dhana){
i i1= new Test();
Test0 t = new Test();
Test0 t2 = new Test0();


i1.ma();
t.ma();
t2.ma();
}


}*/


public class Test {
	public static void main(String[] dhana){
	Map hm = new HashMap();
	Employee e = new Employee();
	
	hm.put(e, "emp"); 
	e.setName("natraj");
	System.out.print(hm.get(e));  
	}
	
}