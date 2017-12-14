package edu.sla;

public class CounterDecrementer implements Runnable {
    private SynchronizedCounter sharedCounter;
    private int decId;

    CounterDecrementer(SynchronizedCounter theCounter, int id) {
        sharedCounter = theCounter;
        decId = id;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            while (!sharedCounter.decrement(decId)) {
                Thread.currentThread().yield();
            }
        }
        System.out.println("Decrementer thread " + decId + ": DONE DECREMENTING");
    }
}
