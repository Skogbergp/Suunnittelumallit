package org.example;

public class Main {
    public static void main(String[] args) {
        // Demo: print the first 10 Fibonacci numbers
        Sequence seq = new FibonacciSequence(10);
        var it = seq.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            if (it.hasNext()) System.out.print(", ");
        }
        System.out.println();
    }
}
