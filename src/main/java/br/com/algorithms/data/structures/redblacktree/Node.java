package br.com.algorithms.data.structures.redblacktree;

public class Node {
	int data;
	
	Node parent;
	Node left;
	Node right;
	
	boolean color;
	
	public Node(int data){
		this.data = data;
	}
}
