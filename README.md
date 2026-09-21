# КТ№1 и КТ№2 — практикум по алгоритмам

Решения двух контрольных точек. Проект рассчитан на **IntelliJ IDEA** (JDK 21).

## Как открыть в IntelliJ IDEA

1. `File` → `Open...`
2. Выберите папку `algorithms` (ту, где лежит `pom.xml`)
3. Дождитесь импорта Maven (уведомление *Maven projects need to be imported* → **Load**)
4. Если IDEA не нашла JDK: `File` → `Project Structure` → **SDK** `ms-21` / любой JDK 21

Готовые конфигурации запуска: **Main** (КТ№1), **Kt2Main** (КТ№2), **All Tests**.

Тесты: правый клик по `src/test/java` → **Run 'All Tests'**.

## Сборка без IDEA

Нужны JDK 21 и Maven 3.9+. На Windows можно без установленного Maven:

```bash
mvnw.cmd test
mvnw.cmd -q exec:java
```

На GitHub тесты запускаются автоматически (`.github/workflows/ci.yml`).

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

Классы лежат в пакете `ru.ithub.algorithms.kt2`. У каждой задачи есть `main`: читает формат из условия со stdin и печатает ответ в stdout.

| № | Класс | Суть | Сложность |
|---|---|---|---|
| 1 | `SearchInsertPosition` | Первая позиция вставки `target` в отсортированный массив | O(log n) |
| 2 | `RangeSumQueries` | Сумма на отрезке `[L, R]` по запросам | O(n) подготовка, O(1) запрос |
| 3 | `MergeIntervals` | Объединение пересекающихся и касающихся интервалов | O(n log n) |
| 4 | `MinShipCapacity` | Минимальная вместимость корабля за `days` дней | O(n log S) |
| 5 | `CountSubarraysWithSum` | Число подмассивов с суммой `k` (то же решение, что КТ№1.4) | O(n) |
| 6 | `MinMeetingRooms` | Минимум комнат для встреч `[start, end)` | O(n log n) |

Запуск примеров: `ru.ithub.algorithms.kt2.Kt2Main`.

Запуск задачи из консоли (пример для задачи 1):

```text
Ввод:
4 5
1 3 5 6

Вывод:
2
```

В IDEA: правый клик по классу задачи → **Run**, затем ввести данные в консоль. Для задачи 3 программа печатает число интервалов, затем пары `start end`.
