package br.com.algorithms.data.structures.tree;

import br.com.algorithms.data.structures.tree.BinaryTree;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	
	@Test
	void treeTest() {
		BinaryTree bt = new BinaryTree();
		
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		
		bt.traversePreOrder(bt.root);
		System.out.println();
		bt.traverseInOrder(bt.root);
		
		System.out.println();
		System.out.println("------");
		
		bt.traverseInOrder(bt.root);
		bt.delete(6);
		System.out.println();
		bt.traverseInOrder(bt.root);
		bt.delete(4);
		System.out.println();
		bt.traverseInOrder(bt.root);
		bt.delete(5);
		System.out.println();
		bt.traverseInOrder(bt.root);
		bt.delete(8);
		System.out.println();
		bt.traverseInOrder(bt.root);
		bt.delete(7);
		System.out.println();
		bt.traverseInOrder(bt.root);
		bt.delete(9);
		System.out.println();
		bt.traverseInOrder(bt.root);
		bt.delete(3);
		bt.traverseInOrder(bt.root);
		
	}
	
}
