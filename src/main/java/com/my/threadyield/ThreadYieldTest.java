package com.my.threadyield;

/**
 * @author blackjack
 * @date 2019/3/26/17:35
 * description:  创建therad1 和thread2 两个线程同时向文件tem.txt里写入字符串 thread1先写入1至5
 *             然后thread2开始写6至10   最后thread1 不断从11开始不断往文件中写
 */
public class ThreadYieldTest {
    static class Job implements Runnable{
        static int  count = 0;
        public void run() {
            while(true) {
                if(count==50)
                    break;
                synchronized (Job.class) {
                    count++;
                    System.out.println("线程" + Thread.currentThread().getName() + "进行自加，count值为:" + count);
                }
                if(count>=5&&count<=10)
      //              Thread.yield();
                  if(Thread.currentThread().getName().equals("Thread-0")) {
                      try {
                          Thread.currentThread().wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }

            }
        }
    }

    public static void main(String[] args) {
        Job job = new Job();
        Thread thread1 = new Thread(job);
        Thread thread2 = new Thread(job);
        thread1.setPriority(2);
        thread2.setPriority(1);
        thread1.start();
        thread2.start();


    }

}
