package cn.liyao52.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

public class FlagThreadExit {

    static class MyTask extends Thread
    {
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("I will start work!");
            while(!closed && !isInterrupted()){
                //  running
            }
            System.out.println("I will be exiting.");
        }

        public void close(){
            this.closed  = true;
            this.interrupt();
        }

        public static void main(String[] args) throws InterruptedException {
            MyTask t = new MyTask();
            t.start();
            TimeUnit.SECONDS.sleep(10);
            System.out.println("System will be shutdown.");
            t.close();
        }

    }
}
