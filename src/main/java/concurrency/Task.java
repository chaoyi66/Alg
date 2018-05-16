package concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A simple thread task representation
 *
 * @author Pierre-Hugues Charbonneau
 */
public class Task {

	// Object used for FLAT lock
	private final Object sharedObject = new Object();
	// ReentrantReadWriteLock used for WRITE & READ locks
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		Task task = new Task();
		new Thread(() -> task.executeTask1()).start();
		new Thread(() -> task.executeTask2()).start();
	}

	/**
	 * Execution pattern #1
	 */
	public void executeTask1() {

		// 1. Attempt to acquire a ReentrantReadWriteLock READ lock
		lock.writeLock().lock();

		// Wait 2 seconds to simulate some work...
		try {
			Thread.sleep(2000);
		} catch (Throwable any) {
		}

		try {
			System.out.println("1 wait for sharedObject");
			// 2. Attempt to acquire a Flat lock...
			try {
				lock.readLock().lock();
				System.out.println("1 get");
			} finally {
				lock.readLock().unlock();
			}

		}
		// Remove the READ lock
		finally {
			lock.writeLock().unlock();
		}

		System.out.println("executeTask1() :: Work Done!");
	}

	/**
	 * Execution pattern #2
	 */
	public void executeTask2() {
		System.out.println("2 wait for sharedObject");

		lock.readLock().lock();
		// 1. Attempt to acquire a Flat lock
		System.out.println("2 get");

		// Wait 2 seconds to simulate some work...
		try {
			Thread.sleep(2000);
		} catch (Throwable any) {
		}

		try {
			// 2. Attempt to acquire a WRITE lock
			lock.writeLock().lock();
			// Do nothing
		}

		// Remove the WRITE lock
		finally {
			lock.readLock().unlock();
		}
		System.out.println("executeTask2() :: Work Done!");
	}

	public ReentrantReadWriteLock getReentrantReadWriteLock() {
		return lock;
	}
}