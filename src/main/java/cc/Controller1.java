package cc;

public class Controller1 {

	static TicketDAO ticketDAO = new TicketDAO();

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			final int finalI = i;
			new Thread(() -> {
				boolean rs = doService(finalI);
				check(rs);
			}).start();
		}
	}

	private static void check(Object result) {
		System.out.println("controller check result=" + result);
	}

	private static boolean doService(int i) {
		//执行业务逻辑
		boolean result = ticketDAO.sellTicket(i);
		System.out.println("service process ... , result=" + result);
		return result;
	}

}

