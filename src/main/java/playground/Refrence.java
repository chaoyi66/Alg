package playground;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Refrence {

	public static void main(String[] args) {
		SoftReference<String> sr = new SoftReference<String>(new String("hello"));
		System.out.println(sr.get());

		WeakReference<String> sr1 = new WeakReference<String>(new String("hello2"));
		System.out.println(sr1.get());
		System.gc();                //通知JVM的gc进行垃圾回收
		System.out.println(sr1.get());


		ReferenceQueue<String> queue = new ReferenceQueue<String>();
		PhantomReference<String> pr = new PhantomReference<String>(new String("hello3"), queue);
		System.out.println(pr.get());
		System.out.println(queue.poll());

	}
}
