package ru.ithub.algorithms.kt7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Демонстрация примеров КТ№7. В IntelliJ IDEA: Run 'Kt7Main.main()'.
 */
public final class Kt7Main {

    public static void main(String[] args) {
        System.out.println("КТ№7 — практикум по алгоритмам");
        System.out.println();

        System.out.println("1. Дейкстра");
        List<List<DijkstraShortestPaths.Edge>> g1 = empty(3);
        g1.get(1).add(new DijkstraShortestPaths.Edge(2, 5));
        g1.get(2).add(new DijkstraShortestPaths.Edge(3, 1));
        long[] d1 = DijkstraShortestPaths.distances(3, 1, g1);
        System.out.println(formatDist(d1));
        System.out.println();

        System.out.println("2. Беллман–Форд");
        long[] d2 = BellmanFordShortestPaths.distances(
                3, 1,
                new int[]{1, 2},
                new int[]{2, 3},
                new long[]{5, -2}
        );
        System.out.println(formatDist(d2));
        System.out.println();

        System.out.println("3. Пункты помощи");
        List<List<NearestHelpStations.Edge>> g3 = emptyHelp(3);
        g3.get(1).add(new NearestHelpStations.Edge(2, 3));
        g3.get(2).add(new NearestHelpStations.Edge(1, 3));
        g3.get(2).add(new NearestHelpStations.Edge(3, 4));
        g3.get(3).add(new NearestHelpStations.Edge(2, 4));
        NearestHelpStations.Result r3 = NearestHelpStations.compute(3, new int[]{1, 3}, g3);
        for (int i = 1; i <= 3; i++) {
            System.out.println(r3.nearest[i] + " " + r3.dist[i]);
        }
        System.out.println();

        System.out.println("4. Купон");
        List<List<CouponShortestPath.Edge>> g4 = emptyCoupon(3);
        g4.get(1).add(new CouponShortestPath.Edge(2, 10));
        g4.get(2).add(new CouponShortestPath.Edge(3, 10));
        System.out.println(CouponShortestPath.minCost(3, 1, 3, g4));
        System.out.println();

        System.out.println("5. Отрицательные циклы");
        String[] c5 = NegativeCycleReachability.classify(
                3, 1,
                new int[]{1, 2, 2},
                new int[]{2, 3, 2},
                new long[]{1, 1, -1}
        );
        System.out.println(Arrays.toString(Arrays.copyOfRange(c5, 1, 4)));
        System.out.println();

        System.out.println("6. Не более K рёбер");
        LimitedEdgesShortestPaths.Result r6 = LimitedEdgesShortestPaths.compute(
                3, 1, 3, 2,
                new int[]{1, 2},
                new int[]{2, 3},
                new long[]{1, 1}
        );
        System.out.println(r6.cost + " " + r6.ways);
    }

    private static List<List<DijkstraShortestPaths.Edge>> empty(int n) {
        List<List<DijkstraShortestPaths.Edge>> g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    private static List<List<NearestHelpStations.Edge>> emptyHelp(int n) {
        List<List<NearestHelpStations.Edge>> g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    private static List<List<CouponShortestPath.Edge>> emptyCoupon(int n) {
        List<List<CouponShortestPath.Edge>> g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    private static String formatDist(long[] dist) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            if (i > 1) {
                sb.append(' ');
            }
            sb.append(dist[i] >= DijkstraShortestPaths.INF ? "INF" : dist[i]);
        }
        return sb.toString();
    }
}
