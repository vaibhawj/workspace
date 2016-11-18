package sortHashMap;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapSorterByValue<V extends Comparable<V>> {
	enum Order {
		ASC, DESC;
	}

	public HashMap<?, ?> sortMapByValue(HashMap<?, V> map) {
		return sortMapByValue(map, Order.ASC);
	}

	public HashMap<?, ?> sortMapByValue(HashMap<?, V> map, Order order) {

		Set<?> entrySet = map.entrySet();
		LinkedList<Entry<?, V>> entryList = new LinkedList<Map.Entry<?, V>>(
				(Collection<? extends Entry<?, V>>) entrySet);

		Collections.sort(entryList, new Comparator<Entry<?, V>>() {

			@Override
			public int compare(Entry<?, V> o1, Entry<?, V> o2) {

				switch (order) {
				case DESC:
					return o2.getValue().compareTo(o1.getValue());

				default:
					return o1.getValue().compareTo(o2.getValue());
				}
			}
		});

		LinkedHashMap sortedMap = new LinkedHashMap<>();
		for (Entry<?, V> entry : entryList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
}
