package com.grafie.study.datastructures.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * mock a linkedList by implements {@link List}
 *
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-26
 */
@SuppressWarnings("unchecked")
public class MyLinkedList<E> implements List<E> {
    /**
     * 复制LinkedList的Node
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        size = 0;
        last = null;
        first = null;
    }

    /**
     * 节点数量
     */
    private int size;
    private Node<E> first;
    private Node<E> last;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (first == null) {
            return false;
        }
        if (o.equals(first.item)) {
            return true;
        }
        Node<E> thisNode = first.next;
        while (thisNode != null) {
            if (o.equals(thisNode.item)) {
                return true;
            }
            thisNode = thisNode.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        // TODO: 2022/5/26
        return new Object[0];
    }

    @Override
    public <E> E[] toArray(E[] a) {
        // TODO: 2022/5/26
        return null;
    }

    @Override
    public boolean add(E e) {
        if (first == null) {
            first = new Node<>(null, e, null);
            last = first;
        } else {
            Node<E> newNode = new Node<>(last, e, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    /**
     * 获取第一个节点的值
     *
     * @return E 第一个节点的值
     */
    public E getFirst() {
        if (first == null || first.item == null) {
            return null;
        }
        return (E) first.item;
    }

    /**
     * 获取最后一个节点的值
     *
     * @return E 获取最后一个节点的值
     */
    public E getLast() {
        if (last == null || last.item == null) {
            return null;
        }
        return (E) last.item;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            Node<E> node = first;
            while (node != null) {
                if (node.item == null) {
                    Node<E> pre = node.prev;
                    Node<E> next = node.next;
                    pre.next = next;
                    next.prev = pre;
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO: 2022/5/26
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.size() <= 0) {
            return false;
        }
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {

        // TODO: 2022/5/26
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO: 2022/5/26
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO: 2022/5/26
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        // TODO: 2022/5/26
        return null;
    }

    @Override
    public E set(int index, E element) {
        // TODO: 2022/5/26
        return null;
    }

    @Override
    public void add(int index, E element) {
        // TODO: 2022/5/27
    }

    @Override
    public E remove(int index) {
        // TODO: 2022/5/27
        return null;
    }

    @Override
    public int indexOf(Object o) {
        // TODO: 2022/5/27
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO: 2022/5/27
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO: 2022/5/27
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO: 2022/5/27
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO: 2022/5/27
        return null;
    }

    @Override
    public String toString() {
        if (size <= 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> startNode = first;
        while (startNode != null) {
            sb.append(startNode.item);
            startNode = startNode.next;
            if (startNode != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
