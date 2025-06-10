package ua.com.sendiuk.lesson8;

/**
 * Приклад обробки винятків (Exceptions) в Java
 * - Що таке виняток і навіщо їх обробляти
 * - Блоки try-catch-finally
 * - Власні винятки
 */
public class ExceptionsHandling {
    public static void main(String[] args) {
        System.out.println("===== ОБРОБКА ВИНЯТКІВ (EXCEPTIONS) =====");

        // Розуміння винятків
        System.out.println("\n=== Що таке виняток і навіщо їх обробляти ===");
        understandingExceptions();

        // Блоки try-catch-finally
        System.out.println("\n=== Блоки try-catch-finally ===");
        tryCatchFinallyBlocks();

        // Різні типи винятків
        System.out.println("\n=== Різні типи винятків ===");
        differentExceptionTypes();

        // Власні винятки
        System.out.println("\n=== Власні винятки ===");
        customExceptions();

        // Багаторівнева обробка винятків
        System.out.println("\n=== Багаторівнева обробка винятків ===");
        multiLevelExceptionHandling();
    }

    /**
     * Що таке виняток і навіщо їх обробляти
     */
    private static void understandingExceptions() {
        System.out.println("Виняток (Exception) - це подія, яка виникає під час виконання програми");
        System.out.println("і порушує нормальний потік інструкцій.");

        System.out.println("\nПереваги обробки винятків:");
        System.out.println("1. Запобігає аварійному завершенню програми");
        System.out.println("2. Дозволяє відокремити код обробки помилок від основного коду");
        System.out.println("3. Допомагає ідентифікувати помилки та їх причини");
        System.out.println("4. Сприяє створенню стійких та надійних програм");

        System.out.println("\nПриклад винятку без обробки:");
        // Закоментовано, щоб програма не завершилася аварійно
        // int result = 10 / 0; // Викликає ArithmeticException

        System.out.println("Основні типи винятків в Java:");
        System.out.println("1. Checked Exceptions - перевіряються компілятором (IOException, SQLException)");
        System.out.println("2. Unchecked Exceptions - не перевіряються компілятором (RuntimeException)");
        System.out.println("3. Errors - критичні проблеми, які зазвичай не обробляються (OutOfMemoryError)");
    }

