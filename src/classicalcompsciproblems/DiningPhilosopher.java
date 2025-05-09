package classicalcompsciproblems;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopher {

    public static void main(String[] args) {
        System.out.println("to be implemented");
    }

}

class Philosopher implements Runnable {
    private final int bite = 10;
    private final Chopstick left;
    private final Chopstick right;
    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }

    public void run() {
        for (int i = 0; i < bite; i++) {
            eat();
        }
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    public void chew() {
    }

    public boolean pickUp() {
        if (!left.isPickedUp()) {
            return false;
        }
        if (!right.isPickedUp()) {
            {
                left.putDown();
                return false;
            }
        }
        return true;
    }

    public void putDown() {
        left.putDown();
        right.putDown();
    }

}

class Chopstick {
    private final Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean isPickedUp() {
        return lock.tryLock();

    }

    public void putDown() {
        lock.unlock();
    }
}