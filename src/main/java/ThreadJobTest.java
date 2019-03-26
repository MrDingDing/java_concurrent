import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author blackjack
 * @date 2019/3/15/16:33
 * 测试多个线程执行一个job
 */
public class ThreadJobTest {
    static  int number = Integer.MAX_VALUE;
      ExecutorService getThread(int number){
          return Executors.newCachedThreadPool();
      }

      @Test
    public void test() {
          ExecutorService thread = getThread(5);
          long start = System.currentTimeMillis();
          for (int i = 0; i <30; i++) {
              thread.execute(new Runnable() {
                  public void run() {
                      while (true) {
                          number--;
                          System.out.println(Thread.currentThread().getName() + "执行了execute1任务" + number);
                      }
                  }
              });
              thread.execute(new Runnable() {
                  public void run() {
                      while (true) {
                          number--;
                          System.out.println(Thread.currentThread().getName() + "执行了execute2任务" + number);
                      }
                  }
              });

          }
          try {
             Thread.sleep(100000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
}
