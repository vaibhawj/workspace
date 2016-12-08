package ds;

public class MergeTwoSortedLinkedList extends AbstractMyLinkedList {

	public static void main(String[] args) {
		Node h1 = new Node(5);
		h1.next = new Node(10);
		h1.next.next = new Node(15);

		Node h2 = new Node(2);
		h2.next = new Node(3);
		h2.next.next = new Node(12);
		h2.next.next.next = new Node(20);

		print(h1);
		print(h2);
		System.out.println("Merged");
		print(merge(h1, h2, null, null));

	}

	private static Node merge(Node h1, Node h2, Node mergedHead, Node prevNode) {

		if (null == h1 || null == h2) {
			return mergedHead;
		}

		int minValue;
		if (h1.value < h2.value) {
			minValue = h1.value;
			h1 = h1.next;
		} else {
			minValue = h2.value;
			h2 = h2.next;
		}

		if (mergedHead == null) {
			mergedHead = new Node(minValue);
			prevNode = mergedHead;
		} else {
			Node currNode = new Node(minValue);
			prevNode.next = currNode;
			prevNode = currNode;
		}

		return merge(h1, h2, mergedHead, prevNode);

	}
}
