package com.cn.JdkDemo.thread.CountDown;

import lombok.SneakyThrows;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.thread.CountDown
 * @Time: 2022-11-28 10:24
 * @Description: ·â×°countDownLatch ³éÏó´úÂëtest
 **/
public class countDownTest1 {

    public static void main(String[] args) throws InterruptedException {
        countDownTest1 c = new countDownTest1();
        c.processData();

    }

    public void processData() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        countTask count1 = new countTask(countDownLatch,new sqlDataService());
        countTask count2 = new countTask(countDownLatch,new redisDataService());
        new Thread(() -> {
            count1.run();
            System.out.println(Thread.currentThread().getName() + " is processing sql data");
        }).start();
        new Thread(() -> {
            count2.run();
            System.out.println(Thread.currentThread().getName() + " is processing redis data");
        }).start();
        countDownLatch.await();

        System.out.println("process down, res = " + (count1.res + count2.res));

    }

    class countTask{

        private CountDownLatch countDownLatch;

        private DataService dataService;

        private volatile Integer res = 0;

        public countTask(CountDownLatch countDownLatch, DataService dataService) {
            this.countDownLatch = countDownLatch;
            this.dataService = dataService;
        }

        @SneakyThrows
        public void run() {
            //System.out.println("start run count task");
            res += dataService.getInteger();
            countDownLatch.countDown();
        }
    }

    abstract class DataService{
        public abstract Integer getInteger();
    }

    class sqlDataService extends DataService{

        @Override
        public Integer getInteger() {
            return 3;
        }
    }

    class redisDataService extends DataService{

        @Override
        public Integer getInteger() {
            return 2;
        }
    }

}
