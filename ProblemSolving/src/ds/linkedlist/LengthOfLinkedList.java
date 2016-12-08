package ds.linkedlist;

public class LengthOfLinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		Node.print(head);

		System.out.println(getLength(head, 0));

	}

	private static int getLength(Node head, int length) {

		if (head.next == null) {
			return ++length;
		}

		return getLength(head.next, ++length);
	}

}
