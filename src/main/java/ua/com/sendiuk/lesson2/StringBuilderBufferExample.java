package ua.com.sendiuk.lesson2;

public class StringBuilderBufferExample {

    public static void main(String[] args) {
        // Приклад використання StringBuilder (НЕ синхронізований, швидкий)
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" World!");
        System.out.println("StringBuilder результат: " + sb.toString());

        // Приклад використання StringBuffer (Синхронізований, потокобезпечний)
        StringBuffer sbf = new StringBuffer();
        sbf.append("Hello");
        sbf.append(" World!");
        System.out.println("StringBuffer результат: " + sbf.toString());

        // Демонстрація різниці в швидкості (String vs StringBuilder)
        int iterations = 100_000;

        // Звичайний String (кожне об'єднання створює новий об'єкт)
        long startString = System.nanoTime();
        String text = "";
        for (int i = 0; i < iterations; i++) {
            text += "a"; // text + "a" Кожен раз новий об'єкт!
        }
        long endString = System.nanoTime();
        System.out.println("Час для String: " + (endString - startString) / 1_000_000 + " мс");

        // StringBuilder (ефективне об'єднання без створення нових об'єктів)
        long startBuilder = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append("a");
        }
        long endBuilder = System.nanoTime();
        System.out.println("Час для StringBuilder: " + (endBuilder - startBuilder) / 1_000_000 + " мс");

        // Коротко про різницю:
        System.out.println("Пояснення:");
        System.out.println("String - immutable (створюється новий об'єкт при кожній зміні).");
        System.out.println("StringBuilder - mutable (змінює той самий об'єкт без створення нового).");
        System.out.println("StringBuffer - як StringBuilder, але потокобезпечний (синхронізований).");
    }
}
