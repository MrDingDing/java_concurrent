package com.my.the_art_of_java_concurrency.unit1;

/**
 * create by blackjack on 2019/5/12
 * 测试thread join方法的作用  比较并发执行和串行执行的效率是绝对的吗
 */
public class ConcurrencyTest {
 public  static final  int  count = 10000;
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Runnable runnable = new Runnable() {
            public void run() {
                    int a = 0;
                    for (long i =0;i < count;i++){
                        a+=5;
                    }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        int b = 0;
        for (long i = 0;i <count; i++){
            b--;
        }
        thread.join();  //主线程被阻塞  当前线程执行完  主线程才会执行
        long time = System.currentTimeMillis()-start;
        System.out.println("concurreny:"+time+"ms,b="+b);

    }
    public  static void serial(){
      long start = System.currentTimeMillis();
      int a = 0;
        for (long i = 0;i < count;i++) {
            a+=5;
        }
        int b = 0;
        for (long i = 0;i < count;i++) {
            b--;
        }
        long time  = System.currentTimeMillis()-start;
        System.out.println("serial:"+time+"ms,b="+b);
    }
}
