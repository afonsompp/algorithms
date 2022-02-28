package br.com.algorithms.data.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
	
	@Test
	void testStack() {
		Stack stack = new Stack(5);
		
		assertThrows(StackOverflowError.class, stack::pop);
		stack.push(1);
		assertEquals(1, stack.pop());
		assertTrue(stack.isEmpty());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertEquals(stack.size(), 5);
		assertTrue(stack.isFull());
		assertThrows(StackOverflowError.class, () -> stack.push(1));
	}
	
}
