package ds;

public class ReverseALinkedList {

	private static class Node {
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

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		print(head);

		Node newHead = reverse(head);

		print(newHead);

	}

	private static Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;

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
