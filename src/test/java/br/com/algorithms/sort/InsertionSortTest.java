package br.com.algorithms.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class InsertionSortTest {
	
	@Test
	void insertionSortNonIncreasing() {
		int[] result = InsertionSort.sortNonIncreasingOrder(new int[] { 102, 54, 46, 574, 16, 46, 64 });
		
		assertArrayEquals(new int[] { 574, 102, 64, 54, 46, 46, 16 }, result);
	}
}
