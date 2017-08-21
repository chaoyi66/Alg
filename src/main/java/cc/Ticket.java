package cc;

public class Ticket implements Runnable {
	Object obj = new Object();
	private int num = 5;

	public static void main(String[] args) {
		Ticket t = new Ticket();
		new Thread(t).start();
		new Thread(t).start();
	}

	@Override
	public void run() {
		while (true) {
			synchronized (obj) {
				if (num <= 0) {
					System.out.println(Thread.currentThread().getName() + "...end");
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "...sale" + num--);
			}

		}
	}



}

