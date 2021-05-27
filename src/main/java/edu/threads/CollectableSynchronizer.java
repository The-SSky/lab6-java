package edu.threads;

import edu.Collectable;

public class CollectableSynchronizer {
    private final Collectable c;
    private volatile int currIndex = 0;
    private volatile boolean isElSet = false;

    public CollectableSynchronizer(Collectable i) {
        this.c = i;
    }

    void write(int dur) throws InterruptedException {
        synchronized (c) {
            if (!canWrite()) {
                throw new InterruptedException();
            }
            while (isElSet) {
                c.wait();
            }

            c.setDuration(currIndex, dur);
            isElSet = true;
            System.out.println("set duration " + dur + " to  item[" + currIndex + "]");

            c.notifyAll();
        }
    }

    private boolean canWrite() {
        return (!isElSet && currIndex < c.getItemsCount() || (isElSet && currIndex < c.getItemsCount() - 1));
    }

    void read() throws InterruptedException {
        int dur;
        synchronized (c) {
            if (!canRead()) {
                throw new InterruptedException();
            }
            while (!isElSet) {
                c.wait();
            }

            dur = c.getDuration(currIndex);
            isElSet = false;
            System.out.println("read duration " + dur + " from position " + currIndex);
            currIndex++;

            c.notifyAll();
        }
    }

    private boolean canRead() {
        return currIndex < c.getItemsCount();
    }

    int getSerItemsCount() {
        return c.getItemsCount();
    }
}
