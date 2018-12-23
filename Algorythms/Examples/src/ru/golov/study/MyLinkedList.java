package ru.golov.study;

import java.util.Iterator;

public class MyLinkedList <T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T val = (T) current.value;
                current = current.next;
                return val;
            }
        };
    }

    private class Node <V> {
        private V value;
        private Node next;

        Node(V value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(T elem) {
        if (first == null) {
            first = new Node<T>(elem, null);
            last = first;
        } else {
            Node newNode = new Node<T>(elem, null);
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    public boolean remove(T elem) {
        Node current = first;

        if (first.value.equals(elem)) {
            first = first.next;
            size--;
            return true;
        }

        for (int i = 1; i < size; i++) {
            if (current.next.value.equals(elem)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(1);
        myLinkedList.remove(1);

        for (Integer i: myLinkedList) {
            System.out.println(i);
        }
    }
}
