package cc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Controller2 {

	static TicketDAO ticketDAO = new TicketDAO();

	public static void main(String args[]) throws Exception {
		int taskCount = 100;
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		ExecutorService eventLoop = Executors.newSingleThreadExecutor();
		for (int i = 0; i < taskCount; i++)
			eventLoop.submit(new Event(i, rs -> check(request, response, rs)));
	}

	private static void check(HttpServletRequest request, HttpServletResponse response, Object result) {
		//执行web层业务逻辑
		System.out.println("controller check result=" + result);
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
			ticketDAO.sellTicketAsync( result -> {
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

