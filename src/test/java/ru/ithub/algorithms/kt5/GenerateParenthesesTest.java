package ru.ithub.algorithms.kt5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateParenthesesTest {

    @Test
    void threePairsLexOrder() {
        assertEquals(
                List.of("((()))", "(()())", "(())()", "()(())", "()()()"),
                GenerateParentheses.generate(3)
        );
    }

    @Test
    void onePair() {
        assertEquals(List.of("()"), GenerateParentheses.generate(1));
    }

    @Test
    void twoPairs() {
        assertEquals(List.of("(())", "()()"), GenerateParentheses.generate(2));
    }
}
