package ru.ithub.algorithms.kt5;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№5, задача 6. Максимальный XOR на непрерывном подмассиве.
 * Trie по префиксным XOR. Время: O(n * 30).
 */
public final class MaxXorSubarray {

    private MaxXorSubarray() {
    }

    public static int findMax(int[] nums) {
        BinaryTrie trie = new BinaryTrie();
        trie.insert(0);
        int prefix = 0;
        int best = 0;
        for (int num : nums) {
            prefix ^= num;
            best = Math.max(best, trie.maxXor(prefix));
            trie.insert(prefix);
        }
        return best;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(findMax(nums));
        out.flush();
    }

    private static final class BinaryTrie {
        private final Node root = new Node();

        void insert(int value) {
            Node node = root;
            for (int bit = 29; bit >= 0; bit--) {
                int b = (value >> bit) & 1;
                if (node.next[b] == null) {
                    node.next[b] = new Node();
                }
                node = node.next[b];
            }
        }

        int maxXor(int value) {
            Node node = root;
            int result = 0;
            for (int bit = 29; bit >= 0; bit--) {
                int b = (value >> bit) & 1;
                int want = b ^ 1;
                if (node.next[want] != null) {
                    result |= 1 << bit;
                    node = node.next[want];
                } else {
                    node = node.next[b];
                }
            }
            return result;
        }

        private static final class Node {
            private final Node[] next = new Node[2];
        }
    }
}
