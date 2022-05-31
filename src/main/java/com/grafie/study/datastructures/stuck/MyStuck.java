package com.grafie.study.datastructures.stuck;

/**
 * mock a stuck
 *
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-31
 */
@SuppressWarnings("unchecked")
public class MyStuck<E> {
    /**
     * 最大存放个数
     */
    private int maxSize;
    /**
     * 底层数据存放结构
     */
    private Object[] elementData;
    /**
     * 栈顶
     */
    private int top;
    /**
     * 当前大小
     */
    private int size;

    public MyStuck(int maxSize) {
        this.maxSize = maxSize;
        elementData = new Object[maxSize];
        top = -1;
        size = 0;
    }

    public void push(E value) {
        checkSize(top + 1);
        elementData[++top] = value;
        size++;
    }

    private void checkSize(int top) {
        if (top < 0 || top >= maxSize) {
            throw new IndexOutOfBoundsException("index: " + top + ", size: " + maxSize);
        }
    }

    public E pop() {
        checkSize(top);
        Object returnValue = elementData[top];
        top--;
        size--;
        return (E) returnValue;
    }

    public E peek() {
        return (E) elementData[top];
    }

    /**
     * 栈是否为空
     *
     * @return true：空的， false：不为空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 是否已经满了
     *
     * @return true 栈已经满了。false：没满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (top == -1) {
            sb.append("[]");
        } else {
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(elementData[i]);
                if (i != (size - 1)) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    /**
     * 清空
     */
    public void clear() {
        for (Object o : elementData) {
            o = null;
        }
        elementData = new Object[maxSize];
        top = -1;
        size = 0;
    }
}
