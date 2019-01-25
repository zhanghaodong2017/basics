//package com.zhd.basics.javabase.suanfa;
//
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.function.IntBinaryOperator;
//
//public class AtomicTest1 {
//	public static void main(String[] args) {
//		M1 m1 = new M1();
//		AtomicInteger atomicInteger = new AtomicInteger(10);
//		int andUpdate = atomicInteger.getAndAccumulate(5, m1);
//		System.out.println(andUpdate);
//		System.out.println(atomicInteger.get());
//	}
//}
//
//class M1 implements IntBinaryOperator {
//	/**
//	 * left 是AtomicInteger的value
//	 * right 是getAndAccumulate方法的第一个参数的x
//	 */
//	@Override
//	public int applyAsInt(int left, int right) {
//		return left - right;
//	}
//
//}
