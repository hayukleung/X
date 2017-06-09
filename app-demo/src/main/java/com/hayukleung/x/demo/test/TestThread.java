package com.hayukleung.x.demo.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者消费者模型
 */
public class TestThread {

  public static final int SIZE = 100;

  public static void main(String[] argv) {

    // Using wait notify notifyAll
    Queue queue = new LinkedList();
    new Producer(queue).start();
    new Consumer(queue).start();

    // Using BlockingQueue
    ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(SIZE);
    new Producer2(blockingQueue).start();
    new Consumer2(blockingQueue).start();
  }

  public static class Producer extends Thread {

    private Queue mQueue;

    public Producer(Queue queue) {
      mQueue = queue;
    }

    @Override public void run() {
      while (true) {
        synchronized (mQueue) {
          if (SIZE == mQueue.size()) {
            try {
              mQueue.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          mQueue.add(new Object());
          System.out.println("Queue size == " + mQueue.size());
          mQueue.notifyAll();
        }
      }
    }
  }

  public static class Consumer extends Thread {

    private Queue mQueue;

    public Consumer(Queue queue) {
      mQueue = queue;
    }

    @Override public void run() {
      while (true) {
        synchronized (mQueue) {
          if (mQueue.isEmpty()) {
            try {
              mQueue.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          mQueue.remove();
          System.out.println("Queue size == " + mQueue.size());
          mQueue.notifyAll();
        }
      }
    }
  }

  public static class Producer2 extends Thread {

    private ArrayBlockingQueue<String> mBlockingQueue;

    public Producer2(ArrayBlockingQueue blockingQueue) {
      mBlockingQueue = blockingQueue;
    }

    @Override public void run() {
      while (true) {
        if (SIZE != mBlockingQueue.size()) {
          mBlockingQueue.add("");
          System.out.println("Queue size == " + mBlockingQueue.size());
        }
      }
    }
  }

  public static class Consumer2 extends Thread {

    private ArrayBlockingQueue<String> mBlockingQueue;

    public Consumer2(ArrayBlockingQueue blockingQueue) {
      mBlockingQueue = blockingQueue;
    }

    @Override public void run() {
      while (true) {
        if (!mBlockingQueue.isEmpty()) {
          mBlockingQueue.remove();
          System.out.println("Queue size == " + mBlockingQueue.size());
        }
      }
    }
  }
}
