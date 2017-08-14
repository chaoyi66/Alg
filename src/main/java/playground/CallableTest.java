package playground;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by chaoyi on 2017/7/1.
 */
class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000));
        return "result of TaskWithResult " + id;
    }
}

public class CallableTest {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();    //Future 相当于是用来存放Executor执行的结果的一种容器
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        TimeUnit.SECONDS.sleep(1);
        for (Future<String> fs : results) {
            if (fs.isDone()) {
                System.out.println(fs.get());
            } else {
                System.out.println("Future result is not yet complete");
            }
        }
        exec.shutdown();
    }
}
