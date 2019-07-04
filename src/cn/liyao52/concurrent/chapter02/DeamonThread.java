package cn.liyao52.concurrent.chapter02;

public class DeamonThread {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
         thread.setDaemon(true); // 将thread设置为守护线程

        thread.start(); //启动Thread线程
        Thread.sleep(2_000L);
        System.out.println("Main thread finished lifecycle.");
    }
}
