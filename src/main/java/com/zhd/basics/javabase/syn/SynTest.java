package com.zhd.basics.javabase.syn;

public class SynTest {
	public static void main(String[] args) {
		SynWork synWork = new SynWork();
		Syn2Work syn2Work = new Syn2Work();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synWork.synMethod1(1);
			}
		}, "T1");
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				syn2Work.synMethod1(2);
			}
		}, "T2");

		thread1.start();
		thread2.start();
	}

}
