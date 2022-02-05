package br.com.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {
	
	@Test
	void insertionSortNonIncreasing() {
		int[] result = HeapSort.sort(new int[] { 102, 54, 46, 574, 16, 47, 64 });
		
		assertArrayEquals(new int[] { 16, 46, 47, 54, 64, 102, 574 }, result);
	}
}
