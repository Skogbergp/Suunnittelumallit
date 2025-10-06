package org.example;

import java.util.Iterator;

public class FibonacciSequence implements Sequence {
    private Integer limit;

    public FibonacciSequence() {
        this.limit = null;
    }
    public FibonacciSequence(int limit) {
        if (limit < 0) throw new IllegalArgumentException("limit must be >= 0");
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}
