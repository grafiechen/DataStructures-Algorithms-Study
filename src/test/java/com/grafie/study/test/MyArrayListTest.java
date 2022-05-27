package com.grafie.study.test;

import com.grafie.study.datastructures.list.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-25
 */
public class MyArrayListTest {
    private MyArrayList<Integer> defaultArrayList;

    @BeforeEach
    void init() {
        defaultArrayList = new MyArrayList<>(10);
        defaultArrayList.add(1);
        defaultArrayList.add(2);
        defaultArrayList.add(3);
        defaultArrayList.add(4);
        defaultArrayList.add(5);
        defaultArrayList.add(6);
        defaultArrayList.add(7);
        defaultArrayList.add(8);
        defaultArrayList.add(9);
        defaultArrayList.add(10);
    }

    @Test
    void printTest() {
        System.out.println(defaultArrayList);
        System.out.println(defaultArrayList.arraySize());
    }

    @Test
    void addTest() {
        defaultArrayList.add(10);
        System.out.println(defaultArrayList);
        defaultArrayList.add(5, 15);
        System.out.println(defaultArrayList);
    }

    @Test
    void addAllTest() {
        MyArrayList<Integer> newArrayList = new MyArrayList<>(10);
        newArrayList.add(20);
        newArrayList.add(21);
        newArrayList.add(22);
        defaultArrayList.addAll(newArrayList);
        System.out.println(defaultArrayList);
        System.out.println(defaultArrayList.size());
        defaultArrayList.addAll(0, newArrayList);
        System.out.println(defaultArrayList);
        System.out.println(defaultArrayList.size());
    }

    @Test
    void setTest() {
        System.out.println(defaultArrayList);
        defaultArrayList.set(1, 19);
        System.out.println(defaultArrayList);
    }

    @Test
    void removeTest() {
        System.out.println(defaultArrayList);
        defaultArrayList.remove(new Integer(5));
        System.out.println(defaultArrayList);
        defaultArrayList.remove(5);
        System.out.println(defaultArrayList);
    }

    @Test
    void removeAllTest() {
        System.out.println(defaultArrayList);
        List<Integer> removeBaseList = new ArrayList<>(10);
        removeBaseList.add(0);
        removeBaseList.add(7);
        removeBaseList.add(9);
        defaultArrayList.removeAll(removeBaseList);
        System.out.println(defaultArrayList);
        System.out.println(defaultArrayList.size());
    }

    @Test
    void retainAllTest() {
        System.out.println(defaultArrayList);
        List<Integer> retainBaseList = new ArrayList<>(10);
        retainBaseList.add(0);
        retainBaseList.add(7);
        retainBaseList.add(9);
        defaultArrayList.retainAll(retainBaseList);
        System.out.println(defaultArrayList);
        System.out.println(defaultArrayList.size());
    }

    @Test
    void indexOfTest() {
        System.out.println(defaultArrayList);
        System.out.println(defaultArrayList.indexOf(null));
        System.out.println(defaultArrayList.indexOf(new Integer(1)));
        System.out.println(defaultArrayList.indexOf(new Integer(10)));
    }

    @Test
    void lastIndexOfTest() {
        System.out.println(defaultArrayList);
        defaultArrayList.add(null);
        System.out.println(defaultArrayList);
        System.out.println(defaultArrayList.lastIndexOf(null));
        defaultArrayList.add(0);
        defaultArrayList.add(0);
        defaultArrayList.add(0);
        System.out.println(defaultArrayList);
        System.out.println(defaultArrayList.lastIndexOf(0));
    }

    @Test
    void toArrayTest() {
        System.out.println(defaultArrayList);
        System.out.println(Arrays.toString(defaultArrayList.toArray()));
        Integer[] newArray = new Integer[5];
        System.out.println(Arrays.toString(defaultArrayList.toArray(newArray)));
    }
}
