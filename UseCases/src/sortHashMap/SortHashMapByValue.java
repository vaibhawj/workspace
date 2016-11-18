package sortHashMap;

import java.util.HashMap;

/**
 * Sort hash map by values
 * 
 * @author vku147
 *
 */
public class SortHashMapByValue {

	public static void main(String[] args) {
		MapSorterByValue<String> sorter = new MapSorterByValue<String>();

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Amish", "Tripathi");
		map.put("Vaibhaw", "Kumar");
		map.put("John", "Travolta");
		map.put("Eva", "Mendes");

		System.out.println("Unsorted map as below");
		System.out.println(map);
		System.out.println("Sorted map as below");
		System.out.println(sorter.sortMapByValue(map));

	}

}
