package ru.ithub.algorithms.kt5;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№5, задача 5. Словарь: ADD / REMOVE / KTH prefix k.
 * Trie с размерами поддеревьев; более короткое слово раньше расширения.
 */
public final class OrderedPrefixDictionary {

    private final Node root = new Node();

    public void add(String word) {
        Node node = root;
        node.wordsInSubtree++;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Node();
            }
            node = node.next[index];
            node.wordsInSubtree++;
        }
        node.wordEnds++;
    }

    public void remove(String word) {
        Node node = root;
        node.wordsInSubtree--;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            node = node.next[index];
            node.wordsInSubtree--;
        }
        node.wordEnds--;
    }

    public String kth(String prefix, int k) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.next[index] == null) {
                return "NONE";
            }
            node = node.next[index];
        }
        if (k > node.wordsInSubtree) {
            return "NONE";
        }
        StringBuilder path = new StringBuilder(prefix);
        return findKth(node, k, path);
    }

    private static String findKth(Node node, int k, StringBuilder path) {
        if (node.wordEnds > 0) {
            if (k <= node.wordEnds) {
                return path.toString();
            }
            k -= node.wordEnds;
        }
        for (int i = 0; i < 26; i++) {
            Node child = node.next[i];
            if (child == null || child.wordsInSubtree == 0) {
                continue;
            }
            if (k <= child.wordsInSubtree) {
                path.append((char) ('a' + i));
                return findKth(child, k, path);
            }
            k -= child.wordsInSubtree;
        }
        return "NONE";
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int q = in.nextInt();
        OrderedPrefixDictionary dictionary = new OrderedPrefixDictionary();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 0; i < q; i++) {
            String operation = in.next();
            if ("ADD".equals(operation)) {
                dictionary.add(in.next());
            } else if ("REMOVE".equals(operation)) {
                dictionary.remove(in.next());
            } else {
                String prefix = in.next();
                int k = in.nextInt();
                out.println(dictionary.kth(prefix, k));
            }
        }
        out.flush();
    }

    private static final class Node {
        private final Node[] next = new Node[26];
        private int wordsInSubtree;
        private int wordEnds;
    }
}
