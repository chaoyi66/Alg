package cc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller1 {

	static TicketDAO ticketDAO = new TicketDAO();

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			HttpServletRequest request = null;
			HttpServletResponse response = null;
			final int finalI = i;
			new Thread(() -> {
				boolean rs = doService(finalI);
				check(request, response, rs);
			}).start();
		}
	}


	private static void check(HttpServletRequest request, HttpServletResponse response, Object result) {
		System.out.println("controller check result=" + result);
	}

	private static boolean doService(int i) {
		//执行Service层业务逻辑
		boolean result = ticketDAO.sellTicket(i);
		System.out.println("service process ... , result=" + result);
		return result;
	}

}

