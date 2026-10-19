package ru.ithub.algorithms.kt5;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№5, задача 2. Словарь: ADD / REMOVE / COUNT prefix.
 * Trie с подсчётом слов в поддереве.
 */
public final class PrefixDictionary {

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

    public int count(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.wordsInSubtree;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int q = in.nextInt();
        PrefixDictionary dictionary = new PrefixDictionary();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 0; i < q; i++) {
            String operation = in.next();
            if ("ADD".equals(operation)) {
                dictionary.add(in.next());
            } else if ("REMOVE".equals(operation)) {
                dictionary.remove(in.next());
            } else {
                out.println(dictionary.count(in.next()));
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
