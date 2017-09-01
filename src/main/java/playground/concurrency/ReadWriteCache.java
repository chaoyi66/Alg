package playground.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCache {
	private Map<String, Object> cache = new HashMap<String, Object>();
	private ReadWriteLock rwLock = new ReentrantReadWriteLock();

	public Object getData(String key) {
		// 首先上读锁
		rwLock.readLock().lock();
		// 首先从缓存中获取
		Object value = null;
		try {
			Thread.sleep(1000);
			value = cache.get(key);
			if (value == null) {
				// 如果缓存中没有数据,那么就从数据库中获取
				// 但此时需要上写锁，只需要让一个进程进行写数据
				// 首先去除读锁，然后加上写锁
				rwLock.readLock().unlock();
				rwLock.writeLock().lock();
				try {
					// 注意防止多线程运行到上一步，某个线程写完数据后
					// 别的线程就需要看是否有数据再决定是否进行写操作
					// 在写之前再读一次,防止最开始的线程都进行写操作</span>
					value = cache.get(key);
					// 第一个线程写完后，防止后面的线程再次写数据
					if (value == null) {
						System.out.println("有线程写数据........");
						value = "数据库中获取";
						// 将数据放入缓存
						cache.put(key, value);
						System.out.println("数据写完了.......");
					}
				} finally {
					rwLock.readLock().lock();// 恢复读锁，锁的重入
					rwLock.writeLock().unlock();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rwLock.readLock().unlock();// 解读锁
		}
		return value;
	}
}  
