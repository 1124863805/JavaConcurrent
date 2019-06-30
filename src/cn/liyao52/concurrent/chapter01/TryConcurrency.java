package cn.liyao52.concurrent.chapter01;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {

    public static void main(String[] args) {
        browseNews();
        enjoyMusic();

        // 通过匿名内部类的方式创建线程，并且重写其中的run方法（并发运行交替输出）
        new Thread(){
            @Override
            public void run() {
                enjoyMusic();
            }
        }.start();
        browseNews();



        //使用Lambda 表达式优化上面方法
        new Thread(TryConcurrency::browseNews).start();
        browseNews();

    }


    /**
     * browse the latest news
     */
    private static void browseNews(){
        for(;;){
            System.out.println("Uh-huh,the good news.");
        }
    }


    /**
     *  Listening and enjoy the music
     */
    private static void enjoyMusic(){
        for(;;){
            System.out.println("Uh-huh , the nice music");
        }
    }


    /**
     *  Simulate the wait and ignore exception
     * @param seconds
     */
    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
