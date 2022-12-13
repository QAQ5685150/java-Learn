package com.cn.JdkDemo.thread.Join;


/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.Join
 * @Time: 2022-10-18 16:20
 * @Description: TODO
 **/
public class cainiao_review {

    volatile Integer count = 9;

    public static void main(String[] args) throws InterruptedException {
        cainiao_review c = new cainiao_review();
        c.eatApple();
    }

    public void eatApple() throws InterruptedException {
        Thread t1 = new Thread(new task(new monkey(2)));
        Thread t2 = new Thread(new task(new monkey(3)));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }


    public class task implements Runnable {

        private monkey monkey;

        public task(monkey monkey) {
            this.monkey = monkey;
        }

        @Override
        public void run() {
            //�������Ĵ�������1�����󱣳� 2�����ɰ��� 3��ѭ���ȴ� 4������
            //���̱߳��Ҫ��ȷ��1������Щ��Դ 2������ѭ�������� 3����ʱ�˳����� 4����δ�����������̼߳�������
            while (true) {
                synchronized (count) {
                    if (count - monkey.take <= 0) {
                        count.notify();
                        break;
                    }
                    count -= monkey.take;
                    System.out.println("monkey take " + monkey.take + " apple," + "left" + count);
                }
            }
        }
    }
}

class monkey {

    Integer take;

    public monkey(Integer take) {
        this.take = take;
    }
}
