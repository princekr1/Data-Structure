package codeforce;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * A generic Min-Heap implementation that stores elements of any comparable type.
 *
 * @param <T> the type of elements held in this heap, which must extend Comparable.
 */
public class MinHeap<T extends Comparable<T>> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] heap; // Use Object[] for generics
    private int size;

    public MinHeap() {
        heap = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Constructs a heap from a collection of items in O(n) time.
     */
    public MinHeap(Collection<T> items) {
        size = items.size();
        heap = new Object[Math.max(size, DEFAULT_CAPACITY)];
        int i = 0;
        for (T item : items) {
            heap[i++] = item;
        }

        // Start from the last non-leaf node and heapify down
        for (int j = (size / 2) - 1; j >= 0; j--) {
            heapifyDown(j);
        }
    }

    // --- Index Helper Methods ---
    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    // --- Type-Safe Element Accessor Methods ---
    @SuppressWarnings("unchecked")
    private T leftChild(int index) { return (T) heap[getLeftChildIndex(index)]; }
    @SuppressWarnings("unchecked")
    private T rightChild(int index) { return (T) heap[getRightChildIndex(index)]; }
    @SuppressWarnings("unchecked")
    private T parent(int index) { return (T) heap[getParentIndex(index)]; }
    @SuppressWarnings("unchecked")
    private T elementAt(int index) { return (T) heap[index]; }


    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    /**
     * Returns the smallest element in the heap without removing it.
     * @return The smallest element.
     * @throws NoSuchElementException if the heap is empty.
     */
    public T peek() {
        if (size == 0) throw new NoSuchElementException("Heap is empty");
        return elementAt(0);
    }

    /**
     * Removes and returns the smallest element in the heap.
     * @return The smallest element.
     * @throws NoSuchElementException if the heap is empty.
     */
    public T poll() {
        if (size == 0) throw new NoSuchElementException("Heap is empty");
        T item = elementAt(0);
        heap[0] = heap[size - 1];
        heap[size - 1] = null; // Help garbage collector
        size--;
        heapifyDown(0);
        return item;
    }

    /**
     * Adds a new element to the heap.
     */
    public void add(T value) {
        ensureExtraCapacity();
        heap[size] = value;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        // While the node has a parent and is smaller than its parent
        while (hasParent(index) && elementAt(index).compareTo(parent(index)) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int startIndex) {
        int index = startIndex;
        // Continue as long as there is a left child (a potential smaller child)
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            // If a right child exists and is smaller than the left child, it's the one to compare
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            // If the current node is smaller than its smallest child, the heap property is satisfied
            if (elementAt(index).compareTo(elementAt(smallerChildIndex)) <= 0) {
                break;
            }

            // Otherwise, swap with the smaller child and continue down
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        Object[] elements = Arrays.copyOf(heap, size);
        return "Heap: " + Arrays.toString(elements);
    }

    // --- Main method for demonstration ---
    public static void main(String[] args) {
        // Using the add method
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.add(10);
        minHeap.add(15);
        minHeap.add(20);
        minHeap.add(17);
        minHeap.add(8);

        System.out.println(minHeap); // Uses the new toString() method
        System.out.println("Peek (min): " + minHeap.peek());
        System.out.println("Poll (remove min): " + minHeap.poll());
        System.out.println(minHeap);
        System.out.println("--------------------");

        // Using the O(n) constructor
        MinHeap<Integer> heapFromList = new MinHeap<>(Arrays.asList(10, 15, 20, 17, 8, 5));
        System.out.println("Heap built from a list:");
        System.out.println(heapFromList);
        System.out.println("Poll (remove min): " + heapFromList.poll());
        System.out.println(heapFromList);
    }
}