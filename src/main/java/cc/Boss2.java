package cc;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


/**
 * created by chaoyi on 8/20/2017
 */

public class Boss2 implements Callable {
	static Boss2 boss = new Boss2();
	static int taskCount = 1;

	public static void main(String args[]) throws Exception {
		System.out.println("boss has 5 task with deadline");
		new Thread(() -> {
			try {
				new SlowWorker().work(taskCount++, 1, boss);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		System.out.println("boss busy...");
		TimeUnit.SECONDS.sleep(5);
		System.out.println("boss back...");
		System.out.println("main end");
	}

	@Override
	public Object call() throws Exception {
		System.out.println("boss check");
		if (taskCount <= 5)
			new SlowWorker().work(taskCount++, 1, boss);
		return null;
	}

	static class SlowWorker {

		public void work(int number, int deadline, Callable callBack) throws Exception {
			System.out.println(Thread.currentThread().getName() + "...");
			System.out.println(Thread.currentThread().getName() + "...");
			System.out.println("worker " + number + " hard working...");
			TimeUnit.SECONDS.sleep(deadline);
			System.out.println("worker " + number + " finish!!!");
			callBack.call();
		}
	}

}
