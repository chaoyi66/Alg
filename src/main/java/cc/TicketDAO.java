package cc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TicketDAO {
	static ExecutorService DbThreadPoll = Executors.newFixedThreadPool(100);
	private volatile int num = 10;

	public boolean sellTicket() {
		Future<Boolean> future = DbThreadPoll.submit(new DbTask());
		try {
			return future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void sellTicketAsync(Handler handler) {
		DbThreadPoll.submit(new AsyncDbTask(result -> handler.handle(result)));
	}

	private synchronized boolean trySell() {
		// 模拟数据库操作
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (num <= 0) {
			System.out.println("sorry, sold out!!!");
			return false;
		} else {
			System.out.println("trySell ticket" + num);
			num--;
			return true;
		}

	}

	class DbTask implements Callable<Boolean> {
		@Override
		public Boolean call() {
			// 完成数据库任务
			return trySell();
		}
	}

	class AsyncDbTask implements Runnable {
		Handler handler;

		public AsyncDbTask(Handler handler) {
			this.handler = handler;
		}

		@Override
		public void run() {
			// 完成数据库任务
			handler.handle(trySell());
		}
	}

}
