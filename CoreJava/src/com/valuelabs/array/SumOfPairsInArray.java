package com.valuelabs.array;

import java.util.Arrays;
import java.util.List;


public class SumOfPairsInArray {

	public static void main(String[] args) {
		int x=5;
		int arr[]={1,2,3,4,5,7,9,11};
		//List list = (List) Arrays.asList(arr);
	
		/*for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(arr[i]+arr[j] == x && i!=j ){
					System.out.println(arr[i] + " " +arr[j]);
					
				}
			}
		}
*/
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				for(int k=0;k<arr.length;k++){
				if(arr[i]+arr[j] == arr[k]  ){
					System.out.println("arr[] containd sum of :"+arr[i]+arr[j]);
				}
				}
			}
		}
	}

}
