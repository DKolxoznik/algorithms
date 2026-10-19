# КТ№1–КТ№5 — практикум по алгоритмам

Решения пяти контрольных точек. Проект рассчитан на **IntelliJ IDEA** (JDK 21).

## Как открыть в IntelliJ IDEA

1. `File` → `Open...`
2. Выберите папку `algorithms` (ту, где лежит `pom.xml`)
3. Дождитесь импорта Maven → **Load**
4. SDK: `ms-21` / любой JDK 21

Конфигурации: **Main**, **Kt2Main**, **Kt3Main**, **Kt4Main**, **Kt5Main**, **All Tests**.

```bash
mvnw.cmd test
```

## Ветки

| Ветка | Содержимое |
|---|---|
| `main` / `develop` | актуальный код |
| `kt1` … `kt5` | накопление по контрольным точкам |

## КТ№5 (`ru.ithub.algorithms.kt5`)

| № | Класс | Суть | Сложность |
|---|---|---|---|
| 1 | `GenerateParentheses` | Все правильные скобочные последовательности | O(C_n · n) |
| 2 | `PrefixDictionary` | ADD / REMOVE / COUNT prefix | Trie O(L) |
| 3 | `TwoSingleNumbers` | Два числа, встретившиеся по одному разу | O(n), XOR |
| 4 | `NQueensCount` | Число расстановок n ферзей с запретами | бэктрекинг, n ≤ 14 |
| 5 | `OrderedPrefixDictionary` | ADD / REMOVE / KTH prefix k | Trie + размеры |
| 6 | `MaxXorSubarray` | Макс. XOR на подмассиве | Trie O(n · 30) |

Запуск примеров: `ru.ithub.algorithms.kt5.Kt5Main`.

## КТ№1–КТ№4

Кратко: массивы/окна (КТ1), бинарный поиск и интервалы (КТ2), графы/стеки (КТ3), деревья и медианы (КТ4). Подробности — в пакетах `kt2`–`kt4` и классах верхнего уровня.
