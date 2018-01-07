import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.net.SyslogAppender;

public class DuplicatesInList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList();
		ArrayList<String> list2 = new ArrayList();
		list.add("shreyansh");
		list.add("100");
		list.add("100");
		list.add("arbind");
		list.add("vandana");
		list.add("raj");
		list.add("raj");
		System.out.println("Constructed Array list is- " + list);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list.size(); i++) {
			String listValue = list.get(i);
			if (!map.containsKey(listValue)) {
				map.put(listValue, 1);
			} else {
				map.put(listValue, map.get(listValue) + 1);
				// list.remove(listValue);
			}

		}

		System.out.println("Duplicate Elements are - ");
		Iterator<Map.Entry<String, Integer>> mapValue = map.entrySet().iterator();
		while (mapValue.hasNext()) {
			Map.Entry<String, Integer> mapValuee = mapValue.next();
			if (mapValuee.getValue() > 1) {
				list2.add(mapValuee.getKey());
			//	System.out.println(mapValuee.getKey());

			} else {
				list2.add(mapValuee.getKey());
			}
		}
		System.out.println(list2);
	}

}
