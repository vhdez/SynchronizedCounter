package edu.sla;

public class SynchronizedCounter {
    private int counter;

    SynchronizedCounter() {
        counter = 0;
    }

    synchronized boolean increment(int id) {
        if (counter > 9) {
            return false;
        }

        System.out.print("Incrementer thread " + id +": Incrementing counter from " + counter);
        counter = counter + 1;
        System.out.println(" to " + counter);
        return true;
    }

    synchronized boolean decrement(int id) {
        if (counter < 1) {
            return false;
        }

        System.out.print("Decrementer thread " + id + ": Decrementing counter from " + counter);
        counter = counter - 1;
        System.out.println(" to " + counter);
        return true;
    }
}
