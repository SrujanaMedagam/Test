
public class TestFinal {
	final int x;
	
	TestFinal(int p){
		this.x=p;
		
	}
	

	public static void main(String[] args) {
		TestFinal t1=new TestFinal(5);
		System.out.println(t1.x);
		TestFinal t2=new TestFinal(15);
		System.out.println(t2.x);
		
		

	}

}
