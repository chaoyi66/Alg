package async.completablefuture;

import EDU.oswego.cs.dl.util.concurrent.FJTask;
import EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup;

class Fib extends FJTask {
	static final int threshold = 13;
	volatile int number; // arg/result

	Fib(int n) {
		number = n;
	}

	public static void main(String[] args) {
		try {
			int groupSize = 100; // for example
			long t1 = System.currentTimeMillis();
			FJTaskRunnerGroup group = new FJTaskRunnerGroup(groupSize);
			Fib f = new Fib(43); // for example
			group.invoke(f);
			int result = f.getAnswer();
			long t2 = System.currentTimeMillis();

			System.out.println("Answer: " + result + ", time cost: " + (t2 - t1) + "ms");
		} catch (InterruptedException ex) {
		}
	}

	int getAnswer() {
		if (!isDone())
			throw new IllegalStateException();
		return number;
	}

	public void run() {
		int n = number;
		if (n <= threshold) // granularity ctl
			number = seqFib(n);
		else {
			Fib f1 = new Fib(n - 1);
			Fib f2 = new Fib(n - 2);
			coInvoke(f1, f2);
			number = f1.number + f2.number;
		}
	}

	int seqFib(int n) {
		if (n <= 1) return n;
		else return seqFib(n - 1) + seqFib(n - 2);
	}
}