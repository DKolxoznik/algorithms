package ru.ithub.algorithms.kt5;

import java.util.Arrays;

/**
 * Демонстрация примеров КТ№5. В IntelliJ IDEA: Run 'Kt5Main.main()'.
 */
public final class Kt5Main {

    public static void main(String[] args) {
        System.out.println("КТ№5 — практикум по алгоритмам");
        System.out.println();

        System.out.println("1. Правильные скобки n=3");
        System.out.println(GenerateParentheses.generate(3));
        System.out.println();

        System.out.println("2. COUNT prefix");
        PrefixDictionary dict = new PrefixDictionary();
        dict.add("apple");
        dict.add("app");
        dict.add("apply");
        System.out.println(dict.count("app"));
        dict.remove("app");
        System.out.println(dict.count("app"));
        System.out.println();

        System.out.println("3. Два одиночных числа");
        System.out.println(Arrays.toString(TwoSingleNumbers.find(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println();

        System.out.println("4. N ферзей n=4 без запретов");
        System.out.println(NQueensCount.count(4, new boolean[4][4]));
        System.out.println();

        System.out.println("5. KTH prefix");
        OrderedPrefixDictionary ordered = new OrderedPrefixDictionary();
        ordered.add("app");
        ordered.add("apple");
        ordered.add("apply");
        System.out.println(ordered.kth("app", 1));
        System.out.println(ordered.kth("app", 2));
        System.out.println(ordered.kth("app", 3));
        System.out.println(ordered.kth("app", 4));
        System.out.println();

        System.out.println("6. Максимальный XOR подмассива");
        System.out.println(MaxXorSubarray.findMax(new int[]{1, 2, 3, 4}));
    }
}
