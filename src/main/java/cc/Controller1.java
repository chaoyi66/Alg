package cc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller1 {

	private static TicketService ticketService = new TicketService();

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			final int finalI = i;
			new Thread(() -> {
				boolean rs = ticketService.sellTicket(finalI);
				check(null, null, rs);
			}).start();
		}
	}

	private static void check(HttpServletRequest request, HttpServletResponse response, Object result) {
		System.out.println("controller check result=" + result);
	}

	private static class TicketService {
		private static TicketDAO ticketDAO = new TicketDAO();

		private static boolean sellTicket(int i) {
			//执行Service层业务逻辑
			boolean result = ticketDAO.sellTicket();
			System.out.println("process task" + i + ", result=" + result);
			return result;
		}

	}

}

