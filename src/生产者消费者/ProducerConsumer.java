package 生产者消费者;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    static int MAX_SIZE = 5;

    static Lock lock = new ReentrantLock(true);
    static Condition notEmpty = lock.newCondition();
    static Condition notFull = lock.newCondition();

    public static void main(String[] args) {
        Queue<Object> queue = new LinkedList<>();

        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();

        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    static class Producer implements Runnable {
        private Queue<Object> queue;

        public Producer(Queue<Object> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    lock.lock();
                    while (queue.size() == MAX_SIZE) {
                        notFull.await();
                    }
                    queue.add(new Object());
                    System.out.println("生产者 " + Thread.currentThread().getName() + " 生产了一个Object");
                    notEmpty.signalAll();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private Queue<Object> queue;

        public Consumer(Queue<Object> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() == 0) {
                        notEmpty.await();
                    }
                    queue.poll();
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 消费了一个Object");
                    notFull.signalAll();

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
