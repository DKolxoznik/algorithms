# КТ№1–КТ№4 — практикум по алгоритмам

Решения четырёх контрольных точек. Проект рассчитан на **IntelliJ IDEA** (JDK 21).

## Как открыть в IntelliJ IDEA

1. `File` → `Open...`
2. Выберите папку `algorithms` (ту, где лежит `pom.xml`)
3. Дождитесь импорта Maven (уведомление *Maven projects need to be imported* → **Load**)
4. Если IDEA не нашла JDK: `File` → `Project Structure` → **SDK** `ms-21` / любой JDK 21

Готовые конфигурации запуска: **Main**, **Kt2Main**, **Kt3Main**, **Kt4Main**, **All Tests**.

Тесты: правый клик по `src/test/java` → **Run 'All Tests'**.

## Сборка без IDEA

```bash
mvnw.cmd test
```

На GitHub тесты запускаются автоматически (`.github/workflows/ci.yml`).

## Ветки

| Ветка | Содержимое |
|---|---|
| `main` / `develop` | актуальный код |
| `kt1` | только КТ№1 |
| `kt2` | … + КТ№2 |
| `kt3` | … + КТ№3 |
| `kt4` | … + КТ№4 |

## КТ№1

| № | Класс | Суть |
|---|---|---|
| 1 | `LongestConsecutiveSequence` | Самая длинная последовательность подряд |
| 2 | `ZeroSumTriplets` | Уникальные тройки с суммой 0 |
| 3 | `LongestTwoTypesSubarray` | Участок не более чем с 2 типами |
| 4 | `SubarraySumEqualsK` | Подмассивы с суммой `k` |
| 5 | `MaxWaterContainer` | Максимальная площадь контейнера |
| 6 | `MinCoveringSubstring` | Минимальная подстрока-покрытие |

## КТ№2 (`ru.ithub.algorithms.kt2`)

| № | Класс | Суть |
|---|---|---|
| 1 | `SearchInsertPosition` | Первая позиция вставки |
| 2 | `RangeSumQueries` | Сумма на отрезке |
| 3 | `MergeIntervals` | Объединение интервалов |
| 4 | `MinShipCapacity` | Минимальная вместимость корабля |
| 5 | `CountSubarraysWithSum` | Подмассивы с суммой `k` |
| 6 | `MinMeetingRooms` | Минимум переговорных |

## КТ№3 (`ru.ithub.algorithms.kt3`)

| № | Класс | Суть |
|---|---|---|
| 1 | `DaysUntilHigherPrice` | Дни до более высокой цены |
| 2 | `ShortestPathInMaze` | Кратчайший путь S → T |
| 3 | `LinkedListCycle` | Цикл в `next[]` (Флойд) |
| 4 | `MaximalRectangle` | Макс. прямоугольник из единиц |
| 5 | `ShortestPathWithKeys` | Путь с ключами и дверями |
| 6 | `FindDuplicateNumber` | Повторяющееся число (Флойд) |

## КТ№4 (`ru.ithub.algorithms.kt4`)

| № | Класс | Суть | Сложность |
|---|---|---|---|
| 1 | `LevelSums` | Суммы вершин по уровням дерева | O(n), BFS |
| 2 | `TopKFrequent` | k самых частых чисел | O(n + u log u) |
| 3 | `RunningMedian` | Медиана после каждого числа | O(n log n), два хипа |
| 4 | `MaxPathSum` | Макс. стоимость пути в дереве | O(n) |
| 5 | `KthPairSum` | k-я сумма A[i]+B[j] | O((n+m) log R) |
| 6 | `SlidingWindowMedian` | Медианы окна длины k | O(n log k) |

Запуск примеров: `ru.ithub.algorithms.kt4.Kt4Main`.
