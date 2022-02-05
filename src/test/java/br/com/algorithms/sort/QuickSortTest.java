package br.com.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
	
	@Test
	void quicksort() {
		int[] arr = new int[] { 3, 32, 325, 76, 564, 32, 1, 6 };
		int high = arr.length - 1;
		QuickSort.quickSort(arr, 0, high);
		
		assertArrayEquals(new int[] { 1, 3, 6, 32, 32, 76, 325, 564 }, arr);
	}
	
}
