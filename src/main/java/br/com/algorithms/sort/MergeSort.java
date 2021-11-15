package br.com.algorithms.sort;

public class MergeSort {
	
	public static int[] sort(int[] array) {
		if (array.length < 2) {
			return array;
		}
		int mid = array.length / 2;
		int[] leftSubArray = new int[mid],
				rightSubArray = new int[array.length - mid];
		
		for (int i = 0; i < mid; i++) {
			leftSubArray[i] = array[i];
		}
		for (int i = mid; i < array.length; i++) {
			rightSubArray[i - mid] = array[i];
		}
		
		sort(leftSubArray);
		sort(rightSubArray);
		
		return merge(array, leftSubArray, rightSubArray, mid);
	}
	
	private static int[] merge(int[] array, int[] leftSubArray, int[] rightSubArray, int mid) {
		int l = 0, r = 0, a = 0;
		
		while (l < leftSubArray.length && r < rightSubArray.length) {
			if (leftSubArray[l] < rightSubArray[r]) {
				array[a++] = leftSubArray[l++];
			} else {
				array[a++] = rightSubArray[r++];
			}
		}
		
		while (r < rightSubArray.length){
			array[a++] = rightSubArray[r++];
		}
		while (l < leftSubArray.length){
			array[a++] = leftSubArray[l++];
		}
		
		return array;
		
	}
}
