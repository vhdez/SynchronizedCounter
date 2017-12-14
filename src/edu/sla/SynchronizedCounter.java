package edu.sla;

public class SynchronizedCounter {
    private int counter;

    SynchronizedCounter() {
        counter = 0;
    }

    synchronized int value() {
        return counter;
    }

    synchronized int increment() {
        System.out.print("Incrementing counter from " + counter);
        counter = counter + 1;
        System.out.println(" to " + counter);
        return counter;
    }

    synchronized int decrement(int id) {
        System.out.print(id + " Decrementing counter from " + counter);
        counter = counter - 1;
        System.out.println(" to " + counter);
        return counter;
    }
}
