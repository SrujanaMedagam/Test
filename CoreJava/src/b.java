
public class b extends a {
	public void m1(){
		System.out.println("m1 from b");
		System.out.println("Srujana");
		System.out.println("Srujana123");
	}
	public static void main(String args[]){
		a b=new b();
		b.m1();
		int i=4;
		char c='w';
		char y=(char) (i+c);
		System.out.println(y);
	}

}
