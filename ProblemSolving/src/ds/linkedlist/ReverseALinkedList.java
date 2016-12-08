package ds.linkedlist;

public class ReverseALinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		Node.print(head);

		Node newHead = reverse(head, null);

		Node.print(newHead);

	}

	private static Node reverse(Node node, Node prevNode) {

		if (null == node.next) {
			node.next = prevNode;
			return node;
		}
		Node nextNode = node.next;
		node.next = prevNode;

		return reverse(nextNode, node);

	}

}
