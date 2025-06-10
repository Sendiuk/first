package ua.com.sendiuk.lesson2;

import java.nio.charset.StandardCharsets;

public class StringExample {
    public static void main(String[] args) {
        // 1. Створення через літерал
        String a = "Java";
        System.out.println("Літерал: " + a);

        // 2. Створення через конструктор (небажано)
        String b = new String("Java");
        System.out.println("Конструктор new String: " + b);

        // 3. Створення з масиву символів
        char[] chars = {'J', 'a', 'v', 'a'};
        String c = new String(chars);
        System.out.println("З масиву символів: " + c);

        // 4. Створення з масиву байтів
        byte[] bytes = {74, 97, 118, 97}; // ASCII коди символів "Java"
        String d = new String(bytes);
        System.out.println("З масиву байтів (ASCII): " + d);

        // 4.1 Створення з масиву байтів з вказанням кодування
        String e = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("З масиву байтів з кодуванням UTF-8: " + e);

        // 5. Створення шляхом конкатенації літералів
        String f = "Ja" + "va"; // компілятор об'єднає ще на етапі компіляції (String Pool)
        System.out.println("Конкатенація літералів: " + f);

        // Конкатенація через змінні відбувається під час виконання програми (runtime)
        // а не під час компіляції, тому результат створюється як новий об'єкт у Heap, а не в String Pool.
        String part1 = "Ja";
        String part2 = "va";
        String result = part1 + part2;
        System.out.println("Конкатенація змінних: " + result);

        // 6. Перетворення за допомогою String.valueOf
        String g = String.valueOf(123);
        System.out.println("String.valueOf(123): " + g);

        // 7. Створення через StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Java");
        sb.append(" The");
        sb.append(" Best");
        String h = sb.toString();
        System.out.println("Через StringBuilder: " + h);

        // Перевірка == та equals()
        System.out.println("\nПеревірки:");
        System.out.println("a == b: " + (a == b));         // false (Посилання (різні об'єкти))
        System.out.println("a.equals(b): " + a.equals(b)); // true (вміст однаковий)
        System.out.println("a == f: " + (a == f));         // true (Посилання(один об'єкт у пулі))
    }
}
