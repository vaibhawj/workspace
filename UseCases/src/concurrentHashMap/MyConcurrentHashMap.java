package concurrentHashMap;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyConcurrentHashMap<K, V> extends AbstractMap<K, V> {

	LinkedList<LinkedList<Node<K, V>>> entryList;

	public MyConcurrentHashMap() {
		entryList = new LinkedList<>();
	}

	@Override
	public V put(K key, V value) {
		int index = getHashCode(key);
		Node<K, V> node = new Node<K, V>(key, value);
		LinkedList<Node<K, V>> list;
		int size = entryList.size();
		if (size <= index) {
			list = new LinkedList<>();
			entryList.add(index, list);
		}
		list = entryList.get(index);
		if (list == null) {
			list = new LinkedList<>();
			list.add(node);
		} else {
			if (list.contains(node)) {
				list.remove(node);
			}
			list.add(node);
		}

		return node.v;
	}

	private int getHashCode(K key) {
		return key.hashCode();
	}

	@Override
	public V get(Object key) {
		int index = getHashCode((K) key);
		LinkedList<Node<K, V>> list = entryList.get(index);
		if (list == null) {
			return null;
		}
		for (Node node : list) {
			if (node.k.equals(((Node) key).k)) {
				return (V) node.v;
			}

		}

		return null;
	}

	static class Node<K, V> implements Map.Entry<K, V> {

		private K k;
		private V v;

		public Node(K key, V value) {
			this.k = key;
			this.v = value;
		}

		@Override
		public K getKey() {
			return this.k;
		}

		@Override
		public V getValue() {
			return this.v;
		}

		@Override
		public V setValue(V value) {
			this.v = value;
			return this.v;
		}

		@Override
		public boolean equals(Object obj) {
			Node o = (Node) obj;
			return this.k.equals(o.k);
		}

	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
