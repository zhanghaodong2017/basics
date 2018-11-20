package com.zhd.basics.javabase.suanfa;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class AtomicTest2 {
	public static void main(String[] args) {
		M2 m2 = new M2(2);
		AtomicInteger atomicInteger = new AtomicInteger(10);
		int andUpdate = atomicInteger.getAndUpdate(m2);
		System.out.println(andUpdate);
		System.out.println(atomicInteger.get());
	}
}

class M2 implements IntUnaryOperator {

	private int x;

	public M2(int x) {
		super();
		this.x = x;
	}

	public M2() {
	}

	@Override
	public int applyAsInt(int operand) {
		return operand + x;
	}

}
