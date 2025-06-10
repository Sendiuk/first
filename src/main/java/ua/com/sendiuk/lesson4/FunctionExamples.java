package ua.com.sendiuk.lesson4;

public class FunctionExamples {
    public static void main(String[] args) {

        // 1. Виклик простої функції без параметрів і без повернення значення
        System.out.println("1. Виклик простої функції без параметрів:");
        printDivider(); // Виклик функції
        printGreeting(); // Виклик ще однієї функції
        printDivider();

        // 2. Функція з параметрами
        System.out.println("\n2. Функція з параметрами:");
        printDivider();
        printPersonalizedGreeting("Іван"); // Передаємо аргумент у функцію
        printPersonalizedGreeting("Марія");
        printDivider();

        // 3. Функція з поверненням значення
        System.out.println("\n3. Функція з поверненням значення:");
        int sum = add(5, 3); // Зберігаємо результат виклику функції
        System.out.println("   Результат додавання 5 + 3 = " + sum);

        // Використання результату функції безпосередньо в іншому виразі
        System.out.println("   Результат множення суми на 2: " + (add(10, 20) * 2));
        System.out.println("   Квадрат числа 7: " + square(7));

        // 4. Функція з різними типами параметрів
        System.out.println("\n4. Функція з різними типами параметрів:");
        displayUserInfo("Олена", 25, true);
        displayUserInfo("Петро", 30, false);

        // 5. Перевантаження функцій (overloading)
        System.out.println("\n5. Перевантаження функцій (однакове ім'я, різні параметри):");
        System.out.println("   multiply(3, 4) = " + multiply(3, 4));
        System.out.println("   multiply(2.5, 3.0) = " + multiply(2.5, 3.0));
        System.out.println("   multiply(2, 3, 4) = " + multiply(2, 3, 4));

        // 6. Рекурсивні функції
        System.out.println("\n6. Рекурсивна функція (функція, що викликає сама себе):");
        System.out.println("   Факторіал числа 5: " + factorial(5));
        System.out.println("   Детальне обчислення факторіалу 5:");
        printFactorialSteps(5);

        // 7. Функції, що викликають інші функції
        System.out.println("\n7. Функції, що викликають інші функції:");
        System.out.println("   Площа прямокутника 4x6: " + calculateRectangleArea(4, 6));
        System.out.println("   Площа квадрата зі стороною 5: " + calculateSquareArea(5));

        // 8. Функції з масивами
        System.out.println("\n8. Функції з масивами:");
        int[] numbers = {5, 10, 15, 20, 25};
        System.out.println("   Сума елементів масиву: " + sumArray(numbers));
        System.out.println("   Середнє значення елементів масиву: " + calculateAverage(numbers));

        // 9. Передача параметрів за значенням vs за посиланням
        System.out.println("\n9. Передача параметрів за значенням vs за посиланням:");

        // Примітивні типи передаються за значенням
        int x = 10;
        System.out.println("   До виклику функції: x = " + x);
        modifyValue(x);
        System.out.println("   Після виклику функції: x = " + x + " (значення не змінилось)");

        // Об'єкти (включаючи масиви) передаються за посиланням
        int[] array = {1, 2, 3};
        System.out.print("   До виклику функції: array = ");
        printArray(array);
        modifyArray(array);
        System.out.print("   Після виклику функції: array = ");
        printArray(array);
        System.out.println("   (масив змінився, бо передається за посиланням)");

        // 10. Функція з варіативною кількістю аргументів (varargs)
        System.out.println("\n10. Функція з варіативною кількістю аргументів (varargs):");
        System.out.println("   Сума чисел (1, 2, 3): " + sumVarargs(1, 2, 3));
        System.out.println("   Сума чисел (5, 10, 15, 20): " + sumVarargs(5, 10, 15, 20));
        System.out.println("   Сума чисел (немає аргументів): " + sumVarargs());

    }

    // ===== ВИЗНАЧЕННЯ ФУНКЦІЙ =====

    /**
     * Проста функція без параметрів і без повернення значення
     * void означає, що функція нічого не повертає
     */
    public static void printDivider() {
        System.out.println("   ------------------------");
    }

