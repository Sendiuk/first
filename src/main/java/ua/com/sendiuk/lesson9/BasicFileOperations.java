package ua.com.sendiuk.lesson9;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Демонстрація базових операцій з файлами в Java
 * використовуючи java.io та java.nio пакети
 */
public class BasicFileOperations {

    public static void main(String[] args) {
        // Визначаємо імена файлів для прикладів
        String ioTextFile = "example_io.txt";
        String nioTextFile = "example_nio.txt";

        System.out.println("==== Демонстрація базових операцій з файлами ====\n");

        // ---------- JAVA.IO ПРИКЛАДИ ----------
        System.out.println("--- java.io приклади ---");

        // Запис у файл використовуючи java.io
        writeUsingIO(ioTextFile, "Це текст, записаний з java.io.\nЦе другий рядок.");

        // Читання з файлу використовуючи java.io
        System.out.println("\nЧитаємо файл використовуючи java.io:");
        readUsingIO(ioTextFile);

        // Додавання тексту до існуючого файлу
        appendUsingIO(ioTextFile, "\nЦей рядок був доданий до файлу.");
        System.out.println("\nПісля додавання тексту (java.io):");
        readUsingIO(ioTextFile);

        // ---------- JAVA.NIO ПРИКЛАДИ ----------
        System.out.println("\n--- java.nio приклади ---");

        // Запис у файл використовуючи java.nio
        writeUsingNIO(nioTextFile, "Це текст, записаний з java.nio.\nЦе другий рядок.");

        // Читання з файлу використовуючи java.nio
        System.out.println("\nЧитаємо файл використовуючи java.nio:");
        readUsingNIO(nioTextFile);

        // Додавання тексту до існуючого файлу через java.nio
        appendUsingNIO(nioTextFile, "\nЦей рядок був доданий до файлу через nio.");
        System.out.println("\nПісля додавання тексту (java.nio):");
        readUsingNIO(nioTextFile);

        // Інші корисні операції
        System.out.println("\n--- Інші корисні операції з файлами ---");

        // Перевірка чи існує файл
        checkFileExists(ioTextFile);

        // Копіювання файлу
        copyFile(ioTextFile, "copied_file.txt");

        // Перейменування файлу
        renameFile(nioTextFile, "renamed_file.txt");

        // Отримання інформації про файл
        getFileInfo("copied_file.txt");
    }

    /**
     * Запис у файл використовуючи java.io (FileWriter)
     */
    private static void writeUsingIO(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // FileWriter дозволяє записувати символи у файл
            writer.write(content);
            System.out.println("Успішно записано у файл '" + fileName + "' використовуючи java.io");
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    /**
     * Читання з файлу використовуючи java.io (BufferedReader)
     */
    private static void readUsingIO(String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {

            // BufferedReader дозволяє ефективно читати текст рядок за рядком
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    /**
     * Додавання тексту до існуючого файлу використовуючи java.io
     */
    private static void appendUsingIO(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            // Параметр 'true' вказує на режим додавання (append)
            writer.write(content);
            System.out.println("Успішно додано текст до файлу '" + fileName + "' використовуючи java.io");
        } catch (IOException e) {
            System.out.println("Помилка при додаванні тексту до файлу: " + e.getMessage());
        }
    }

    /**
     * Запис у файл використовуючи java.nio (Files)
     */
    private static void writeUsingNIO(String fileName, String content) {
        try {
            // Files.write() - зручний метод для запису вмісту у файл
            Files.write(Paths.get(fileName), content.getBytes(StandardCharsets.UTF_8));
            System.out.println("Успішно записано у файл '" + fileName + "' використовуючи java.nio");
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    /**
     * Читання з файлу використовуючи java.nio (Files)
     */
    private static void readUsingNIO(String fileName) {
        try {
            // Files.readAllLines() читає всі рядки файлу в список
            List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println(line);
            }

            // Альтернативний варіант - читання усього файлу як одного рядка
            // String content = Files.readString(Paths.get(fileName));
            // System.out.println(content);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    /**
     * Додавання тексту до існуючого файлу використовуючи java.nio
     */
    private static void appendUsingNIO(String fileName, String content) {
        try {
            // StandardOpenOption.APPEND дозволяє додавати вміст до існуючого файлу
            Files.write(Paths.get(fileName), content.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
            System.out.println("Успішно додано текст до файлу '" + fileName + "' використовуючи java.nio");
        } catch (IOException e) {
            System.out.println("Помилка при додаванні тексту до файлу: " + e.getMessage());
        }
    }

    /**
     * Перевірка існування файлу
     */
    private static void checkFileExists(String fileName) {
        // Метод 1: використання java.io.File
        File file = new File(fileName);
        boolean existsIO = file.exists();

        // Метод 2: використання java.nio.Files
        boolean existsNIO = Files.exists(Paths.get(fileName));

        System.out.println("Файл '" + fileName + "' існує? " + existsNIO);
    }

    /**
     * Копіювання файлу використовуючи java.nio
     */
    private static void copyFile(String source, String destination) {
        try {
            Files.copy(Paths.get(source), Paths.get(destination),
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл '" + source + "' успішно скопійовано у '" + destination + "'");
        } catch (IOException e) {
            System.out.println("Помилка при копіюванні файлу: " + e.getMessage());
        }
    }

    /**
     * Перейменування файлу використовуючи java.nio
     */
    private static void renameFile(String oldName, String newName) {
        try {
            Files.move(Paths.get(oldName), Paths.get(newName),
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл '" + oldName + "' успішно перейменовано на '" + newName + "'");
        } catch (IOException e) {
            System.out.println("Помилка при перейменуванні файлу: " + e.getMessage());
        }
    }

    /**
     * Отримання інформації про файл
     */
    private static void getFileInfo(String fileName) {
        try {
            Path path = Paths.get(fileName);

            // Отримання базових відомостей про файл
            System.out.println("Інформація про файл '" + fileName + "':");
            System.out.println("Повний шлях: " + path.toAbsolutePath());
            System.out.println("Розмір: " + Files.size(path) + " байтів");
            System.out.println("Останні зміни: " + Files.getLastModifiedTime(path));
            System.out.println("Чи можна читати? " + Files.isReadable(path));
            System.out.println("Чи можна записувати? " + Files.isWritable(path));
        } catch (IOException e) {
            System.out.println("Помилка при отриманні інформації про файл: " + e.getMessage());
        }
    }
}