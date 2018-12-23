package ru.golov.study;

import java.util.stream.Stream;

public class MySearchTree <T extends Comparable<T>> {

    private Node<T> rootNode;

    private class Node <V> {
        private Node left;
        private Node rigth;
        private V value;

        public Node(Node left, Node rigth, V value) {
            this.left = left;
            this.rigth = rigth;
            this.value = value;
        }
    }


    public MySearchTree() {
    }

    public MySearchTree(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    public void add(T elem) {
        if (rootNode == null) {
            rootNode = new Node<>(null, null, elem);
        } else {
            Node<T> currentNode = rootNode;
            Node<T> lastNode = rootNode;

            while (currentNode != null) {
                lastNode = currentNode;

                if (elem.compareTo(currentNode.value) > 0) {
                    currentNode = currentNode.rigth;
                } else {
                    currentNode = currentNode.left;
                }
            }

            if (elem.compareTo(lastNode.value) > 0) {
                lastNode.rigth = new Node<T>(null, null, elem);
            } else {
                lastNode.left = new Node<T>(null, null, elem);
            }
        }
    }

    private String getStringTree(Node<T> node) {
        if (node.left == null && node.rigth == null) {
            return node.value.toString();
        }

        String left = "";
        String right = "";

        if (node.left != null) {
            left = getStringTree(node.left);
        }
        if (node.rigth != null) {
            right = getStringTree(node.rigth);
        }

        String current = node.value.toString();

        return left + " | " + current + " | " + right;
    }

    public int size() {
        return nodeDeep(rootNode);
    }

    private int nodeDeep(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return nodeDeep(node.left) + nodeDeep(node.rigth) + 1;
    }

    @Override
    public String toString() {
        return getStringTree(rootNode);
    }

    public static void main(String[] args) {
        MySearchTree<Integer> tree = new MySearchTree<>();
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(2);
//        System.out.println(tree);
//        System.out.println(tree.rootNode.rigth.value);
        System.out.println(tree.size());
        }
}
