package test;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
	static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread("Thread1") {
			@Override
			public void run() {
				map.put(3, 33);
			}
		}.start();

		new Thread("Thread2") {
			@Override
			public void run() {
				map.put(4, 44);
			}
		}.start();

		new Thread("Thread3") {
			@Override
			public void run() {
				map.put(7, 77);
			}
		}.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(map);
	}

}
