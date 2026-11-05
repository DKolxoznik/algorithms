package ru.ithub.algorithms.kt8;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * КТ№8, задача 5. Длина НВП и число таких последовательностей.
 * Дерево отрезков по сжатым значениям, O(n log n).
 */
public final class LisCount {

    private static final int MOD = 1_000_000_007;

    private LisCount() {
    }

    public static int[] solve(int[] a) {
        int n = a.length;
        int[] sorted = a.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        int size = 0;
        for (int value : sorted) {
            if (!rank.containsKey(value)) {
                rank.put(value, size++);
            }
        }

        SegmentTree tree = new SegmentTree(size);
        int bestLen = 0;
        int bestCount = 0;

        for (int value : a) {
            int r = rank.get(value);
            int[] pref = r == 0 ? new int[]{0, 0} : tree.query(0, r - 1);
            int len = pref[0] + 1;
            int cnt = pref[0] == 0 ? 1 : pref[1];

            tree.update(r, len, cnt);

            if (len > bestLen) {
                bestLen = len;
                bestCount = cnt;
            } else if (len == bestLen) {
                bestCount = (bestCount + cnt) % MOD;
            }
        }
        return new int[]{bestLen, bestCount};
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] answer = solve(a);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(answer[0] + " " + answer[1]);
        out.flush();
    }

    private static final class SegmentTree {
        private final int n;
        private final int[] len;
        private final int[] cnt;

        SegmentTree(int n) {
            this.n = n;
            len = new int[4 * n + 4];
            cnt = new int[4 * n + 4];
        }

        void update(int index, int newLen, int newCnt) {
            update(1, 0, n - 1, index, newLen, newCnt);
        }

        int[] query(int left, int right) {
            return query(1, 0, n - 1, left, right);
        }

        private void update(int node, int l, int r, int index, int newLen, int newCnt) {
            if (l == r) {
                if (newLen > len[node]) {
                    len[node] = newLen;
                    cnt[node] = newCnt;
                } else if (newLen == len[node]) {
                    cnt[node] = (cnt[node] + newCnt) % MOD;
                }
                return;
            }
            int mid = (l + r) >>> 1;
            if (index <= mid) {
                update(node << 1, l, mid, index, newLen, newCnt);
            } else {
                update(node << 1 | 1, mid + 1, r, index, newLen, newCnt);
            }
            pull(node);
        }

        private int[] query(int node, int l, int r, int ql, int qr) {
            if (qr < l || r < ql) {
                return new int[]{0, 0};
            }
            if (ql <= l && r <= qr) {
                return new int[]{len[node], cnt[node]};
            }
            int mid = (l + r) >>> 1;
            int[] left = query(node << 1, l, mid, ql, qr);
            int[] right = query(node << 1 | 1, mid + 1, r, ql, qr);
            return merge(left, right);
        }

        private void pull(int node) {
            int[] merged = merge(
                    new int[]{len[node << 1], cnt[node << 1]},
                    new int[]{len[node << 1 | 1], cnt[node << 1 | 1]}
            );
            len[node] = merged[0];
            cnt[node] = merged[1];
        }

        private static int[] merge(int[] a, int[] b) {
            if (a[0] > b[0]) {
                return a;
            }
            if (b[0] > a[0]) {
                return b;
            }
            if (a[0] == 0) {
                return a;
            }
            return new int[]{a[0], (a[1] + b[1]) % MOD};
        }
    }
}
