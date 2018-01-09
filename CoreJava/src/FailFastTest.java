import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class FailFastTest {
	public static void main(String args[]) {
		ConcurrentHashMap map = new ConcurrentHashMap();
		// HashMap map=new HashMap();
		map.put(1, "Srujana");
		map.put(22, "Sai");
		map.put(10, "sonu");
		System.out.println(map);
		Set set = map.keySet();
		Iterator it = set.iterator();
		if (set.contains(1)) {
			map.remove(1);
		}
		map.put(5, "santhi");
		while (it.hasNext()) {
			int key = (int) it.next();
			System.out.println(key + "  " + map.get(key));
		}
	}
}
