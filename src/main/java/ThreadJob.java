import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author blackjack
 * @date 2019/3/15/13:58
 *
 */
public class ThreadJob {
    //使用for循环创建线程
    List<Thread> createThreadByFor(int number) {
        List<Thread> threadlist = new ArrayList();
        for(int i = 0;i<number;i++) {
        threadlist.add(new Thread());
      }
      return threadlist;
}
    //使用线程池创建线程①
    ExecutorService createByThreadPool1(int number){
        //newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        ExecutorService executorService = Executors.newCachedThreadPool();
        return executorService;
    }
    //使用线程池创建线程②
    ExecutorService createByThreadPool2(int number){
        //newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
        ExecutorService executorService = Executors.newFixedThreadPool(number);
        return executorService;
    }

    //使用线程池创建线程③
    ExecutorService createByThreadPool3(int number){
        //newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行
        ExecutorService executorService = Executors.newScheduledThreadPool(number);
        return executorService;
    }
    //使用线程池创建线程④
    ExecutorService createByThreadPool4(int number){
        //newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return executorService;
    }
     class  TestCreateThreadByFor{
           public void test() {
            ThreadJob.this.createByThreadPool1(5);

         }
     }



}
