package com.valuelabs;

public class SwitchTest {

	public static void main(String[] args) {
		int i=3;
		/*switch(i){
		case 1:System.out.println("1");break;
		case 2:System.out.println("2");break;
		case 3:System.out.println("3");break;			//Switch
		default:System.out.println("4");break;
		}*/
		
		if(i==3){
			System.out.println("3");
		}else if(i==2){
			System.out.println("2");
		}else if(i==1){
			System.out.println("1");
		}else{
			System.out.println("default");
		}
	}

}
