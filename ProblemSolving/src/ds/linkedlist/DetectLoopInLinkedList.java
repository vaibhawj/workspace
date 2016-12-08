package ds.linkedlist;

public class DetectLoopInLinkedList {

	public static void main(String[] args) {
		Node head1 = getLoopyList();
		Node head2 = getNormalList();

		System.out.println(isHavingLoop(head1));
		System.out.println(isHavingLoop(head2));

		detectAndRemoveLoop(head1);
		detectAndRemoveLoop(head2);

		System.out.println(isHavingLoop(head1));
		System.out.println(isHavingLoop(head2));

	}

	private static Node getNormalList() {
		Node head = new Node(1);
		Node node2 = new Node(2);
		head.next = node2;
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		return head;
	}

	private static Node getLoopyList() {
		Node head = new Node(1);
		Node node2 = new Node(2);
		head.next = node2;
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = node2;
		return head;
	}

	private static boolean isHavingLoop(Node head) {

		Node slow = head;
		Node fast = slow.next.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	private static void detectAndRemoveLoop(Node head) {

		Node slow = head;
		Node fast = slow.next.next;
		Node prevFast = slow.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				prevFast.next = null;
			}
			slow = slow.next;
			prevFast = fast;
			fast = fast.next.next;
		}
	}
}
