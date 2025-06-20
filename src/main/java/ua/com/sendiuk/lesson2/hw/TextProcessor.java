package ua.com.sendiuk.lesson2.hw;

public class TextProcessor {
    public static void main(String[] args) {
        String firstName = "  Олександр  ";
        String lastName = "  Іваненко  ";

        // Очищення від пробілів
        firstName = firstName.trim();
        lastName = lastName.trim();

        // Форматування
        String fullNameUpper = (firstName + " " + lastName).toUpperCase();
        String fullNameLower = (firstName + " " + lastName).toLowerCase();

        // Перевірка довжини
        String fullName = firstName + " " + lastName;
        int nameLength = fullName.length();

        // Створення email за допомогою StringBuilder
        StringBuilder emailBuilder = new StringBuilder();
        emailBuilder.append(firstName.toLowerCase());
        emailBuilder.append(".");
        emailBuilder.append(lastName.toLowerCase());
        emailBuilder.append("@example.com");

        // Виведення результатів
        System.out.println("Повне ім'я (верхній регістр): " + fullNameUpper);
        System.out.println("Повне ім'я (нижній регістр): " + fullNameLower);
        System.out.println("Довжина імені: " + nameLength + " символів");
        System.out.println("Email: " + emailBuilder.toString());

        // Перевірки
        System.out.println("Ім'я починається з 'О': " + firstName.startsWith("О"));
        System.out.println("Прізвище містить 'енко': " + lastName.contains("енко"));
    }
}