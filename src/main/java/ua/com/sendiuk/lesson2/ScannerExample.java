package ua.com.sendiuk.lesson2;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        // Створення об'єкта Scanner
        Scanner scanner = new Scanner(System.in);

        // Введення тексту (рядка)
        System.out.print("Введіть ваше ім'я: ");
        String name = scanner.nextLine();

        // Введення цілого числа
        System.out.print("Введіть ваш вік: ");
        int age = scanner.nextInt();

        // Введення дробового числа
        System.out.print("Введіть вашу вагу (кг): ");
        double weight = scanner.nextDouble();

        // Введення логічного значення
        System.out.print("Ви студент? (true/false): ");
        boolean isStudent = scanner.nextBoolean();

        scanner.nextLine(); // Очистка буфера після nextBoolean()

        // Виведення введених даних
        System.out.println("\nВиведення введених даних:");
        System.out.println("Ім'я: " + name);
        System.out.println("Вік: " + age);
        System.out.println("Вага: " + weight + " кг");
        System.out.println("Студент: " + isStudent);

        // Перевірка наявності даних
         System.out.println("\nПеревірка наявності даних:");
        System.out.print("Введіть будь-яке число або текст: ");

        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println("Ви ввели ціле число: " + number);
        } else if (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            System.out.println("Ви ввели дробове число: " + number);
        } else {
            String text = scanner.next();
            System.out.println("Ви ввели текст: " + text);
        }

        // Закриття Scanner
        scanner.close();
        System.out.println("\nScanner закрито. Програма завершена.");
    }
}
