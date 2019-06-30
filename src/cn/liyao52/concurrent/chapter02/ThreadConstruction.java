package cn.liyao52.concurrent.chapter02;

import org.junit.Test;

import java.util.stream.IntStream;

public class ThreadConstruction {



    private final static String PREFIX = "LEO_"; // prafix (前缀)




    // 在线程启动前，调用Thread.setName 可以进行修改名字
    // 线程一旦被启动，名字将不能修改
    @Test
    public void test0(){

        // 线程的默认命名
        IntStream.range(0,5).boxed().map(i -> new Thread(
                ()->{
                    System.out.println(Thread.currentThread().getName());
                }
        )).forEach(Thread::start);

        // 自定义线程命名
        IntStream.range(0,5).mapToObj(ThreadConstruction::createThread).forEach(Thread::start);
    }

    @Test
    public void test1(){
        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("TestGroup");

        Thread t2 = new Thread(group,t1);

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("Main thread belong group:" + mainThreadGroup.getName());

        System.out.println("t1 and main belong the same group:" +(mainThreadGroup == t1.getThreadGroup()) );
        System.out.println("t2 and main belong the same group:" +(mainThreadGroup == t2.getThreadGroup()) );
        System.out.println("t2 and main belong the same group:" +(group == t2.getThreadGroup()) );
    }


    private static Thread createThread(final int intName)
    {
        return new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },PREFIX + intName);
    }


}
