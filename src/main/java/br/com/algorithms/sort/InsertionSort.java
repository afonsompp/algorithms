package br.com.algorithms.sort;

import java.util.List;

public class InsertionSort {
	
	public static int[] sortIncreasingOrder(int[] array) {
		if (array.length < 2) {
			throw new IllegalArgumentException("List must be greater than 2");
		}
		int key, i;
		for (int j = 1; j < array.length; j++) {
			key = array[j];
			i = j - 1;
			while (i >= 0 && array[i] > key) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
		return array;
	}
	public static int[] sortNonIncreasingOrder(int[] array) {
		if (array.length < 2) {
			throw new IllegalArgumentException("List must be greater than 2");
		}
		int key, i;
		for (int j = 1; j < array.length; j++) {
			key = array[j];
			i = j - 1;
			while (i >= 0 && array[i] < key) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
		return array;
	}
	
}

/*
array = {7,3,8,2}

for 0 < 4
	j = 1
	key = 3
	i = 0
  		while 7 > 3 AND 0 <= 0
			array = {,7,8,2}
			i = -1
 		array = {3(key),7,8,2}
---------------------------------------
array = {3,7,8,2}

for 1 < 4
	j = 2
	key = 8
	i = 1
  		while 7 > 8 AND 1 <= 0
---------------------------------------
array = {3,7,8,2}

for 2 < 3
	j = 3
	key = 2
	i = 2
  		while 8 > 2 AND 2 <= 0
			array = {3,7,,8}
			2 -1
		-----------------------------
		while 8 > 2 AND 1 <= 0
			array = {3,,7,8}
			1 - 1
		-----------------------------
		while 8 > 2 AND 0 <= 0
			array = {,3,7,8}
			1 - 1

 		array = {2(KEY),3,7,8}

return {2,3,7,8}
 
 */
