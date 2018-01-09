
public class ObjectCount {
	static int  count=0;
	{
		System.out.println("block1");
		count++;
	}
	 ObjectCount(){
		 int i=10;
		 System.out.println(i);
		System.out.println("constructor"+count);
		i=i+10;
	}
	public static void main(String args[]) throws CloneNotSupportedException{
		ObjectCount o1=new ObjectCount();
		ObjectCount o2=new ObjectCount();
		System.out.println(count);
		//ObjectCount oc= (ObjectCount) o2.clone();
		o2.getClass();
	}

}
