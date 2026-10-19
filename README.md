# КТ№1–КТ№6 — практикум по алгоритмам

Решения шести контрольных точек. Проект рассчитан на **IntelliJ IDEA** (JDK 21).

## Как открыть в IntelliJ IDEA

1. `File` → `Open...` → папка `algorithms`
2. Импорт Maven → **Load**
3. SDK: `ms-21` / JDK 21

Конфигурации: **Main**, **Kt2Main** … **Kt6Main**, **All Tests**.

```bash
mvnw.cmd test
```

## Ветки

`main` / `develop` — актуальный код; `kt1` … `kt6` — по контрольным точкам.

## КТ№6 (`ru.ithub.algorithms.kt6`)

| № | Класс | Суть | Сложность |
|---|---|---|---|
| 1 | `ReverseLinkedList` | Разворот односвязного списка | O(n), O(1) память |
| 2 | `ConnectivityQueries` | Связность станций | DSU |
| 3 | `LexicographicTopoSort` | Лекс. наименьший топопорядок | Кан + min-heap |
| 4 | `ReverseKGroup` | Разворот блоков по k | O(n), O(1) память |
| 5 | `BipartiteConstraints` | Две группы same/different | DSU с чётностью |
| 6 | `AlienDictionary` | Порядок букв по отсортированным словам | граф + топосорт |

Запуск примеров: `ru.ithub.algorithms.kt6.Kt6Main`.

## КТ№1–КТ№5

Пакеты `kt2`–`kt5` и классы верхнего уровня — предыдущие контрольные точки (массивы, поиск, графы, деревья, trie/XOR).
