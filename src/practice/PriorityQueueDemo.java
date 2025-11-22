package practice;

// Java program to iterate elements
// to a PriorityQueue

import java.util.*;

public class PriorityQueueDemo {

    // Main Method
    public static void main(String args[])
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(5);
        pq.add(15);
        pq.add(25);
        pq.add(2);
        pq.add(1);

        Iterator iterator = pq.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
