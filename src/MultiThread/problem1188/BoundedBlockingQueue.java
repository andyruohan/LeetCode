package MultiThread.problem1188;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
    private int size;
    private int capacity;
    private LinkedList<Integer> container;
    private ReentrantLock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        container = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size >= capacity) {
                producer.await();
            }
            container.addFirst(element);
            size++;
            consumer.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                consumer.await();
            }
            int lastValue = container.getLast();
            container.removeLast();
            size--;

            producer.signal();
            return lastValue;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return size;
    }
}
