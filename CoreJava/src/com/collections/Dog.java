package com.collections;
import java.util.*;
class Dog {
    public Dog(String n) { name = n; }
    public String name;
   /* public boolean equals(Object o) {
        System.out.println("equals called..");
        if((o instanceof Dog) &&
                (((Dog)o).name == name)) {
            return true;
        } else {
            return false;
        }
    }
    public int hashCode() {
        System.out.println("hashCodecalled..");
        return name.length(); 
    }*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
