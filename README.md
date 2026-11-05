# КТ№1–КТ№9 — практикум по алгоритмам

Решения девяти контрольных точек. Проект рассчитан на **IntelliJ IDEA** (JDK 21).

## Как открыть в IntelliJ IDEA

1. `File` → `Open...` → папка `algorithms`
2. Импорт Maven → **Load**
3. SDK: `ms-21` / JDK 21

Конфигурации: **Main**, **Kt2Main** … **Kt9Main**, **All Tests**.

```bash
mvnw.cmd test
```

## Ветки

`main` / `develop` — актуальный код; `kt1` … `kt9` — по контрольным точкам.

## КТ№9 (`ru.ithub.algorithms.kt9`)

| № | Класс | Суть | Алгоритм |
|---|---|---|---|
| 1 | `MinPalindromePartitions` | Мин. число палиндромных частей | DP O(n²) |
| 2 | `GridPathsCount` | Число путей вправо/вниз | DP O(n·m) |
| 3 | `MaxIndependentSetTree` | Макс. независимое множество | Tree DP O(n) |
| 4 | `MinMergeCost` | Мин. стоимость слияния групп | DP O(n³) |
| 5 | `MaxPathWithScreens` | Макс. путь с k экранами | DP O(n·m·k) |
| 6 | `MaxConnectedSubsetK` | Макс. связное подмножество размера k | Tree knapsack O(n·k²) |

Запуск примеров: `ru.ithub.algorithms.kt9.Kt9Main`.

## КТ№1–КТ№8

Пакеты `kt2`–`kt8` и классы верхнего уровня — предыдущие контрольные точки.
