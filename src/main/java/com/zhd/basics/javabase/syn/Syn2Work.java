package com.zhd.basics.javabase.syn;

/**
 * synchronized
 * 
 * @author zhanghaodong
 * @version v1.0
 * @date 2018年11月7日 下午2:39:16
 * @work
 */
public class Syn2Work {

	// 普通方法
	public void synMethod1(int index) {
		synchronized ("ceshi") {
			for (int i = 0; i < 3; i++) {
				try {
					SynWork._index = index;
					System.out.println("synMethod1:" + Thread.currentThread().getName() + ":" + SynWork._index);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
