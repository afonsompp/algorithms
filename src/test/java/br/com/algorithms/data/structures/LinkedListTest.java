package br.com.algorithms.data.structures;

import org.junit.jupiter.api.Test;

import static br.com.algorithms.data.structures.LinkedList.*;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
	
	@Test
	void test(){
		LinkedList list = new LinkedList();
		
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);
		
		printList(list);
		
		deleteByKey(list, 1);
		deleteByKey(list, 5);
		deleteByKey(list, 8);
		
		printList(list);
	}
	
}
