package br.com.algorithms.data.structures.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	
	static class Node {
		
		int value;
		Node left;
		Node right;
		
		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	Node root;
	
	public void add(int value) {
		root = addRecursive(root, value);
	}
	
	private Node addRecursive(Node current, int value) {
		
		if (current == null) {
			return new Node(value);
		}
		
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		}
		return current;
	}
	
	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}
	
	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value < current.value
					   ? containsNodeRecursive(current.left, value)
					   : containsNodeRecursive(current.right, value);
	}
	
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}
		
		if (value > current.value) {
			current.right = deleteRecursive(current.right, value);
		} else if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
		} else {
			if (current.left == null && current.right == null) {
				current = null;
			} else if (current.right != null) {
				current.value = successor(current);
				current.right = deleteRecursive(current.right, current.value);
			} else {
				current.value = predecessor(current);
				current.left = deleteRecursive(current.left, current.value);
			}
		}
		return current;
	}
	
	private int successor(Node root) {
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		return root.value;
	}
	
	private int predecessor(Node root) {
		root = root.left;
		while (root.right != null) {
			root = root.right;
		}
		return root.value;
	}
	
	public List<Integer> getValues() {
		return getValuesRecursive(root);
	}
	
	private List<Integer> getValuesRecursive(Node node) {
		List<Integer> list = new ArrayList<>();
		if (node != null) {
			list.add(node.value);
			getValuesRecursive(node.left);
			getValuesRecursive(node.right);
		}
		
		return list;
	}
	
	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}
}
