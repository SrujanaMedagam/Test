package com.collections;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
 
public class Example_v4 {
 
     public static void main(String[] args) {
          List<String> list = new ArrayList<String>();
          // Insert some sample values.
          list.add("Value1");
          list.add("Value2");
          list.add("Value3");
 
          // Get an iterator.
          Iterator<String> ite = list.iterator();
 
          /* Remove the second value of the list, while iterating over its elements,
           * using the iterator's remove method. */
          while(ite.hasNext()) {
               String value = ite.next();
               if(value.equals("Value3"))
                    ite.remove();
               else
                    System.out.println(value);
          }
     }
}
