package edu.sla;

public class CounterIncrementer implements Runnable {
    SynchronizedCounter sharedCounter;

    CounterIncrementer(SynchronizedCounter theCounter) {
        sharedCounter = theCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            while (sharedCounter.value() > 9) {
                Thread.currentThread().yield();
            }
            sharedCounter.increment();
        }
        System.out.println("DONE INCREMENTING");
    }
}
