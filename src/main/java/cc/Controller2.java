package cc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface Handler {
	void handle(Object result);
}

public class Controller2 {


	static ExecutorService DbWorker = Executors.newFixedThreadPool(100);
	static TicketDAO ticketDAO = new TicketDAO();

	public static void main(String args[]) throws Exception {
		int taskCount = 2000;
		ExecutorService eventLoop = Executors.newSingleThreadExecutor();
		for (int i = 0; i < taskCount; i++)
			eventLoop.submit(new Event(i, result -> check(result)));
	}

	private static void check(Object result) {
		//执行业务逻辑
		System.out.println("boss check task, result=" + result);
	}

	static class Event implements Runnable, Handler {
		Handler handler;
		int i;

		public Event(int i, Handler handler) {
			this.i = i;
			this.handler = handler;
		}

		@Override
		public void run() {
			DbWorker.submit(new DbTask(i, (result) -> {
				handle(result);
				handler.handle(result);
			}
			));
		}

		@Override
		public void handle(Object result) {
			//执行业务逻辑
			System.out.println(" process task" + i + ", result=" + result);
		}
	}

	static class DbTask implements Runnable {
		Handler handler;
		int i;

		public DbTask(int i, Handler handler) {
			this.i = i;
			this.handler = handler;
		}

		@Override
		public void run() {
			// 完成数据库任务
			// System.out.println(Thread.currentThread().getName() + " sell ticket" + i);
			try {
				Boolean rs = ticketDAO.sellTicket();
				handler.handle(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

