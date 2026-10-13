# КТ№1–КТ№3 — практикум по алгоритмам

Решения трёх контрольных точек. Проект рассчитан на **IntelliJ IDEA** (JDK 21).

## Как открыть в IntelliJ IDEA

1. `File` → `Open...`
2. Выберите папку `algorithms` (ту, где лежит `pom.xml`)
3. Дождитесь импорта Maven (уведомление *Maven projects need to be imported* → **Load**)
4. Если IDEA не нашла JDK: `File` → `Project Structure` → **SDK** `ms-21` / любой JDK 21

Готовые конфигурации запуска: **Main** (КТ№1), **Kt2Main** (КТ№2), **Kt3Main** (КТ№3), **All Tests**.

Тесты: правый клик по `src/test/java` → **Run 'All Tests'**.

## Сборка без IDEA

Нужны JDK 21 и Maven 3.9+. На Windows можно без установленного Maven:

```bash
mvnw.cmd test
mvnw.cmd -q exec:java
```

На GitHub тесты запускаются автоматически (`.github/workflows/ci.yml`).

## Ветки

| Ветка | Содержимое |
|---|---|
| `main` / `develop` | актуальный код |
| `kt1` | только КТ№1 |
| `kt2` | КТ№1 + КТ№2 |
| `kt3` | КТ№1 + КТ№2 + КТ№3 |

## КТ№1

| № | Класс | Суть | Сложность |
|---|---|---|---|
| 1 | `LongestConsecutiveSequence` | Длина самой длинной последовательности подряд идущих значений | O(n) время, O(n) память |
| 2 | `ZeroSumTriplets` | Все уникальные тройки с суммой 0 | O(n²) время |
| 3 | `LongestTwoTypesSubarray` | Максимальный непрерывный участок с не более чем 2 типами | O(n) время |
| 4 | `SubarraySumEqualsK` | Число подмассивов с суммой `k` | O(n) время, O(n) память |
| 5 | `MaxWaterContainer` | Максимальная площадь контейнера между двумя стенками | O(n) время |
| 6 | `MinCoveringSubstring` | Самая короткая подстрока, покрывающая все символы `target` | O(n + m) время |

Запуск примеров: `ru.ithub.algorithms.Main`.

## КТ№2

Классы в пакете `ru.ithub.algorithms.kt2`. У каждой задачи есть `main` (stdin → stdout).

| № | Класс | Суть | Сложность |
|---|---|---|---|
| 1 | `SearchInsertPosition` | Первая позиция вставки `target` в отсортированный массив | O(log n) |
| 2 | `RangeSumQueries` | Сумма на отрезке `[L, R]` по запросам | O(n) подготовка, O(1) запрос |
| 3 | `MergeIntervals` | Объединение пересекающихся и касающихся интервалов | O(n log n) |
| 4 | `MinShipCapacity` | Минимальная вместимость корабля за `days` дней | O(n log S) |
| 5 | `CountSubarraysWithSum` | Число подмассивов с суммой `k` | O(n) |
| 6 | `MinMeetingRooms` | Минимум комнат для встреч `[start, end)` | O(n log n) |

Запуск примеров: `ru.ithub.algorithms.kt2.Kt2Main`.

## КТ№3

Классы в пакете `ru.ithub.algorithms.kt3`. У каждой задачи есть `main` (stdin → stdout).

| № | Класс | Суть | Сложность |
|---|---|---|---|
| 1 | `DaysUntilHigherPrice` | Через сколько дней цена строго вырастет | O(n), монотонный стек |
| 2 | `ShortestPathInMaze` | Кратчайший путь S → T по `.` | O(n·m), BFS |
| 3 | `LinkedListCycle` | Есть ли цикл в `next[]` из `start` | O(n) время, O(1) память, Флойд |
| 4 | `MaximalRectangle` | Макс. площадь прямоугольника из единиц | O(n·m), гистограмма + стек |
| 5 | `ShortestPathWithKeys` | Путь S → T с ключами `a-j` и дверями `A-J` | O(n·m·2ᴷ), BFS по маске |
| 6 | `FindDuplicateNumber` | Повторяющееся число в массиве длины n+1 | O(n) время, O(1) память, Флойд |

Запуск примеров: `ru.ithub.algorithms.kt3.Kt3Main`.
