public class TestException {
	boolean method1(){
		try{
			
			System.out.println("Srujana");
		System.exit(-1);
			return true;
			
		}catch(Exception e){
			System.out.println("Ex");
		}
		finally{
			System.out.println("finally");try{
				
			
			int i=10/0;
			}catch(ArithmeticException e){
				System.out.println("ArithmeticException catch from finally ");
			}finally{
				System.out.println("ArithmeticException from finally finally");
			}
		}
		return false;
	}public static void main(String args[]){
		TestException t=new TestException(); 
		System.out.println(t.method1());
		
	}

}
