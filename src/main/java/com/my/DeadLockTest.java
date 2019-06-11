package com.my;

/**
 * @author blackjack
 * @date 2019/3/14/14:38
 */
public class DeadLockTest {
   class  Resource{
    }
    Resource a = new Resource();
    Resource b = new Resource();

    public static void main(String[] args) {
      new DeadLockTest().deadlock();


    }
    private void deadlock() {

        //先拿B资源 后拿A
        final Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (a){
                    System.out.println(Thread.currentThread().getName()+"拿到了a资源");
                  synchronized (b){
                      System.out.println(Thread.currentThread().getName()+"拿到了b资源");
                  }
                    System.out.println(Thread.currentThread().getName()+"释放了b资源");
                }
                System.out.println(Thread.currentThread().getName()+"释放了a资源");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            //先拿A资源 后拿B资源
            public void run() {
                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+"拿到了b资源");
                    synchronized (a){
                        System.out.println(Thread.currentThread().getName()+"拿到了a资源");
                    }
                    System.out.println(Thread.currentThread().getName()+"释放了a资源");
                }
                System.out.println(Thread.currentThread().getName()+"释放了b资源");
            }
        });
      thread1.start();
      thread2.start();
    }
}
