package com.my.synchronizedUtil;

/**
 * create by blackjack on 2020/8/30
 */


public class AccountingSync implements Runnable{
    //共享资源(临界资源)
    static int i=0;

    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSync instance=new AccountingSync();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(new AccountingSync());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }
}