package edu.sla;

public class Main {

    public static void main(String[] args) {
        SynchronizedCounter theCounter = new SynchronizedCounter();

        CounterIncrementer myIncrementer1 = new CounterIncrementer(theCounter, 1);
        CounterIncrementer myIncrementer2 = new CounterIncrementer(theCounter, 2);
        CounterDecrementer myDecrementer1 = new CounterDecrementer(theCounter, 1);
        CounterDecrementer myDecrementer2 = new CounterDecrementer(theCounter, 2);
        CounterDecrementer myDecrementer3 = new CounterDecrementer(theCounter, 3);

        Thread incThread1 = new Thread(myIncrementer1);
        // tell that thread to start incrementing counter
        incThread1.start();

        Thread incThread2 = new Thread(myIncrementer2);
        // tell that thread to start incrementing counter
        incThread2.start();

        Thread decThread1 = new Thread(myDecrementer1);
        // tell that thread to start decrementing counter
        decThread1.start();

        Thread decThread2 = new Thread(myDecrementer2);
        // tell that thread to start decrementing counter
        decThread2.start();

        Thread decThread3 = new Thread(myDecrementer3);
        // tell that thread to start decrementing counter
        decThread3.start();
    }
}
