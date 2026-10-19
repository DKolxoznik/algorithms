package ru.ithub.algorithms.kt6;

import java.util.Arrays;

/**
 * Демонстрация примеров КТ№6. В IntelliJ IDEA: Run 'Kt6Main.main()'.
 */
public final class Kt6Main {

    public static void main(String[] args) {
        System.out.println("КТ№6 — практикум по алгоритмам");
        System.out.println();

        System.out.println("1. Разворот списка");
        System.out.println(Arrays.toString(ListNode.toArray(
                ReverseLinkedList.reverse(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}))
        )));
        System.out.println();

        System.out.println("2. Связность");
        ConnectivityQueries dsu = new ConnectivityQueries(3);
        dsu.connect(1, 2);
        System.out.println(dsu.connected(1, 2) ? "YES" : "NO");
        System.out.println(dsu.connected(1, 3) ? "YES" : "NO");
        System.out.println();

        System.out.println("3. Топосорт");
        System.out.println(Arrays.toString(LexicographicTopoSort.sort(3, new int[][]{{1, 2}, {1, 3}})));
        System.out.println();

        System.out.println("4. Reverse k-group, k=2");
        System.out.println(Arrays.toString(ListNode.toArray(
                ReverseKGroup.reverseKGroup(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2)
        )));
        System.out.println();

        System.out.println("5. Группы");
        BipartiteConstraints groups = new BipartiteConstraints(3);
        System.out.println(groups.addConstraint(1, 2, 0) ? "YES" : "NO");
        System.out.println(groups.addConstraint(2, 3, 1) ? "YES" : "NO");
        System.out.println(groups.addConstraint(1, 3, 0) ? "YES" : "NO");
        System.out.println();

        System.out.println("6. Alien dictionary");
        System.out.println(AlienDictionary.findOrder(3, new String[]{"ba", "bc", "ac"}));
        System.out.println(AlienDictionary.findOrder(2, new String[]{"ab", "a"}));
    }
}
