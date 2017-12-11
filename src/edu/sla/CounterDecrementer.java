package edu.sla;

public class CounterDecrementer implements Runnable {
    SynchronizedCounter sharedCounter;
    int decId;

    CounterDecrementer(SynchronizedCounter theCounter, int id) {
        sharedCounter = theCounter;
        decId = id;
    }

    @Override
    public void run() {
        for (int j = 0; j < 20; j++) {
            while (sharedCounter.value() < 1) {
                Thread.currentThread().yield();
            }
            sharedCounter.decrement(decId);
        }
        System.out.println("DONE Decrementing " + decId);
    }
}