    /**
     * Функція без параметрів і без повернення значення
     */
    public static void printGreeting() {
        System.out.println("   Привіт, світ!");
    }

    /**
     * Функція з одним параметром
     * @param name ім'я користувача
     */
    public static void printPersonalizedGreeting(String name) {
        System.out.println("   Привіт, " + name + "!");
    }

    /**
     * Функція з параметрами, яка повертає значення
     * @param a перше число
     * @param b друге число
     * @return сума двох чисел
     */
    public static int add(int a, int b) {
        return a + b; // повертаємо результат
    }

    /**
     * Функція для обчислення квадрату числа
     * @param number число для піднесення до квадрату
     * @return квадрат числа
     */
    public static int square(int number) {
        return number * number;
    }

    /**
     * Функція з параметрами різних типів
     * @param name ім'я користувача
     * @param age вік користувача
     * @param isStudent статус студента
     */
    public static void displayUserInfo(String name, int age, boolean isStudent) {
        System.out.println("   Ім'я: " + name);
        System.out.println("   Вік: " + age);
        System.out.println("   Статус студента: " + (isStudent ? "Так" : "Ні"));
    }

    // Приклади перевантажених функцій (мають однакове ім'я, але різні параметри)

    /**
     * Множення двох цілих чисел
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Множення двох дійсних чисел
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Множення трьох цілих чисел
     */
    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    /**
     * Рекурсивна функція для обчислення факторіалу
     * @param n число для обчислення факторіалу
     * @return факторіал числа n
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;  // базовий випадок
        } else {
            return n * factorial(n - 1);  // рекурсивний виклик
        }
    }

    /**
     * Функція для виведення кроків обчислення факторіалу
     * @param n число для обчислення факторіалу
     */
    public static void printFactorialSteps(int n) {
        System.out.print("   " + n + "! = ");
        printFactorialStepsHelper(n);
        System.out.println(" = " + factorial(n));
    }

    /**
     * Допоміжна функція для виведення кроків обчислення факторіалу
     * @param n число для обчислення факторіалу
     */
    private static void printFactorialStepsHelper(int n) {
        if (n <= 1) {
            System.out.print("1");
        } else {
            System.out.print(n + " × ");
            printFactorialStepsHelper(n - 1);
        }
    }

    /**
     * Функція для обчислення площі прямокутника
     * @param width ширина прямокутника
     * @param height висота прямокутника
     * @return площа прямокутника
     */
    public static int calculateRectangleArea(int width, int height) {
        return multiply(width, height);  // використовуємо раніше визначену функцію
    }

    /**
     * Функція для обчислення площі квадрата
     * @param side сторона квадрата
     * @return площа квадрата
     */
    public static int calculateSquareArea(int side) {
        return calculateRectangleArea(side, side);  // використовуємо іншу функцію
    }

    /**
     * Функція для обчислення суми елементів масиву
     * @param array масив цілих чисел
     * @return сума елементів масиву
     */
    public static int sumArray(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    /**
     * Функція для обчислення середнього значення елементів масиву
     * @param array масив цілих чисел
     * @return середнє значення елементів масиву
     */
    public static double calculateAverage(int[] array) {
        // Викликаємо іншу функцію для обчислення суми
        int sum = sumArray(array);
        return (double) sum / array.length;
    }

    /**
     * Функція, яка демонструє передачу примітивного типу за значенням
     * @param value значення для модифікації
     */
    public static void modifyValue(int value) {
        value = value * 2;
        System.out.println("   Всередині функції modifyValue: value = " + value);
    }

    /**
     * Функція, яка демонструє передачу об'єкта (масиву) за посиланням
     * @param arr масив для модифікації
     */
    public static void modifyArray(int[] arr) {
        arr[0] = 99;
        System.out.print("   Всередині функції modifyArray: arr = ");
        printArray(arr);
    }

    /**
     * Функція для виведення масиву
     * @param arr масив для виведення
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Функція з варіативною кількістю аргументів (varargs)
     * @param numbers довільна кількість цілих чисел
     * @return сума всіх переданих чисел
     */
    public static int sumVarargs(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}