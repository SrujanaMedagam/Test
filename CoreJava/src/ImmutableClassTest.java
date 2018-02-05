import java.util.HashMap;

final class ImmutableClassTest {
	private String id;
	private String name;
	private HashMap<String, String> map;

	private ImmutableClassTest(String id, String name, HashMap map) {
		this.id = id;
		this.name = name;
		this.map = map;

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	/*public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "Srujana");
		map.put("2", "sai");

		ImmutableClassTest it = new ImmutableClassTest("1", "Srujana", map);

		System.out.println(it.getId());
		System.out.println(it.getName());
		System.out.println(it.getMap());
	}*/

}
