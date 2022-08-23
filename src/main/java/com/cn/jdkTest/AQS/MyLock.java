package com.cn.jdkTest.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.AQS
 * @Time: 2022-08-22 11:02
 * @Description: TODO
 **/
public class MyLock implements Lock {
    private static Sync sync = new Sync() ;

    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            String name = Thread.currentThread().getName();
            if(!name.startsWith("linxx")){
                System.out.println("thread name can't check out");
                return false;
            }
            if(compareAndSetState(0,arg)){
                System.out.println(name + " get lock!");
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            boolean free = false;
            int state = super.getState();
            if(state == arg){
                free = true;
            }
            super.setExclusiveOwnerThread(null);
            super.setState(0);
            return free;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.tryRelease(0);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
