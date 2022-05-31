package com.grafie.study.test;

import com.grafie.study.datastructures.stuck.MyStuck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-31
 */
public class MyStuckTest {

    private MyStuck<Integer> myStuck;

    @BeforeEach
    void init() {
        myStuck = new MyStuck<>(10);
        myStuck.push(1);
        myStuck.push(2);
        myStuck.push(3);
        myStuck.push(4);
        myStuck.push(5);
    }

    @Test
    void addTest() {
        System.out.println(myStuck);
    }

    @Test
    void popTest() {
        System.out.println(myStuck.pop());
        System.out.println(myStuck);
        myStuck.push(10);
        System.out.println(myStuck.peek());
        System.out.println(myStuck);
        System.out.println(myStuck.pop());
        System.out.println(myStuck);

        while (!myStuck.isEmpty()) {
            System.out.println(myStuck.pop());
        }
    }

    @Test
    void clearTest() {
        System.out.println(myStuck);
        System.out.println("empty: " + myStuck.isEmpty());
        System.out.println("full: " + myStuck.isFull());
        while (!myStuck.isFull()) {
            myStuck.push(1);
        }
        System.out.println(myStuck);
        System.out.println("empty: " + myStuck.isEmpty());
        System.out.println("full: " + myStuck.isFull());
        myStuck.clear();
        System.out.println(myStuck);
        System.out.println("empty: " + myStuck.isEmpty());
        System.out.println("full: " + myStuck.isFull());
    }

    @Test
    void reserveWord() {
        String a = "Hello word";
        MyStuck<Character> myStuck = new MyStuck<>(a.length());
        for (int i = 0; i < a.length(); i++) {
            myStuck.push(a.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!myStuck.isEmpty()) {
            sb.append(myStuck.pop());
        }
        System.out.println(sb);
    }
}
