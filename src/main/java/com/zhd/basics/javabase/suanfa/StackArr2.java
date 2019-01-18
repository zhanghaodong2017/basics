package com.zhd.basics.javabase.suanfa;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description 共享栈的实现
 * @Date: 2019-01-18 10:32
 */
public class StackArr2<E> {
    private Object[] arr = null;//
    private int _size = 0;
    private int _top1 = -1;
    private int _top2 = 0;

    public StackArr2(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size mast > 0");
        }
        this.arr = new Object[size];
        this._size = size;
        this._top2 = size;
    }

    public static void main(String[] args) {
        StackArr2<Integer> stackArr = new StackArr2<Integer>(10);
        System.out.println(stackArr.toString());
        stackArr.push1(1);
        stackArr.push1(8);
        stackArr.push1(8);
        stackArr.push1(6);
        stackArr.push2(2);
        stackArr.push2(4);
        stackArr.push2(8);
        stackArr.push2(2);
        stackArr.push1(6);
        stackArr.push1(5);
        stackArr.push1(5);
        Integer pop = stackArr.pop2();
        System.out.println(pop);
        System.out.println(stackArr.toString());
    }

    public synchronized boolean push1(E e) {
        if (isFull()) {
            return false;
        }
        arr[++_top1] = e;
        return true;
    }

    private boolean isFull() {
        if (_top2 == 0 || _top1 == _size - 1 || (_top1 + 1 == _top2)) {
            return true;
        }
        return false;
    }

    public synchronized boolean push2(E e) {
        if (isFull()) {
            return false;
        }
        arr[--_top2] = e;
        return true;
    }

    public synchronized E pop1() {
        if (_top1 < 0) {
            return null;
        }
        E e = (E) arr[_top1--];
        arr[_top1 + 1] = null;
        return e;
    }

    public synchronized E pop2() {
        if (_top2 >= _size) {
            return null;
        }
        E e = (E) arr[_top2++];
        arr[_top2 - 1] = null;
        return e;
    }

    public boolean isEmpty() {
        return _top1 < 0 && _top2 >= _size;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("stack1:");
        if (_top1 < 0) {
            builder.append("[]");
        } else {
            int count = _top1 + 1;
            Object[] newArr = new Object[count];
            System.arraycopy(arr, 0, newArr, 0, count);
            builder.append(Arrays.toString(newArr));
        }
        builder.append("\n\rstack2:");
        if (_top2 >= _size) {
            builder.append("[]");
        } else {
            int count = _size - _top2;
            Object[] newArr = new Object[count];
            System.arraycopy(arr, _top2, newArr, 0, count);
            builder.append(Arrays.toString(newArr));
        }
        return builder.toString();
    }
}
