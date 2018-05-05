package main.java;

import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int size;

    private static final int DEFAULT_SIZE = 12;

    public Heap() {
        this(DEFAULT_SIZE);
    }

    public Heap(int length) {
        heap = new int[length];
    }

    public void insert(int element) {
        checkSize();

        heap[size] = element;
        siftUp(size);

        size++;
    }

    public int extractMax() {
        checkEmpty();

        int result = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);


        return result;
    }

    public void remove(int elemIdx) {
        heap[elemIdx] = Integer.MAX_VALUE;
        siftUp(elemIdx);
        extractMax();

        size--;
    }

    public void changePriority(int elemIdx, int newPriority) {
        int oldPriority = heap[elemIdx];

        heap[elemIdx] = newPriority;

        if (newPriority > oldPriority) {
            siftUp(elemIdx);
        } else {
            siftDown(elemIdx);
        }
    }

    private void siftUp(int elemIdx) {
        int parent = getParent(elemIdx);

        if (elemIdx > 0 && heap[parent] < heap[elemIdx]) {
            swapElements(elemIdx, parent);
            siftUp(parent);
        }
    }

    private void siftDown(int elemIdx) {
       int maxChildIdx = getMaxChildIdx(
               getLeftChild(elemIdx),
               getRightChild(elemIdx)
       );

       if (maxChildIdx != -1 && heap[maxChildIdx] > heap[elemIdx]) {
           swapElements(maxChildIdx, elemIdx);
           siftDown(maxChildIdx);
       }
    }

    private int getParent(int elemIdx) {
        return elemIdx == 0 ? -1 : (int) (Math.round(elemIdx / 2.0) - 1);
    }

    private int getLeftChild(int elemIdx) {
        return 2 * elemIdx + 1 > size - 1
                ? -1
                : 2 * elemIdx + 1;
    }

    private int getRightChild(int elemIdx) {
        return 2 * elemIdx + 2 > size - 1
                ? -1
                : 2 * elemIdx + 2;
    }

    private int getMaxChildIdx(int childIdx1, int childIdx2) {
        if (childIdx1 == -1 && childIdx2 == -1) {
            return -1;
        }

        int elem1 = heap[childIdx1];
        int elem2 = heap[childIdx2];

        return elem1 > elem2 ? childIdx1 : childIdx2;
    }

    private void checkSize() {
        if (heap.length - 1 == size) {
            throw new IndexOutOfBoundsException("Heap is overflow");
        }
    }

    private void checkEmpty() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    private void swapElements(int elemIdx1, int elemIdx2) {
        int tmp = heap[elemIdx1];
        heap[elemIdx1] = heap[elemIdx2];
        heap[elemIdx2] = tmp;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        System.out.println("Add elements");
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(10);
        heap.insert(32);
        heap.insert(12);
        heap.insert(15);
        heap.insert(1);
        System.out.println(heap);

        int max = heap.extractMax();
        System.out.println(String.format("Max: {%d}", max));
        System.out.println(heap);
    }
}
