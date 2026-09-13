# КТ№1 — практикум по алгоритмам

Решения шести задач контрольной точки. Проект рассчитан на **IntelliJ IDEA** (JDK 21).

## Как открыть в IntelliJ IDEA

1. `File` → `Open...`
2. Выберите папку `algorithms` (ту, где лежит `pom.xml`)
3. Дождитесь импорта Maven (уведомление *Maven projects need to be imported* → **Load**)
4. Если IDEA не нашла JDK: `File` → `Project Structure` → **SDK** `ms-21` / любой JDK 21

Готовые конфигурации запуска (выпадающий список справа сверху): **Main** и **All Tests**.

Запуск примеров: `src/main/java/ru/ithub/algorithms/Main.java` → **Run**.

Тесты: правый клик по `src/test/java` → **Run 'All Tests'**.

## Сборка без IDEA

Нужны JDK 21 и Maven 3.9+. На Windows можно без установленного Maven:

```bash
mvnw.cmd test
mvnw.cmd -q exec:java
```

или, если Maven уже в PATH:

```bash
mvn test
mvn -q exec:java
```

На GitHub тесты запускаются автоматически (`.github/workflows/ci.yml`).

## Задачи

| № | Класс | Суть | Сложность |
|---|---|---|---|
| 1 | `LongestConsecutiveSequence` | Длина самой длинной последовательности подряд идущих значений | O(n) время, O(n) память |
| 2 | `ZeroSumTriplets` | Все уникальные тройки с суммой 0 | O(n²) время |
| 3 | `LongestTwoTypesSubarray` | Максимальный непрерывный участок с не более чем 2 типами | O(n) время |
| 4 | `SubarraySumEqualsK` | Число подмассивов с суммой `k` | O(n) время, O(n) память |
| 5 | `MaxWaterContainer` | Максимальная площадь контейнера между двумя стенками | O(n) время |
| 6 | `MinCoveringSubstring` | Самая короткая подстрока, покрывающая все символы `target` | O(n + m) время |

Ограничения доходят до 200 000 элементов, поэтому решения линейные или квадратичные там, где это допустимо (задача 2: `n ≤ 3000`).
