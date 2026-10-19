# КТ№1–КТ№7 — практикум по алгоритмам

Решения семи контрольных точек. Проект рассчитан на **IntelliJ IDEA** (JDK 21).

## Как открыть в IntelliJ IDEA

1. `File` → `Open...` → папка `algorithms`
2. Импорт Maven → **Load**
3. SDK: `ms-21` / JDK 21

Конфигурации: **Main**, **Kt2Main** … **Kt7Main**, **All Tests**.

```bash
mvnw.cmd test
```

## Ветки

`main` / `develop` — актуальный код; `kt1` … `kt7` — по контрольным точкам.

## КТ№7 (`ru.ithub.algorithms.kt7`)

| № | Класс | Суть | Алгоритм |
|---|---|---|---|
| 1 | `DijkstraShortestPaths` | Кратчайшие пути, веса ≥ 0 | Дейкстра |
| 2 | `BellmanFordShortestPaths` | Кратчайшие пути, веса любые | Беллман–Форд |
| 3 | `NearestHelpStations` | Ближайший пункт помощи | мультистартовый Дейкстра |
| 4 | `CouponShortestPath` | Путь с одним купоном ⌊w/2⌋ | Дейкстра по состояниям |
| 5 | `NegativeCycleReachability` | `*` / `-` / стоимость | BF + достижимость из отриц. циклов |
| 6 | `LimitedEdgesShortestPaths` | Путь ≤ K рёбер + число путей | DP по рёбрам |

Запуск примеров: `ru.ithub.algorithms.kt7.Kt7Main`.

## КТ№1–КТ№6

Пакеты `kt2`–`kt6` и классы верхнего уровня — предыдущие контрольные точки.
