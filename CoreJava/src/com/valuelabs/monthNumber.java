package com.valuelabs;
public class monthNumber {
        
        public static int getMonthNumber(String month)
        { 
                int monthnumber= 0;
                if(month==null)
                {
                   return monthnumber;
                }
                
                switch(month.toLowerCase())
                {
                case "january" : 
                        monthnumber=1;
                        break;
                case "february" : 
                        monthnumber=2;
                        break;
                case "march" : 
                        monthnumber=3;
                        break;
                case "april" : 
                        monthnumber=4;
                        break;
                case "may" : 
                        monthnumber=5;
                        break;
                case "june" : 
                        monthnumber=6;
                        break;
                case "july" : 
                        monthnumber=7;
                        break;
                case "august" : 
                        monthnumber=8;
                        break;
                case "september" : 
                        monthnumber=9;
                        break;
                case "october" : 
                        monthnumber=10;
                        break;
                case "november" : 
                        monthnumber=11;
                        break;
                case "december" : 
                        monthnumber=12;
                        break;
                default :
                        monthnumber=0;
                        break;
                        
                }
                
                
                return monthnumber;
                
        }

        public static void main(String[] args) {
                String month= "August";
                int returnedMonthNumber = monthNumber.getMonthNumber(month);
                if(returnedMonthNumber==0)
                {
                        System.out.println("Invalid Month");
                }
                else{
                        System.out.println(returnedMonthNumber);
                }

        }

}
