package br.com.algorithms.divide.to.conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindMaxSubArrayTest {
	
	@Test
	void bruteForceTest(){
		int result = FindMaxSubArray.maxSubArrayBruteForce(new int[]{1,-3,4,-5,6-2,5,-10,-4});
		assertEquals(9, result);
	}
	
	@Test
	void KadanesTest(){
		int result = FindMaxSubArray.maxSubArray(new int[]{1,-3,4,-5,6-2,5,-10,-4});
		assertEquals(9, result);
	}

}
