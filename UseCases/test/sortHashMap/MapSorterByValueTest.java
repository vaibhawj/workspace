package sortHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sortHashMap.MapSorterByValue.Order;

public class MapSorterByValueTest {

	private MapSorterByValue<String> sorter;

	@Before
	public void before() {
		MapSorterByValue<String> sorter = new MapSorterByValue<String>();
	}

	@After
	public void after() {
		sorter = null;
	}

	@Test
	public void testSortMapByValueHashMap_No_Order() {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Amish", "Tripathi");
		map.put("Vaibhaw", "Kumar");
		map.put("John", "Travolta");
		map.put("Eva", "Mendes");

		Map<String, String> sortedMap = (Map<String, String>) sorter
				.sortMapByValue(map);
		ArrayList<Entry<String, String>> listOfValues = new ArrayList<>();
		for (java.util.Map.Entry<String, String> e : sortedMap.entrySet()) {
			listOfValues.add(e);
		}

		Assert.assertEquals("Kumar", listOfValues.get(0).getValue());
		Assert.assertEquals("Vaibhaw", listOfValues.get(0).getKey());
		Assert.assertEquals("Mendes", listOfValues.get(1).getValue());
		Assert.assertEquals("Eva", listOfValues.get(1).getKey());
		Assert.assertEquals("Travolta", listOfValues.get(2).getValue());
		Assert.assertEquals("John", listOfValues.get(2).getKey());
		Assert.assertEquals("Tripathi", listOfValues.get(3).getValue());
		Assert.assertEquals("Amish", listOfValues.get(3).getKey());

	}

	@Test
	public void testSortMapByValueHashMap_ASC_Order() {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Amish", "Tripathi");
		map.put("Vaibhaw", "Kumar");
		map.put("John", "Travolta");
		map.put("Eva", "Mendes");

		Map<String, String> sortedMap = (Map<String, String>) sorter
				.sortMapByValue(map, Order.ASC);
		ArrayList<Entry<String, String>> listOfValues = new ArrayList<>();
		for (java.util.Map.Entry<String, String> e : sortedMap.entrySet()) {
			listOfValues.add(e);
		}

		Assert.assertEquals("Kumar", listOfValues.get(0).getValue());
		Assert.assertEquals("Vaibhaw", listOfValues.get(0).getKey());
		Assert.assertEquals("Mendes", listOfValues.get(1).getValue());
		Assert.assertEquals("Eva", listOfValues.get(1).getKey());
		Assert.assertEquals("Travolta", listOfValues.get(2).getValue());
		Assert.assertEquals("John", listOfValues.get(2).getKey());
		Assert.assertEquals("Tripathi", listOfValues.get(3).getValue());
		Assert.assertEquals("Amish", listOfValues.get(3).getKey());

	}

	@Test
	public void testSortMapByValueHashMap_DESC_Order() {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Amish", "Tripathi");
		map.put("Vaibhaw", "Kumar");
		map.put("John", "Travolta");
		map.put("Eva", "Mendes");

		Map<String, String> sortedMap = (Map<String, String>) sorter
				.sortMapByValue(map, Order.DESC);
		ArrayList<Entry<String, String>> listOfValues = new ArrayList<>();
		for (java.util.Map.Entry<String, String> e : sortedMap.entrySet()) {
			listOfValues.add(e);
		}

		Assert.assertEquals("Tripathi", listOfValues.get(0).getValue());
		Assert.assertEquals("Amish", listOfValues.get(0).getKey());
		Assert.assertEquals("Travolta", listOfValues.get(1).getValue());
		Assert.assertEquals("John", listOfValues.get(1).getKey());
		Assert.assertEquals("Mendes", listOfValues.get(2).getValue());
		Assert.assertEquals("Eva", listOfValues.get(2).getKey());
		Assert.assertEquals("Kumar", listOfValues.get(3).getValue());
		Assert.assertEquals("Vaibhaw", listOfValues.get(3).getKey());
	}

}
