# КТ№1–КТ№8 — практикум по алгоритмам

Решения восьми контрольных точек. Проект рассчитан на **IntelliJ IDEA** (JDK 21).

## Как открыть в IntelliJ IDEA

1. `File` → `Open...` → папка `algorithms`
2. Импорт Maven → **Load**
3. SDK: `ms-21` / JDK 21

Конфигурации: **Main**, **Kt2Main** … **Kt8Main**, **All Tests**.

```bash
mvnw.cmd test
```

## Ветки

`main` / `develop` — актуальный код; `kt1` … `kt8` — по контрольным точкам.

## КТ№8 (`ru.ithub.algorithms.kt8`)

| № | Класс | Суть | Алгоритм |
|---|---|---|---|
| 1 | `MinPlatformCost` | Мин. стоимость пути по платформам | DP O(n) |
| 2 | `ZeroOneKnapsack` | Рюкзак 0/1 | DP O(n·W) |
| 3 | `LongestCommonSubsequence` | Длина НОП | DP O(n·m) |
| 4 | `UnboundedKnapsackExact` | Неогр. рюкзак, масса ровно C | DP O(n·C) |
| 5 | `LisCount` | Длина НВП + число | дерево отрезков O(n log n) |
| 6 | `ShortestCommonSupersequence` | Кратчайшая общая суперпоследовательность | DP + жадная сборка |

Запуск примеров: `ru.ithub.algorithms.kt8.Kt8Main`.

## КТ№1–КТ№7

Пакеты `kt2`–`kt7` и классы верхнего уровня — предыдущие контрольные точки.
