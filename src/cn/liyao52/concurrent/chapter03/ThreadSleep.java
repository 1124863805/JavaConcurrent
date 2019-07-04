package cn.liyao52.concurrent.chapter03;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ThreadSleep {


    public static void main(String[] args) {
        new Thread(()->{
            long startTime = System.currentTimeMillis();
            sleep(2_000L);
            long entTime = System.currentTimeMillis();
            System.out.println(
                    String.format("Total spend %d ms",(entTime - startTime))
            );
        }).start();

        long startTime = System.currentTimeMillis();
        sleep(3_000L);
        long endTime = System.currentTimeMillis();
        System.out.println(
                String.format("Main Thread total spend %d ms",(endTime - startTime))
        );
        try {
            //休眠 1小时24分钟17秒88毫秒
            TimeUnit.HOURS.sleep(1);
            TimeUnit.MINUTES.sleep(24);
            TimeUnit.SECONDS.sleep(17);
            TimeUnit.MILLISECONDS.sleep(88);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static void sleep(Long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){

        }
    }

}
