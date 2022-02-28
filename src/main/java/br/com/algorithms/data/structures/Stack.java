package br.com.algorithms.data.structures;

public class Stack {
	
	private int[] array;
	private int capacity;
	private int top;
	
	public Stack(int size) {
		this.array = new int[size];
		this.capacity = size;
		this.top = -1;
	}
	
	public void push(int value) {
		if (isFull()) {
			throw new StackOverflowError("Stack full");
		}
		array[++top] = value;
	}
	
	public int pop(){
		if (isEmpty()) {
			throw new StackOverflowError("Stack empty");
		}
		return array[top--];
	}
	
	public int size() {
		return top + 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == capacity - 1;
	}
	
}
