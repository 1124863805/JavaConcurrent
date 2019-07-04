package cn.liyao52.concurrent.chapter03;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TheadIsInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.interrupted());
                }
            }
        };
       thread.setDaemon(true);
       thread.start();

       //shortly block make sure the  thread is started
       TimeUnit.MILLISECONDS.sleep(2);
       thread.interrupt();
    }



    @Test
    public void main(){
        System.out.println("Main thread is interrupted?" + Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.println("Main  thread is interrupt?"+ Thread.currentThread().isInterrupted());

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
