package cc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface Handler {
	void handle(Object result);
}

public class Controller2 {

	static TicketDAO ticketDAO = new TicketDAO();

	public static void main(String args[]) throws Exception {
		int taskCount = 100;
		ExecutorService eventLoop = Executors.newSingleThreadExecutor();
		for (int i = 0; i < taskCount; i++)
			eventLoop.submit(new Event(i, result -> check(result)));
	}

	private static void check(Object result) {
		//执行业务逻辑
		System.out.println("boss check task, result=" + result);
	}

	static class Event implements Runnable {
		Handler handler;
		int i;

		public Event(int i, Handler handler) {
			this.i = i;
			this.handler = handler;
		}

		@Override
		public void run() {
			ticketDAO.sellTicketAsync(i, result -> {
				doService(result);
				handler.handle(result);
			});
		}

		public void doService(Object result) {
			//执行业务逻辑
			System.out.println("process task" + i + ", result=" + result);
		}
	}

}

