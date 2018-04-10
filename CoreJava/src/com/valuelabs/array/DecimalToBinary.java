package com.valuelabs.array;

public class DecimalToBinary {

	public static void main(String[] args) {
		int[] arr = new int[25];
		int index=0;
		int number=15;
		while(number>0){
			System.out.println(index);
			arr[index++] = number%2;
			number=number/2;
			
		}
		
		for(int i=index-1;i>=0;i--){
			System.out.print(arr[i]);
		}

	}

}

/*
int binary[] = new int[25];
int index = 0;
while(number > 0){
    binary[index++] = number%2;
    number = number/2;
}
for(int i = index-1;i >= 0;i--){
    System.out.print(binary[i]);
}*/