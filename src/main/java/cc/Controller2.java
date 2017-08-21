package cc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Controller2 {

	private static TicketDAO ticketDAO = new TicketDAO();
	private static ExecutorService eventLoop = Executors.newSingleThreadExecutor();
	private static ExecutorService workers = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void main(String args[]) throws Exception {
		for (int i = 0; i < 100; i++) {
			HttpServletRequest request = null;
			HttpServletResponse response = null;
			eventLoop.submit(new HttpRequestEvent(i, rs -> check(request, response, rs)));
		}
	}

	private static void check(HttpServletRequest request, HttpServletResponse response, Object result) {
		//执行web层业务逻辑
		System.out.println("controller check result=" + result);
	}

	private static class HttpRequestEvent implements Runnable {
		private int i;
		private Handler handler;

		public HttpRequestEvent(int i, Handler handler) {
			this.i = i;
			this.handler = handler;
		}

		@Override
		public void run() {
			workers.submit(new TicketServiceEvent(i, result -> handler.handle(result)));
		}
	}

	private static class TicketServiceEvent implements Runnable {
		private Handler handler;
		private int i;

		public TicketServiceEvent(int i, Handler handler) {
			this.i = i;
			this.handler = handler;
		}

		@Override
		public void run() {
			ticketDAO.sellTicketAsync(result -> {
				doService(result);
				handler.handle(result);
			});
		}

		public void doService(Object result) {
			//执行service层业务逻辑
			System.out.println("process task" + i + ", result=" + result);
		}

	}
}

