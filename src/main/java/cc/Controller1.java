package cc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Controller1 {

	static TicketDAO ticketDAO = new TicketDAO();
	static ExecutorService DbWorker = Executors.newFixedThreadPool(100);


	public static void main(String[] args) {
		for (int i = 0; i < 2000; i++) {
			final int finalI = i;
			new Thread(() -> {
				try {
					Future<Boolean> future = DbWorker.submit(new DbTask(finalI));
					System.out.println(String.format("task %s result: %s", finalI, future.get()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
		DbWorker.shutdown();
	}

	static class DbTask implements Callable<Boolean> {
		int i;

		public DbTask(int i) {
			this.i = i;
		}

		@Override
		public Boolean call() throws Exception {
			return ticketDAO.sellTicket();
		}
	}

}

