package br.com.algorithms.divide.to.conquer;

public class FindMaxSubArray {
	
	public static int maxSubArrayBruteForce(int[] nums) {
		int maximumSubArraySum = Integer.MIN_VALUE;
		
		for (int left = 0; left < nums.length; left++) {
			int runningWindowSum = 0;
			
			for (int right = left; right < nums.length; right++) {
				runningWindowSum += nums[right];
				if (runningWindowSum > maximumSubArraySum) {
					maximumSubArraySum = runningWindowSum;
				}
			}
		}
		return maximumSubArraySum;
	}
	
	public static int maxSubArray(int[] nums) {
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		
		for (int num : nums) {
			if (num > maxEndingHere + num) {
				maxEndingHere = num;
			} else {
				maxEndingHere += num;
			}
			
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}
	
}
