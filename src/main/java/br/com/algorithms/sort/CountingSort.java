package br.com.algorithms.sort;

import java.util.Arrays;

public class CountingSort {
	
	public static void sort(int[] arr) {
		
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max - min + 1;
		int[] count = new int[range];
		int[] sortedArr = new int[arr.length];
		
		for (int j : arr) {
			count[j - min]++;
		}
		
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
		for (int i = arr.length - 1; i >= 0; i--) {
			sortedArr[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}
		
		System.arraycopy(sortedArr, 0, arr, 0, arr.length);
	}
}
