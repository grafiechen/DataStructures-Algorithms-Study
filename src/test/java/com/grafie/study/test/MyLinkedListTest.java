package com.grafie.study.test;

import com.grafie.study.datastructures.list.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-27
 */
public class MyLinkedListTest {
    private MyLinkedList<Integer> linkedList;

    @BeforeEach
    void init() {
        linkedList = new MyLinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
    }

    @Test
    void toStringTest() {
        System.out.println(linkedList);
    }

    @Test
    void addTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);
        System.out.println(linkedList.size());

        linkedList.add(1, 9);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
    }

    @Test
    void removeTest() {
        System.out.println(linkedList);
        linkedList.add(null);
        linkedList.add(null);
        System.out.println(linkedList);
        System.out.println("size: " + linkedList.size());
        linkedList.remove(null);
        System.out.println(linkedList);
        linkedList.remove(new Integer(2));
        System.out.println("size: " + linkedList.size());
        System.out.println(linkedList);
    }

    @Test
    void getFirstOrGetLastTest() {
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.add(9);
        linkedList.add(10);
        System.out.println(linkedList);
        System.out.println(linkedList.getLast());
    }

    @Test
    void toArrayTest() {
        System.out.println(linkedList);
        System.out.println(Arrays.toString(linkedList.toArray(new Integer[20])));
        System.out.println(Arrays.toString(linkedList.toArray(new Integer[2])));
        System.out.println(Arrays.toString(linkedList.toArray()));
    }

    @Test
    void clearTest() {
        System.out.println(linkedList);
        linkedList.clear();
        System.out.println(linkedList);
    }
}
