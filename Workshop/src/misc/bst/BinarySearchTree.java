package misc.bst;

import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree {

	static class Node {

		int value;

		Node left;

		Node right;

		public Node(int v) {
			this.value = v;
		}

		@Override
		public String toString() {
			return value + "";
		}

	}

	public boolean isBinarySearchTree(Node node) {

		LinkedList<Node> traversal = new LinkedList<>();
		inOrderTraversal(node, traversal);

		return isSorted(traversal);

	}

	private boolean isSorted(LinkedList<Node> traversal) {

		Iterator<Node> itr = traversal.iterator();
		Node prev = null;
		while (itr.hasNext()) {
			Node n = itr.next();
			if (null != prev && n.value < prev.value) {
				return false;
			}

			prev = n;

		}

		return true;
	}

	public void inOrderTraversal(Node node, LinkedList<Node> traversal) {

		if (node == null) {
			return;
		}

		inOrderTraversal(node.left, traversal);
		traversal.add(node);
		inOrderTraversal(node.right, traversal);

	}

	public void levelOrderTraversal(Node node, LinkedList<Node> traversal) {

		if (null != node.left) {
			traversal.add(node.left);
		}

		if (null != node.right) {
			traversal.add(node.right);
		}

		if (null != node.left) {
			levelOrderTraversal(node.left, traversal);
		}

		if (null != node.right) {
			levelOrderTraversal(node.right, traversal);
		}

	}

	public void topView(Node root, LinkedList<Node> list) {
		leftChilds(root.left, list);
		list.add(root);
		rightChilds(root.right, list);

	}

	private void rightChilds(Node root, LinkedList<Node> list) {
		if (root == null) {
			return;
		}
		list.add(root);
		rightChilds(root.right, list);
	}

	private void leftChilds(Node root, LinkedList<Node> list) {
		if (root == null) {
			return;
		}
		leftChilds(root.left, list);
		list.add(root);

	}

	public int heightOfTree(Node node) {

		if (node == null)
			return 0;

		return Math.max(heightOfTree(node.left) + 1,
				heightOfTree(node.right) + 1);

	}

	public boolean checkBinarySearchTree(Node node) {

		if (node == null) {
			return true;
		}

		if (maxOfSubTree(node.left) < node.value
				&& minOfSubTree(node.right) > node.value) {
			return checkBinarySearchTree(node.left)
					&& checkBinarySearchTree(node.right);
		}
		return false;
	}

	private int minOfSubTree(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		return Math.min(Math.min(Math.min(Math.min(node.value,
				(node.left == null ? Integer.MAX_VALUE : node.left.value)),
				(node.right == null ? Integer.MAX_VALUE : node.right.value)),
				minOfSubTree(node.left)), minOfSubTree(node.right));
	}

	private int maxOfSubTree(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		return Math.max(Math.max(Math.max(Math.max(node.value,
				(node.left == null ? Integer.MIN_VALUE : node.left.value)),
				(node.right == null ? Integer.MIN_VALUE : node.right.value)),
				maxOfSubTree(node.left)), maxOfSubTree(node.right));
	}
}
