package ua.com.sendiuk.lesson2;

import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {
        // Масив зберігає фіксовану кількість елементів в послідовній області пам'яті

        // Оголошення та ініціалізація масивів

        // Спосіб 1: оголошення + ініціалізація
        int[] numbers1 = {10, 20, 30, 40, 50};
        System.out.println("numbers1: " + Arrays.toString(numbers1));

        // Спосіб 2: оголошення + розмір + заповнення
        double[] prices = new double[3];
        prices[0] = 12.99;
        prices[1] = 24.50;
        prices[2] = 9.75;
        System.out.println("prices: " + Arrays.toString(prices));

        // Спосіб 3: оголошення + ініціалізація через new
        String[] names = new String[] {"Анна", "Іван", "Марія"};
        System.out.println("names: " + Arrays.toString(names) + "\n");

        // Доступ до елементів масиву

        numbers1[2] = 35;
        System.out.println("Змінений numbers1: " + Arrays.toString(numbers1) + "\n");

        // Властивості масиву

        System.out.println("Довжина масиву numbers1: " + numbers1.length);
        System.out.println("Довжина масиву names: " + names.length + "\n");

        // Багатовимірні масиви

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Матриця 3x3:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Елемент [1][2]: " + matrix[1][2] + "\n");

        // Копіювання масивів

        int[] numbersCopy = Arrays.copyOf(numbers1, numbers1.length);
        System.out.println("Копія numbers1: " + Arrays.toString(numbersCopy));

        // Зміна копії не впливає на оригінал
        numbersCopy[0] = 100;
        System.out.println("Оригінал numbers1: " + Arrays.toString(numbers1));
        System.out.println("Змінена копія numbersCopy: " + Arrays.toString(numbersCopy));
    }
}
