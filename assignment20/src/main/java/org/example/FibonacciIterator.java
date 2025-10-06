package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator over Fibonacci numbers starting 1, 1, 2, 3, 5, ...
 *
 * Implementation notes:
 * - Internal state: 'prev' and 'curr' encode the last two numbers.
 * - We start from (prev=0, curr=1) so that the first call to next() returns 1.
 * - For bounded mode, 'remaining' tracks how many values are left.
 * - For unbounded mode, hasNext() is always true (client must stop).
 *
 * Overflow: Using int keeps things simple for the assignment. In a real app,
 * prefer long or BigInteger once you need larger ranges.
 */
public class FibonacciIterator implements Iterator<Integer> {
    private int prev = 0;
    private int curr = 1;
    private Integer remaining; // null => unbounded

    public FibonacciIterator(Integer limit) {
        this.remaining = limit; // may be null for unbounded
    }

    @Override
    public boolean hasNext() {
        // Unbounded stream => always true.
        if (remaining == null) return true;
        return remaining > 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException("No more Fibonacci numbers.");

        // Next Fibonacci number is 'curr'
        int value = curr;

        // Advance state: (prev, curr) -> (curr, prev+curr)
        int next = prev + curr;
        prev = curr;
        curr = next;

        if (remaining != null) remaining--;
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}

