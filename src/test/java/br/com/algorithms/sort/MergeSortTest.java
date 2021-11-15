package br.com.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {
	
	@Test
	void mergeSort(){
		int[] actual = { 5, 1, 6, 2, 3, 4 };
		int[] expected = { 1, 2, 3, 4, 5, 6 };
		MergeSort.sort(actual);
		assertArrayEquals(expected, actual);
	}
}
