package ua.com.sendiuk.lesson2.hw;

public class StudentGrades {
    public static void main(String[] args) {
        // Масив оцінок
        double[] grades = {85.5, 92.0, 78.5, 96.0, 88.5, 91.0};

        // Обчислення середньої оцінки
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        double average = sum / grades.length;

        // Пошук найвищої та найнижчої оцінок
        double highest = grades[0];
        double lowest = grades[0];

        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }

        // Перевірка оцінок вище порогу
        double threshold = 90.0;
        int countAboveThreshold = 0;

        for (double grade : grades) {
            if (grade >= threshold) {
                countAboveThreshold++;
            }
        }

        // Виведення результатів
        System.out.println("Всі оцінки:");
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Оцінка " + (i + 1) + ": " + grades[i]);
        }

        System.out.println("\nСередня оцінка: " + average);
        System.out.println("Найвища оцінка: " + highest);
        System.out.println("Найнижча оцінка: " + lowest);
        System.out.println("Кількість оцінок вище " + threshold + ": " + countAboveThreshold);
    }
}