    /**
     * Блоки try-catch-finally
     */
    private static void tryCatchFinallyBlocks() {
        System.out.println("Приклад блоку try-catch:");

        try {
            // Код, який може викликати виняток
            int result = 10 / 2; // Змініть на 0 для виникнення винятку
            System.out.println("Результат ділення: " + result);

            String text = "Hello";
            System.out.println("Символ з індексом 1: " + text.charAt(1));
            // Змініть індекс на 10 для виникнення StringIndexOutOfBoundsException

        } catch (ArithmeticException e) {
            // Код, який виконується при виникненні арифметичного винятку
            System.out.println("Помилка арифметичної операції: " + e.getMessage());
        } catch (StringIndexOutOfBoundsException e) {
            // Код, який виконується при виникненні винятку індексу рядка
            System.out.println("Помилка індексу рядка: " + e.getMessage());
        }

        System.out.println("\nПриклад блоку try-catch-finally:");
        try {
            // Код, який може викликати виняток
            int[] numbers = {1, 2, 3};
            System.out.println("Перший елемент масиву: " + numbers[0]);
            // Змініть індекс на 5 для виникнення ArrayIndexOutOfBoundsException

        } catch (ArrayIndexOutOfBoundsException e) {
            // Код, який виконується при виникненні винятку індексу масиву
            System.out.println("Помилка індексу масиву: " + e.getMessage());
        } finally {
            // Код, який виконується завжди, незалежно від того, чи виник виняток
            System.out.println("Блок finally завжди виконується!");
        }

        System.out.println("\nПриклад блоку try-with-resources (Java 7+):");
        try (java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.StringReader("Текст для прикладу"))) {
            String line = reader.readLine();
            System.out.println("Прочитаний рядок: " + line);
            // Ресурс reader буде автоматично закрито після виконання блоку try
        } catch (java.io.IOException e) {
            System.out.println("Помилка введення-виведення: " + e.getMessage());
        }
    }

    /**
     * Різні типи винятків
     */
    private static void differentExceptionTypes() {
        // Приклади різних типів винятків
        System.out.println("Приклади різних типів винятків:");

        try {
            // Перевірка на помилки різних типів
            checkForErrors(2); // Змініть параметр для тестування різних винятків
        } catch (ArithmeticException e) {
            System.out.println("Арифметична помилка: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Помилка нульового вказівника: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Помилка індексу масиву: " + e.getMessage());
        } catch (Exception e) {
            // Загальний обробник для всіх інших винятків
            System.out.println("Інша помилка: " + e.getMessage());
            // Виведення стеку викликів для відладки
            e.printStackTrace();
        }

        // Обробка винятків за допомогою об'єднаного catch (Java 7+)
        System.out.println("\nОб'єднаний catch (Java 7+):");
        try {
            checkForErrors(3); // Змініть параметр для тестування різних винятків
        } catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Виявлена одна з очікуваних помилок: " + e.getMessage());
        }
    }

    /**
     * Метод для тестування різних винятків
     */
    private static void checkForErrors(int errorType) {
        switch (errorType) {
            case 1:
                // Викликає ArithmeticException
                int result = 10 / 0;
                break;
            case 2:
                // Викликає NullPointerException
                String text = null;
                text.length();
                break;
            case 3:
                // Викликає ArrayIndexOutOfBoundsException
                int[] numbers = {1, 2, 3};
                System.out.println(numbers[10]);
                break;
            case 4:
                // Викликає власний виняток
                throw new IllegalArgumentException("Недійсний аргумент");
            default:
                System.out.println("Без помилок");
        }
    }

    /**
     * Власні винятки
     */
    private static void customExceptions() {
        try {
            // Приклад використання власного винятку
            checkAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Помилка віку: " + e.getMessage());
        }

        try {
            // Ще один приклад
            BankAccount account = new BankAccount(1000);
            account.withdraw(1500);
        } catch (InsufficientFundsException e) {
            System.out.println("Помилка банківської операції: " + e.getMessage());
            System.out.println("Не вистачає: " + e.getAmount() + " грн.");
        }
    }

    /**
     * Перевірка віку з власним винятком
     */
    private static void checkAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Вік не може бути від'ємним");
        } else if (age > 120) {
            throw new InvalidAgeException("Вік занадто великий");
        }
        System.out.println("Вік прийнятний: " + age);
    }

    /**
     * Багаторівнева обробка винятків
     */
    private static void multiLevelExceptionHandling() {
        try {
            // Метод, який передає виняток нагору
            methodA();
        } catch (Exception e) {
            System.out.println("Виняток спійманий у main: " + e.getMessage());
        }
    }

    private static void methodA() throws Exception {
        try {
            methodB();
        } catch (ArithmeticException e) {
            System.out.println("Виняток спійманий у methodA: " + e.getMessage());
        }
        // Інші винятки будуть передані нагору
        methodC();
    }

    private static void methodB() {
        int result = 10 / 0; // ArithmeticException
    }

    private static void methodC() throws Exception {
        throw new Exception("Виняток з methodC");
    }
}

/**
 * Власний клас винятку для перевірки віку
 */
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

/**
 * Власний клас винятку для банківських операцій
 */
class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(String message, double amount) {
        super(message);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

/**
 * Клас банківського рахунку для демонстрації власних винятків
 */
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума поповнення має бути більше нуля");
        }
        balance += amount;
        System.out.println("Поповнено на " + amount + " грн. Поточний баланс: " + balance + " грн.");
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума зняття має бути більше нуля");
        }

        if (amount > balance) {
            double shortfall = amount - balance;
            throw new InsufficientFundsException("Недостатньо коштів на рахунку", shortfall);
        }

        balance -= amount;
        System.out.println("Знято " + amount + " грн. Поточний баланс: " + balance + " грн.");
    }

    public double getBalance() {
        return balance;
    }
}