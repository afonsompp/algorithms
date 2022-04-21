package br.com.algorithms.data.structures.redblacktree;

public class RedBlackTree {
	
	static final boolean RED = false;
	static final boolean BLACK = true;
	
	protected Node root;
	
	public void insertNode(int key) {
		Node node = root;
		Node parent = null;
		
		while (node != null) {
			parent = node;
			if (key < node.data) {
				node = node.left;
			} else if (key > node.data) {
				node = node.right;
			} else {
				throw new IllegalArgumentException("already contains a node with key: " + key);
			}
		}
		
		Node newNode = new Node(key);
		newNode.color = RED;
		if (parent == null) {
			root = newNode;
		} else if (key < parent.data) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		newNode.parent = parent;
		
		fixRedBlackPropertiesAfterInsert(newNode);
	}
	
	private void fixRedBlackPropertiesAfterInsert(Node node) {
		Node parent = node.parent;
		// Case 1: Parent is null, we've reached the root, the end of the recursion
		if (parent == null) {
			// Uncomment the following line if you want to enforce black roots (rule 2):
			// node.color = BLACK;
			return;
		}
		
		// Parent is black --> nothing to do
		if (parent.color == BLACK) {
			return;
		}
		
		// From here on, parent is red
		Node grandparent = parent.parent;
		
		// Case 2:
		// Not having a grandparent means that parent is the root. If we enforce black roots
		// (rule 2), grandparent will never be null, and the following if-then block can be
		// removed.
		if (grandparent == null) {
			// As this method is only called on red nodes (either on newly inserted ones - or -
			// recursively on red grandparents), all we have to do is to recolor the root black.
			parent.color = BLACK;
			return;
		}
		
		// Get the uncle (maybe null/nil, in which case its color is BLACK)
		Node uncle = getUncle(parent);
		
		// Case 3: Uncle is red -> recolor parent, grandparent and uncle
		if (uncle != null && uncle.color == RED) {
			parent.color = BLACK;
			grandparent.color = RED;
			uncle.color = BLACK;
			
			// Call recursively for grandparent, which is now red.
			// It might be root or have a red parent, in which case we need to fix more...
			fixRedBlackPropertiesAfterInsert(grandparent);
		}
		// Parent is left child of grandparent
		else if (parent == grandparent.left) {
			// Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
			if (node == parent.right) {
				leftRotation(parent);
				
				// Let "parent" point to the new root node of the rotated sub-tree.
				// It will be recolored in the next step, which we're going to fall-through to.
				parent = node;
			}
			
			// Case 5a: Uncle is black and node is left->left "outer child" of its grandparent
			rightRotation(grandparent);
			
			// Recolor original parent and grandparent
			parent.color = BLACK;
			grandparent.color = RED;
		}
		
		// Parent is right child of grandparent
		else {
			// Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
			if (node == parent.left) {
				rightRotation(parent);
				
				// Let "parent" point to the new root node of the rotated sub-tree.
				// It will be recolored in the next step, which we're going to fall-through to.
				parent = node;
			}
			
			// Case 5b: Uncle is black and node is right->right "outer child" of its grandparent
			leftRotation(grandparent);
			
			// Recolor original parent and grandparent
			parent.color = BLACK;
			grandparent.color = RED;
		}
	}
	
	private Node getUncle(Node parent) {
		Node grandparent = parent.parent;
		if (grandparent.left == parent) {
			return grandparent.right;
		} else if (grandparent.right == parent) {
			return grandparent.left;
		} else {
			throw new IllegalStateException("Parent is not a child of its grandparent");
		}
	}
	
	private void rightRotation(Node node) {
		Node parent = node.parent;
		Node leftChild = node.left;
		
		node.left = leftChild.right;
		
		if (leftChild.right != null) {
			leftChild.right.parent = parent;
		}
		leftChild.right = node;
		node.parent = leftChild;
		
		replaceChild(parent, node, leftChild);
	}
	
	private void leftRotation(Node node) {
		Node parent = node.parent;
		Node rightChild = node.right;
		
		node.right = rightChild.left;
		if (rightChild.left != null) {
			rightChild.left.parent = node;
		}
		
		rightChild.left = node;
		node.parent = rightChild;
		
		replaceChild(parent, node, rightChild);
	}
	
	private void replaceChild(Node parent, Node oldChild, Node newChild) {
		if (parent == null) {
			root = newChild;
		} else if (parent.left == oldChild) {
			parent.left = newChild;
		} else if (parent.right == oldChild) {
			parent.right = newChild;
		} else {
			throw new IllegalStateException("Node its not child of its parent");
		}
	}
	
	public Node findNode(int key) {
		Node node = root;
		while (node != null) {
			if (key == node.data) {
				return node;
			} else if (key < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}
}
