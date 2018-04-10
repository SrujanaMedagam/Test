package com.valuelabs.array;

public class ReverseStringPreserveSpace {

	public static void main(String[] args) {
		String input = "i am an indian";
		/*char[] ch = input.toCharArray();
		char[] result = new char[ch.length];
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				result[i] = ' ';
			}
		}
		int j = result.length - 1;
		for (int i = 0; j < ch.length; i++) {
			if (ch[i] != ' ') {
				if (result[j] == ' ') {
					j--;
				}

			result[j] = ch[i];
			j--;
		}
		}
		System.out.println(result);
		*/
		
		char[] inputArray = input.toCharArray();  
        char[] result = new char[inputArray.length];  
   
        for (int i = 0; i < inputArray.length; i++) {  
            if (inputArray[i] == ' ') {  
                result[i] = ' ';  
            }  
        }  
   
        int j = result.length - 1;  
   
        for (int i = 0; i < inputArray.length; i++) {  
            if (inputArray[i] != ' ') {  
                if (result[j] == ' ') {  
                    j--;  
                }  
                result[j] = inputArray[i];  
                j--;  
            }  
        }  
        System.out.println(input + " --> " + String.valueOf(result));  
    }  

	}

