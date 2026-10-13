package ru.ithub.algorithms.kt4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.StringTokenizer;

final class FastScanner {

    private final BufferedReader reader;
    private StringTokenizer tokenizer;

    FastScanner(InputStream in) {
        this.reader = new BufferedReader(new InputStreamReader(in));
    }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = readLine();
            if (line == null) {
                return null;
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
