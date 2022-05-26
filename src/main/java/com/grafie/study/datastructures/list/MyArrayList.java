package com.grafie.study.datastructures.list;


import java.util.*;

/**
 * mock an int list by implements {@link List}
 *
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-25
 */
@SuppressWarnings("unchecked")
public class MyArrayList<E> implements List<E> {

    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        size = 0;
    }

    /**
     * 查询底层数组的大小
     *
     * @return elementData.length
     */
    public int arraySize() {
        return elementData.length;
    }

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
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData,size);
    }

    @Override
    public Object[] toArray(Object[] a) {
        int length = Math.min(a.length, size());
        Object[] returnArr = new Object[length];
        System.arraycopy(elementData, 0, returnArr, 0, length);
        return returnArr;
    }

    @Override
    public boolean add(Object o) {
        checkSize(size + 1);
        elementData[size++] = o;
        return true;
    }

    @Override
    public void add(int index, Object element) {
        checkIndex(index);
        checkSize(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size() - index);
        elementData[index] = element;
        size++;
    }

    /*检查大小，如果新的长度，超过数组长度，则扩容*/
    private void checkSize(int newSize) {
        if (newSize - elementData.length > 0) {
            resize(newSize);
        }
    }

    /*根据新长度进行扩容*/
    private void resize(int newSize) {
        // newElementData.length() 可能会超过 Integer.Max(),暂时不做处理
        newSize = Math.max(newSize, elementData.length * 2);
        Object[] newElementData = new Object[newSize];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /*删除，并移动当前位置之后的内容，同时检查底层数组大小*/
    private void fastRemove(int index) {
        // 只需要移动index之后的元素长度
        int numMoved = size() - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        elementDataChangeToSmall();
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c.size() == 0) {
            return false;
        }
        boolean contains = true;
        for (Object cElement : c) {
            for (int i = 0; i < size; i++) {
                if (!cElement.equals(elementData[i])) {
                    contains = false;
                    break;
                }
            }
        }
        return contains;
    }

    @Override
    public boolean addAll(Collection c) {
        int cLength = c.size();
        checkSize(size + cLength);
        System.arraycopy(c.toArray(), 0, elementData, size, cLength);
        size += cLength;
        return cLength != 0;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        checkIndex(index);
        int cLength = c.size();
        checkSize(size + cLength);
        Object[] needMoved = new Object[size - index];
        // 复制需要移动的数据
        System.arraycopy(elementData, index, needMoved, 0, size - index);
        // 插入新数据
        System.arraycopy(c.toArray(), 0, elementData, index, cLength);
        // 插入需要移动的数据
        System.arraycopy(needMoved, 0, elementData, index + cLength, needMoved.length);
        size += cLength;
        return cLength != 0;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object cElement : c) {
            for (int i = 0; i < size; i++) {
                if (cElement.equals(elementData[i])) {
                    elementData[i] = null;
                }
            }
        }
        // 把不为空的内容都挪到前面来
        trimList();
        return true;
    }

    private void trimList() {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == null) {
                for (int j = i; j < size - 1; j++) {
                    elementData[j] = elementData[j + 1];
                    elementData[j + 1] = null;
                }
                size--;
            }
        }
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] newArray = new Object[elementData.length];
        int newIndex = 0;
        for (Object cElement : c) {
            for (int i = 0; i < size; i++) {
                if (cElement.equals(elementData[i])) {
                    newArray[newIndex] = elementData[i];
                    newIndex++;
                }
            }
        }
        elementData = newArray;
        size = newIndex;
        return true;
    }

    /*缩小底层数组范围，取1/2*/
    private void elementDataChangeToSmall() {
        if (size < elementData.length / 2) {
            int newSize = elementData.length / 2;
            Object[] newArray = new Object[newSize];
            System.arraycopy(elementData, 0, newArray, 0, size);
            elementData = newArray;
        }
    }

    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    @Override
    public E set(int index, Object element) {
        checkIndex(index);
        Object oldValue = elementData[index];
        elementData[index] = element;
        return (E) oldValue;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Object object = elementData[index];
        fastRemove(index);
        return (E) object;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == o) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("method not supported");
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("method not supported");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        List<E> returnList = new ArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            returnList.add((E) elementData[i]);
        }
        return returnList;
    }

    private void checkIndex(int index) {
        if (index > size() || index < 0) {
            throw new IllegalArgumentException("index " + index + " is out of range " + size());
        }
    }

    @Override
    public String toString() {
        if (size <= 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
