package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {  
        final ReadAndWrite raw = new ReadAndWrite();  
        raw.map.put("data", 1);  
        //线程1，读数据  
        new Thread(  
                new Runnable() {  
                    @Override  
                    public void run() {  
                        while(true)  
                            raw.read();                       
                    }  
        }).start();
	    try {
		    TimeUnit.SECONDS.sleep(1);
	    } catch (InterruptedException e) {
		    e.printStackTrace();
	    }
	    //线程2，读数据
        new Thread(  
                new Runnable() {  
                    @Override  
                    public void run() {  
                        while(true)  
                            raw.write();
                    }  
        }).start();  
          
    }  
}  
  
  
class ReadAndWrite{  
    ReadWriteLock rwlock = new ReentrantReadWriteLock();//读写锁
    Map map = new HashMap();//共享的数据
    public void read(){  
        rwlock.readLock().lock();//上读锁，且没有解锁  
        System.out.println(Thread.currentThread().getName()+"读开始...");  
        System.out.println(Thread.currentThread().getName()+"读数据为："+map.get("data"));  
        System.out.println(Thread.currentThread().getName()+"读结束...");
	    rwlock.readLock().unlock();
	    try {
            Thread.sleep((long) (Math.random()*1000));  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }
    }

	public void write(){
		rwlock.writeLock().lock();//上写锁
		System.out.println(Thread.currentThread().getName()+"写开始...");
		double data = Math.random();
		map.put("data", data);
		System.out.println(Thread.currentThread().getName()+"写数据为："+data);
		System.out.println(Thread.currentThread().getName()+"写结束...");
		// rwlock.writeLock().unlock();//解写锁
		try {
			Thread.sleep((long) (Math.random()*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}  
