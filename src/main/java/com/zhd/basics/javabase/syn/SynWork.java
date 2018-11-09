package com.zhd.basics.javabase.syn;

/**
 * synchronized
 * 
 * @author zhanghaodong
 * @version v1.0
 * @date 2018年11月7日 下午2:39:16
 * @work
 */
public class SynWork {
	public static int _index;

	// 普通方法
	public void synMethod1(int index) {
		synchronized ("ceshi") {
			for (int i = 0; i < 3; i++) {
				try {
					_index = index;
					System.out.println("synMethod1:" + Thread.currentThread().getName() + ":" + _index);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 静态方法
	public synchronized static void synMethod2(int index) {
		for (int i = 0; i < 3; i++) {
			try {
				_index = index;
				System.out.println("synMethod2:" + Thread.currentThread().getName() + ":" + _index);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
