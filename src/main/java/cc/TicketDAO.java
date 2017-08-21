package cc;

import java.util.concurrent.Callable;

public class TicketDAO implements Callable<Boolean> {
	private volatile int num = 1000;
	private long t1 = System.currentTimeMillis();

	public synchronized boolean sellTicket() {
		// 模拟数据库操作
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (num <= 0) {
			System.out.println("seld out");
			System.out.println(String.format("time cost: %sms", System.currentTimeMillis() - t1));
			return false;
		} else {
			System.out.println("sell ticket" + num);
			num--;
			return true;
		}

	}

	@Override
	public Boolean call() throws Exception {
		return sellTicket();
	}
}
