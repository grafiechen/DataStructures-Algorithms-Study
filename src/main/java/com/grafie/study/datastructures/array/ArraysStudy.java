package com.grafie.study.datastructures.array;

import java.util.Arrays;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-25
 */
public class ArraysStudy {
    public static void main(String[] args) {
        int[] intArray = new int[5];
        for (int i = 0; i < 5; i++) {
            intArray[i] = i;
        }
        System.out.println(Arrays.toString(intArray));
    }
}
