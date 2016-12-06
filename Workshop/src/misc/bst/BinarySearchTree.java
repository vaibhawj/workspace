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

		return Math.max(heightOfTree(node.left) + 1, heightOfTree(node.right) + 1);

	}

}
