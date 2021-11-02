package br.com.algorithms.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class InsertionSortTest {
	
	@Test
	void insertionSortNonIncreasing() {
		List<Integer> result = InsertionSort.sortNonIncreasingOrder(List.of(102, 54, 46, 574, 16, 46, 64));
		
		assertEquals(List.of(574, 102, 64, 54, 46, 46, 16), result);
	}
}
