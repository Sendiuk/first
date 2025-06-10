package ua.com.sendiuk.lesson3;

public class LoopExamples {

    public static void main(String[] args) {
        System.out.println("===== ДЕМОНСТРАЦІЯ ЦИКЛІВ В JAVA =====\n");

        // 1. Цикл for
        System.out.println("1. Стандартний цикл for:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("   Ітерація " + i);
        }

        // 2. Цикл for з кількома змінними
        System.out.println("\n2. Цикл for з кількома змінними:");
        for (int i = 1, j = 10; i <= 5; i++, j--) {
            System.out.println("   i = " + i + ", j = " + j);
        }

        // 3. for-each цикл (розширений for)
        System.out.println("\n3. For-each цикл для масиву:");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int number : numbers) {
            System.out.println("   Значення: " + number);
        }

        // 4. Цикл while
        System.out.println("\n4. Цикл while:");
        int count = 1;
        while (count <= 5) {
            System.out.println("   Лічильник: " + count);
            count++;
        }

        // 5. Цикл do-while (виконується хоча б один раз)
        System.out.println("\n5. Цикл do-while:");
        int x = 1;
        do {
            System.out.println("   Значення x: " + x);
            x++;
        } while (x <= 5);

        // 6. Порівняння while і do-while з невиконуваною умовою
        System.out.println("\n6. Порівняння while і do-while з невиконуваною умовою:");
        System.out.println("   Цикл while з невиконуваною умовою:");
        int a = 10;
        while (a < 10) {
            System.out.println("   Цей текст не буде виведено");
            a++;
        }
        System.out.println("   Цикл while не виконався жодного разу");

        System.out.println("   Цикл do-while з невиконуваною умовою:");
        int b = 10;
        do {
            System.out.println("   Цей текст виведеться один раз");
            b++;
        } while (b < 10);
        System.out.println("   Цикл do-while виконався один раз");

        // 7. Цикл з break
        System.out.println("\n7. Використання break для виходу з циклу:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("   Досягнуто значення 6, виходимо з циклу");
                break; // Вихід з циклу
            }
            System.out.println("   Значення i: " + i);
        }

        // 8. Цикл з continue
        System.out.println("\n8. Використання continue для пропуску ітерації:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                // Пропускаємо парні числа
                continue;
            }
            System.out.println("   Непарне число: " + i);
        }

        // 9. Нескінченний цикл з умовою виходу
        System.out.println("\n9. Нескінченний цикл з умовою виходу:");
        int counter = 1;
        for (; ; ) { // Нескінченний цикл
            System.out.println("   Ітерація #" + counter);
            counter++;
            if (counter > 5) {
                System.out.println("   Досягнуто умову виходу");
                break;
            }
        }

        // 10. Нескінченний цикл while з умовою виходу
        System.out.println("\n10. Нескінченний цикл while з умовою виходу:");
        counter = 1;
        while (true) { // Нескінченний цикл
            System.out.println("   Ітерація #" + counter);
            counter++;
            if (counter > 5) {
                System.out.println("   Досягнуто умову виходу");
                break;
            }
        }

        // 11. Вкладені цикли
        System.out.println("\n11. Вкладені цикли:");
        System.out.println("   Таблиця множення для чисел від 1 до 5:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("   " + i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println(); // Перехід на новий рядок після внутрішнього циклу
        }
    }
}
