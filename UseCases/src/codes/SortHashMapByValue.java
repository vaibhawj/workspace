package codes;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Sort hash map by values
 * 
 * @author vku147
 *
 */
public class SortHashMapByValue {

	enum Order {
		ASC, DESC;
	}

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Amish", "Tripathi");
		map.put("Vaibhaw", "Kumar");
		map.put("John", "Travolta");
		map.put("Eva", "Mendes");

		System.out.println("Unsorted map as below");
		System.out.println(map);
		System.out.println("Sorted map as below");
		System.out.println(sortMapByValue(map));

	}

	private static HashMap<String, String> sortMapByValue(
			HashMap<String, String> map) {
		return sortMapByValue(map, Order.ASC);
	}

	private static HashMap<String, String> sortMapByValue(
			HashMap<String, String> map, Order order) {

		Set<Entry<String, String>> entrySet = map.entrySet();
		LinkedList<Entry<String, String>> entryList = new LinkedList<Map.Entry<String, String>>(
				entrySet);

		Collections.sort(entryList, new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1,
					Entry<String, String> o2) {

				switch (order) {
				case DESC:
					return o2.getValue().compareTo(o1.getValue());

				default:
					return o1.getValue().compareTo(o2.getValue());
				}
			}
		});

		LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();
		for (Entry<String, String> entry : entryList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
}
