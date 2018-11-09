package com.zhd.basics.javabase.proxy;

public class FastclassTest {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		Test2 fc = new Test2();
		int index = fc.getIndex("f()V");
		fc.invoke(index, t1, null);
	}
}

class Test1 {
	public void f() {
		System.out.println("f method");
	}

	public void g() {
		System.out.println("g method");
	}
}

class Test2 {
	public Object invoke(int index, Object o, Object[] ol) {
		Test1 t = (Test1) o;
		switch (index) {
		case 1:
			t.f();
			return null;
		case 2:
			t.g();
			return null;
		}
		return null;
	}

	public int getIndex(String signature) {
		switch (signature.hashCode()) {
		case 3078479:
			return 1;
		case 3108270:
			return 2;
		}
		return -1;
	}
}