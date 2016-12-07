package ds;

public class MergeTwoSortedLinkedList extends AbstractMyLinkedList {

	public static void main(String[] args) {
		Node h1 = new Node(5);
		h1.next = new Node(10);
		h1.next.next = new Node(15);

		Node h2 = new Node(2);
		h2.next = new Node(3);
		h2.next.next = new Node(20);

		print(h1);
		print(h2);
		Node h3 = merge(h1, h2);
		print(h3);

	}

	private static Node merge(Node h1, Node h2) {

		Node h3 = null;

		return h3;

	}

}
