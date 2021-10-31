package br.com.algorithms;

import br.com.algorithms.sort.InsertionSort;

import java.util.List;

public class Main {

    public static void main(String[] args) {
    
        List<Integer> result = InsertionSort.sortNonIncreasingOrder(List.of(102,54,46,574,16,46,64));
    
        for (int k : result) {
            System.out.print(k + " ");
        }
    }
}
