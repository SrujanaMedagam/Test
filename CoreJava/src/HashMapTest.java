import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	static String getValue(Map<String ,Object> m,String key) {
		String value = "";
		for (Map.Entry e : m.entrySet()) {
			if (e.getKey().toString().equalsIgnoreCase(key)) {
				return e.getValue().toString();
			} else {
				if (e.getValue() instanceof Map) {
					return getValue((Map<String, Object>) e.getValue(), key);
				}
			}
		}
		return value;
	}
	public static void main(String args[]){
		Map m1=new HashMap();
		m1.put("1", "1");
		m1.put("2", "2");
		
		Map m2=new HashMap();
		m2.put("4", "4");
		m2.put("5", "5");
		
		Map m3=new HashMap();
		m3.put("7", "7");
		m3.put("8", "8");
	
		Map m4=new HashMap();
		m4.put("1", "1");
		
		m1.put("3", m2);
		m2.put("6", m3);
		m3.put("9", m4);
		int i=10;
		System.out.println(i);
		System.out.println(getValue(m1,"6"));
		
	}

}
