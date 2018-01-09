
public class Febonocci {
	public static void main(String args[]){
		int count=10;
		int n1=0,n2=1,n3=0;
		System.out.print(n1+ " "+n2+" ");
		while(count>1){
			n3=n1+n2;
			System.out.print(" " +n3);
			n1=n2;
			n2=n3;
			count--;
			
		}
		
		
	}

}
