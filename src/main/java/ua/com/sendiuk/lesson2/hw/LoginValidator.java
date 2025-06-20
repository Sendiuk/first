package ua.com.sendiuk.lesson2.hw;

public class LoginValidator {
    public static void main(String[] args) {
        // Дані користувача
        String username = "alex_user";
        String password = "myPassword123";
        int userAge = 25;

        // Валідація логіну
        boolean isUsernameValid = username.length() >= 5 && username.length() <= 15;

        // Валідація пароля
        boolean isPasswordValid = password.length() >= 8;

        // Валідація віку
        boolean isAgeValid = userAge >= 16 && userAge <= 65;

        // Загальна валідація
        boolean isValidUser = isUsernameValid && isPasswordValid && isAgeValid;

        // Виведення результатів
        System.out.println("=== РЕЗУЛЬТАТИ ВАЛІДАЦІЇ ===");
        System.out.println("Логін: " + username);
        System.out.println("Довжина логіну: " + username.length() + " символів");
        System.out.println("Логін валідний: " + isUsernameValid);

        System.out.println("\nПароль довжиною: " + password.length() + " символів");
        System.out.println("Пароль валідний: " + isPasswordValid);

        System.out.println("\nВік користувача: " + userAge);
        System.out.println("Вік валідний: " + isAgeValid);

        System.out.println("\n=== ПІДСУМОК ===");
        if (isValidUser) {
            System.out.println(" Користувач успішно пройшов валідацію!");
        } else {
            System.out.println(" Валідація не пройдена!");
            if (!isUsernameValid) {
                System.out.println("- Логін повинен бути від 5 до 15 символів");
            }
            if (!isPasswordValid) {
                System.out.println("- Пароль повинен містити принаймні 8 символів");
            }
            if (!isAgeValid) {
                System.out.println("- Вік повинен бути від 16 до 65 років");
            }
        }
    }
}