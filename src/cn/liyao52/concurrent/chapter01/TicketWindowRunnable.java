package cn.liyao52.concurrent.chapter01;

public class TicketWindowRunnable implements Runnable {

    private int index = 1; //不做static修饰

    private final static int MAX = 50;

    @Override
    public void run() {
        while(index <= MAX){
            System.out.println(Thread.currentThread() + "的号码是：" + (index++));
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable runnable = new TicketWindowRunnable();

        new Thread(runnable,"1号窗口").start();
        new Thread(runnable,"2号窗口").start();
        new Thread(runnable,"3号窗口").start();
        new Thread(runnable,"4号窗口").start();
    }
}
