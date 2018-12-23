package ru.golov.study;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Huffman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<Node> nodes  = getFrequentChars(input);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(Node::getFrequency));
        priorityQueue.addAll(nodes);

        Node bTree = getHuffmanTree(priorityQueue);
        Map<Character, String> charCodesMap = getCharCodesMap(bTree);
        String result = encodeString(input, charCodesMap);

        System.out.printf("%d %d\n", nodes.size(), result.length());
        charCodesMap.forEach((k, v) -> System.out.printf("%c: %s\n", k, v));
        System.out.println(result);
    }



    private static Node getHuffmanTree(PriorityQueue<Node> priorityQueue) {
        int queueSize = priorityQueue.size();

        for (int i = 0; i < queueSize - 1; i++) {
            Node node1 = priorityQueue.poll();
            Node node2 = priorityQueue.poll();
            Node newNode = new Node(null, node1.getFrequency() + node2.getFrequency());
            newNode.setLeft(node1);
            newNode.setRight(node2);
            priorityQueue.add(newNode);
        }
        return priorityQueue.poll();
    }

    private static String encodeString(String input, Map<Character, String> charCodesMap) {
        return input.chars()
                .mapToObj(item -> (char) item)
                .map(charCodesMap::get)
                .collect(Collectors.joining());
    }

    private static List<Node> getFrequentChars(String str) {
        return str.chars()
                .mapToObj(item -> (char) item)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .map(e -> new Node(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private static Map<Character, String> getCharCodesMap(Node bTree) {
        Map<Character, String> charCodesMap = new HashMap<>();
        if (bTree.getLeft() == null && bTree.getRight() == null) {
            charCodesMap.put(bTree.getCharacter(), "0");
        } else {
            getCharacterCodes(bTree, charCodesMap, "");
        }
        return charCodesMap;
    }

    private static void getCharacterCodes(Node bTree, Map<Character, String> result, String prefix) {
        if (bTree.getCharacter() != null) {
            result.put(bTree.getCharacter(), prefix);
        } else {
            getCharacterCodes(bTree.getLeft(), result, prefix + "0");
            getCharacterCodes(bTree.getRight(), result, prefix + "1");
        }
    }


    private static class Node {
        private Character character;
        private Long frequency;
        private Node left;
        private Node right;

        public Node(Character character, Long frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        public Character getCharacter() {
            return character;
        }

        public Long getFrequency() {
            return frequency;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
