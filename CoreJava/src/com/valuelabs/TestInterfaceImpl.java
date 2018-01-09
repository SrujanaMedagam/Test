package com.valuelabs;

public class TestInterfaceImpl  {
	public static void main(String[] args) {

	TestInterface ti = new TestInterface(){
		@Override
		public void test() {
			System.out.println("test");
		}
		@Override
		public void test2() {
			System.out.println("test2354456");
		}
	};
	ti.test();
	ti.test2();

}
}
