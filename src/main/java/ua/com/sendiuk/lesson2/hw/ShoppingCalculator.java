package ua.com.sendiuk.lesson2.hw;

import java.util.Scanner;

public class ShoppingCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення даних
        System.out.print("Введіть назву товару: ");
        String productName = scanner.nextLine();

        System.out.print("Введіть ціну товару (грн): ");
        double price = scanner.nextDouble();

        System.out.print("Введіть кількість: ");
        int quantity = scanner.nextInt();

        // Обчислення
        double totalCost = price * quantity;
        double discount = 0.0;
        double finalCost = totalCost;

        // Застосування знижки
        final double DISCOUNT_THRESHOLD = 1000.0;
        final double DISCOUNT_RATE = 0.10; // 10% знижка

        if (totalCost > DISCOUNT_THRESHOLD) {
            discount = totalCost * DISCOUNT_RATE;
            finalCost = totalCost - discount;
        }

        // Виведення чеку
        System.out.println("\n==============================");
        System.out.println("           ЧЕК           ");
        System.out.println("==============================");
        System.out.println("Товар: " + productName);
        System.out.println("Ціна за одиницю: " + price + " грн");
        System.out.println("Кількість: " + quantity + " шт");
        System.out.println("Вартість: " + totalCost + " грн");

        if (discount > 0) {
            System.out.println("Знижка (10%): -" + discount + " грн");
            System.out.println("------------------------------");
        }

        System.out.println("ДО СПЛАТИ: " + finalCost + " грн");
        System.out.println("==============================");

        if (discount > 0) {
            System.out.println("Вітаємо! Ви отримали знижку!");
        }

        scanner.close();
    }
}