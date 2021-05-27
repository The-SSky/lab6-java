package edu.iterators;

import edu.Collectable;
import edu.MediaLibrary;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItemsDurationIterator implements Iterator<Integer> {
    private int[] durations;
    private int currPos;

    public ItemsDurationIterator(Collectable lib) {
        this.durations = lib.getDurations();
        currPos = 0;
    }

    @Override
    public boolean hasNext() {
        return currPos < durations.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int next = durations[currPos];
        currPos++;

        return next;
    }
}
