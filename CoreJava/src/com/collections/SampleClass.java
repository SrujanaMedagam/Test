package com.collections;

import java.util.HashMap;
import java.util.Map;

class SampleClass {
    public static void main(String[] args) {
        Map<Object, String> m = new HashMap<Object, String>();
        Dog d1 = new Dog("clover");
        m.put(d1, "Dog key");
        d1.name ="arthur";
        System.out.println(m.get(d1));      
    }
}