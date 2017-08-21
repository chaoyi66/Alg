package cc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TicketDAO {
	static ExecutorService DbThreadPoll = Executors.newFixedThreadPool(100);
	private volatile int num = 20;

	public boolean sellTicket(int i) {
		Future<Boolean> future = DbThreadPoll.submit(new DbTask(i));
		try {
			return future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void sellTicketAsync(int i, Handler handler) {
		DbThreadPoll.submit(new AsyncDbTask(i, handler));
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
		int i;

		public DbTask(int i) {
			this.i = i;
		}

		@Override
		public Boolean call() throws Exception {
			// 完成数据库任务
			return trySell();
		}
	}

	class AsyncDbTask implements Runnable {
		Handler handler;
		int i;

		public AsyncDbTask(int i, Handler handler) {
			this.i = i;
			this.handler = handler;
		}

		@Override
		public void run() {
			// 完成数据库任务
			try {
				Boolean rs = trySell();
				handler.handle(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
