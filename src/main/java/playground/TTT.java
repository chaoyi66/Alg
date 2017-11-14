package playground;

import java.util.concurrent.TimeUnit;

/**
 * created by chaoyi on 2017/11/13
 */
public class TTT {

	public static void main(String[] args) {

		Object lock = new Object();
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("INFO: A 等待锁");
				synchronized (lock) {
					System.out.println("INFO: A 得到了锁 lock");
					System.out.println("A 1");
					try {
						System.out.println("INFO: A 准备进入等待状态，放弃锁 lock 的控制权，等待3秒");
						lock.wait(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("INFO: 有人唤醒了 A, A 重新获得锁 lock");
					System.out.println("A 2");
					System.out.println("A 3");
				}
			}
		}, "th-A");
		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("INFO: B 等待锁");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock) {
					System.out.println("INFO: B 得到了锁 lock");
					System.out.println("B 1");
					System.out.println("B 2");
					System.out.println("B 3");
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("INFO: B 打印完毕，调用 notify 方法");
					lock.notify();
				}
			}
		}, "th-B");
		A.start();
		B.start();
	}
}
