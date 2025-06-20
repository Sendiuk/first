package ua.com.sendiuk.lesson2.hw;

public class AgeCalculator {
    public static void main(String[] args) {
        // Змінні
        int currentYear = 2025;
        int birthYear = 1995;
        boolean birthdayPassed = true; // чи минув день народження цього року

        // Обчислення віку
        int age = currentYear - birthYear;

        // Використання декременту, якщо день народження ще не минув
        if (!birthdayPassed) {
            age--; // або --age
        }

        // Додаткові операції
        int ageNextYear = age;
        ageNextYear++; // постфіксний інкремент

        System.out.println("Поточний вік: " + age);
        System.out.println("Вік наступного року: " + ageNextYear);
        System.out.println("Різниця років: " + (currentYear - birthYear));
    }
}