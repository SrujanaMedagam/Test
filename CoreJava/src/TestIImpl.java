
public class TestIImpl implements TestI,TestI2 {
	@Override
	public void add() {
		System.out.println("Test");
		
	}

	public static void main(String[] args) {
		TestI i=new TestIImpl();
		i.add();

	}

	

}
