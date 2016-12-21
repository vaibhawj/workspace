package misc.bst;

import java.util.LinkedList;

import misc.bst.BinarySearchTree.Node;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeCheckerTest {

	@Test
	public void testForPositiveScenario() {

		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		BinarySearchTree checker = new BinarySearchTree();
		Assert.assertTrue(checker.isBinarySearchTree(root));
	}

	@Test
	public void testForNegativeScenario() {

		Node root = new Node(10);
		root.left = new Node(7);
		root.right = new Node(39);
		root.left.right = new Node(11);

		BinarySearchTree checker = new BinarySearchTree();
		Assert.assertFalse(checker.isBinarySearchTree(root));
	}

	@Test
	public void testInOrderTraversal() {

		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		BinarySearchTree checker = new BinarySearchTree();
		LinkedList<Node> traversal = new LinkedList<>();
		checker.inOrderTraversal(root, traversal);
		Assert.assertEquals(5, traversal.size());
		Assert.assertEquals(1, traversal.get(0).value);
		Assert.assertEquals(2, traversal.get(1).value);
		Assert.assertEquals(3, traversal.get(2).value);
		Assert.assertEquals(4, traversal.get(3).value);
		Assert.assertEquals(5, traversal.get(4).value);

	}

	@Test
	public void testLevelOrderTraversal() {

		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		BinarySearchTree checker = new BinarySearchTree();
		LinkedList<Node> traversal = new LinkedList<>();
		traversal.add(root);
		checker.levelOrderTraversal(root, traversal);
		Assert.assertEquals(5, traversal.size());
		Assert.assertEquals(4, traversal.get(0).value);
		Assert.assertEquals(2, traversal.get(1).value);
		Assert.assertEquals(5, traversal.get(2).value);
		Assert.assertEquals(1, traversal.get(3).value);
		Assert.assertEquals(3, traversal.get(4).value);

	}

	@Test
	public void testTopViewTraversal() {

		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(7);
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		BinarySearchTree checker = new BinarySearchTree();
		LinkedList<Node> list = new LinkedList<>();
		Assert.assertTrue(checker.isBinarySearchTree(root));
		checker.topView(root, list);

	}

	@Test
	public void testHeightOfTree() {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		BinarySearchTree checker = new BinarySearchTree();
		int h = checker.heightOfTree(root);
		Assert.assertEquals(3, h);

	}

	@Test
	public void testCheckBinarySearchTreeForPositiveScenario() {

		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		BinarySearchTree checker = new BinarySearchTree();
		Assert.assertTrue(checker.checkBinarySearchTree(root));
	}

	@Test
	public void testCheckBinarySearchTreeForNegativeScenario() {

		Node root = new Node(10);
		root.left = new Node(7);
		root.right = new Node(39);
		root.left.right = new Node(11);

		BinarySearchTree checker = new BinarySearchTree();
		Assert.assertFalse(checker.checkBinarySearchTree(root));
	}

}
