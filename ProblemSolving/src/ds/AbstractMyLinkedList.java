package ds;

public abstract class AbstractMyLinkedList {

	protected static class Node {
		int value;

		Node next;

		public Node(int v) {
			this.value = v;
		}

		@Override
		public String toString() {
			return "" + value;
		}

	}

	public static void print(Node node) {
		if (node == null) {
			System.out.println("NULL");
			return;
		}

		System.out.print(node + "->");
		print(node.next);

	}

}
