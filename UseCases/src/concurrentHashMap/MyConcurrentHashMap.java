package concurrentHashMap;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyConcurrentHashMap<K, V> extends AbstractMap<K, V> {

	private ArrayList<LinkedList<Node<K, V>>> entryList;
	private int capacity;

	public MyConcurrentHashMap() {
		this(16);
	}

	public MyConcurrentHashMap(int capacity) {
		this.capacity = capacity;
		entryList = new ArrayList<>(16);
		for (int i = 0; i < this.capacity; i++) {
			entryList.add(new LinkedList<MyConcurrentHashMap.Node<K, V>>());
		}
	}

	@Override
	public V put(K key, V value) {
		int index = getHashCode(key);
		Node<K, V> node = new Node<K, V>(key, value);
		LinkedList<Node<K, V>> list = entryList.get(index);

		// TODO to remove
		System.out.println(Thread.currentThread().getName()
				+ " reached just before synchronized block");
		synchronized (list) {
			// TODO to remove
			System.out.println(Thread.currentThread().getName()
					+ " just entered synchronized block");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//

			// Actual code
			if (list.contains(node)) {
				list.remove(node);
			}
			list.add(node);
			//

			// TODO to remove
			System.out.println(Thread.currentThread().getName()
					+ " just added " + node);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//
		}

		return node.v;
	}

	private int getHashCode(K key) {
		return key.hashCode() % capacity;
	}

	@Override
	public V get(Object key) {
		int index = getHashCode((K) key);
		LinkedList<Node<K, V>> list = entryList.get(index);

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

		@Override
		public String toString() {

			return "{" + this.k + ", " + this.v + "}";
		}

	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		HashSet<Entry<K, V>> entrySet = new HashSet<MyConcurrentHashMap.Entry<K, V>>();
		for (LinkedList<Node<K, V>> bucket : entryList) {
			for (Node<K, V> node : bucket) {
				entrySet.add(node);
			}
		}
		return entrySet;
	}

	@Override
	public String toString() {
		Set<Entry<K, V>> entrySet = entrySet();
		return entrySet.toString();
	}

}
