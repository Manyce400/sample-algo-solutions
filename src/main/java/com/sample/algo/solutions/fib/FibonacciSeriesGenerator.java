package com.sample.algo.solutions.fib;

/**
 * @author manyce400
 */
public class FibonacciSeriesGenerator {



    public static void generateSeries(final int sequenceCount) {
        int firsSequence = 1;
        int secondSequence = 1;

        if(sequenceCount == 1) {
            // Base case print only 1
            System.out.print(firsSequence);
            return;
        } else if(sequenceCount == 2) {
            // Print only 2 out of the sequence
            System.out.print(firsSequence + ", " + secondSequence);
            return;
        }

        // Print out the first 2 numbers in the sequence which will always be 1, 1
        System.out.print(firsSequence + ", " + secondSequence);
        for(int i=2; i< sequenceCount; i++) {
            int nextSequence = firsSequence + secondSequence;
            System.out.print(", " + nextSequence);
            firsSequence = secondSequence;
            secondSequence = nextSequence;
        }
    }

    public static void main(String[] args) {
        FibonacciSeriesGenerator.generateSeries(3);
        System.out.println();
        FibonacciSeriesGenerator.generateSeries(4);
        System.out.println();
        FibonacciSeriesGenerator.generateSeries(5);
        System.out.println();
        FibonacciSeriesGenerator.generateSeries(6);
        System.out.println();
        FibonacciSeriesGenerator.generateSeries(7);
    }
}
