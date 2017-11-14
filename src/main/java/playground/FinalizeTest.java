package playground;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by chaoyi on 2017/11/13
 */
public class FinalizeTest {
	static AtomicInteger aliveCount = new AtomicInteger(0);

	FinalizeTest() {
		aliveCount.incrementAndGet();
	}

	public static void main(String args[]) {
		for (int i = 0; ; i++) {
			FinalizeTest f = new FinalizeTest();
			if ((i % 100_000) == 0) {
				System.out.format("After creating %d objects, %d are still alive.%n", new Object[]{i, FinalizeTest.aliveCount.get()});
			}
		}
	}

	// @Override
	// protected void finalize() throws Throwable {
	// 	FinalizeTest.aliveCount.decrementAndGet();
	// }
}

