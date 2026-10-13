package ru.ithub.algorithms.kt4;

/**
 * Бинарное дерево в виде массивов (для задач КТ№4).
 */
public final class BinaryTree {

    public final int[] value;
    public final int[] left;
    public final int[] right;

    public BinaryTree(int[] value, int[] left, int[] right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int size() {
        return value.length;
    }
}
