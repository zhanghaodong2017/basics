package com.zhd.basics.javabase.suanfa;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description 栈的数组实现
 * @Date: 2019-01-18 10:32
 */
public class StackArr<E> {
    private Object[] arr = null;//
    private int _size = 0;
    private int _top = -1;

    public StackArr(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size mast > 0");
        }
        this.arr = new Object[size];
        this._size = size;
    }

    public static void main(String[] args) {
        StackArr<Integer> stackArr = new StackArr<Integer>(10);
        System.out.println(stackArr.toString());
        stackArr.push(1);
        stackArr.push(8);
        stackArr.push(8);
        stackArr.push(6);
        stackArr.push(2);
        stackArr.push(4);
        stackArr.push(8);
        stackArr.push(2);
        stackArr.push(6);
        stackArr.push(5);
        stackArr.push(5);
        Integer pop = stackArr.pop();
        System.out.println(pop);
        System.out.println(stackArr.toString());
        System.out.println(stackArr.search(4));
    }

    public synchronized boolean push(E e) {
        if (_top == _size - 1) {
            return false;
        }
        arr[++_top] = e;
        return true;
    }

    public synchronized E pop() {
        if (_top < 0) {
            return null;
        }
        E e = (E) arr[_top--];
        arr[_top + 1] = null;
        return e;
    }

    public boolean isEmpty() {
        return _top < 0;
    }

    public int search(E e) {
        for (int i = _top; i >= 0; i--) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (_top < 0) {
            return "[]";
        }
        int count = _top + 1;
        Object[] newArr = new Object[count];
        System.arraycopy(arr, 0, newArr, 0, count);
        return Arrays.toString(newArr);
    }
}
