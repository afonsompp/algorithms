package br.com.algorithms.data.structures;

public class LinkedList {
	
	private Node head;
	
	public Node getHead() {
		return head;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	static class Node {
		
		private final int data;
		private Node next;
		
		Node(int data) {
			this.data = data;
		}
		
		public Node getNext() {
			return next;
		}
		
		public int getData() {
			return data;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	public static LinkedList insert(LinkedList list, int data) {
		Node node = new Node(data);
		Node last = list.getHead();
		if (last == null) {
			list.setHead(node);
			return list;
		}
		while (last.getNext() != null) {
			last = last.next;
		}
		last.setNext(node);
		
		return list;
	}
	
	public static LinkedList deleteByKey(LinkedList list, int key) {
		Node currNode = list.getHead();
		Node prev = null;
		if (currNode != null && currNode.getData() == key) {
			list.setHead(currNode.getNext());
			return list;
		}
		
		while (currNode != null && currNode.getData() != key) {
			prev = currNode;
			currNode = currNode.next;
		}
		
		if (currNode != null) {
			prev.next = currNode.next;
		}
		
		return list;
		
	}
	
	public static void printList(LinkedList list) {
		Node currNode = list.head;
		
		System.out.print("LinkedList: ");
		
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		
		System.out.println();
	}
}
