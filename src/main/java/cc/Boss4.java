package cc;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


/**
 * created by chaoyi on 8/20/2017
 */

public class Boss4 implements Callable {
	private static Boss4 boss4 = new Boss4();
	private static int taskCount = 5;
	public static void main(String args[]) throws Exception {
		System.out.println("boss has 5 task with deadline");
		new Thread(() -> {
			try {
				new SlowWorker().work(taskCount--, 1, boss4);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		System.out.println("boss leave");
	}

	@Override
	public Object call() throws Exception {
		System.out.println("boss check");
		if (taskCount >= 1)
			new SlowWorker().work(taskCount--, 1, boss4);
		return null;
	}

	static class SlowWorker {
		public void work(int number, int deadline, Callable boss) throws Exception {
			System.out.println(Thread.currentThread().getName() + "...");
			System.out.println("worker " + number + " hard working...");
			// 这里如果在处理很慢的任务，是同样需要嵌套回调的
			TimeUnit.SECONDS.sleep(deadline);
			System.out.println("worker " + number + " finish!!!");
			boss.call();
		}
	}
}
