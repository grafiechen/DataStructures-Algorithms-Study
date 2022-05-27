package com.grafie.study.test;

import com.grafie.study.datastructures.list.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
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
    }

    @Test
    void removeTest() {

    }

}
