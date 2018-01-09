
public class InstanceStatic {
	int i=10;
	static int j=20;
	
	public void meth(){
		
		System.out.println(i);
		System.out.println(j);
		i=i+10;
		j=j+10;
	}
	
	public static void main(String args[]){
		InstanceStatic i=new InstanceStatic();
		i.meth();
		InstanceStatic i2=new InstanceStatic();
		i2.meth();
	}

}
