package edu.sla;

public class CounterIncrementer implements Runnable {
    private SynchronizedCounter sharedCounter;
    private int myId;

    CounterIncrementer(SynchronizedCounter theCounter, int id) {

        sharedCounter = theCounter;
        myId = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            while (!sharedCounter.increment(myId)) {
                Thread.currentThread().yield();
            }
        }
        System.out.println("Incrementer thread " + String.valueOf(myId) + ": DONE INCREMENTING");
    }
}
