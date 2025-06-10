package ua.com.sendiuk.lesson11;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Простий список справ (Todo List)
 *
 * Функції:
 * - Додавання нових завдань
 * - Видалення завдань
 * - Перегляд усіх завдань
 * - Позначення завдань як виконаних
 * - Збереження та завантаження даних з файлу
 *
 * Використовує:
 * - ООП принципи
 * - Роботу з масивами/списками
 * - Обробку винятків
 * - Файлові операції
 */
public class TodoListApp {

    private static final String FILE_NAME = "todolist.dat";
    private static Scanner scanner = new Scanner(System.in);
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        System.out.println("===== ПРОГРАМА СПИСОК СПРАВ =====");

        // Спроба завантажити існуючі дані
        loadData();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();

            try {
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        viewTasks();
                        break;
                    case 3:
                        markTaskAsCompleted();
                        break;
                    case 4:
                        removeTask();
                        break;
                    case 5:
                        saveData();
                        System.out.println("Дані збережено у файл");
                        break;
                    case 0:
                        // Зберігаємо дані перед виходом
                        saveData();
                        running = false;
                        System.out.println("Дякуємо за використання програми!");
                        break;
                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            } catch (TaskException e) {
                System.out.println("Помилка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Сталася несподівана помилка: " + e.getMessage());
            }

            // Затримка перед очищенням екрану і показом меню знову
            System.out.println("\nНатисніть Enter для продовження...");
            scanner.nextLine();
        }

        // Закриваємо сканер
        scanner.close();
    }

    /**
     * Відображає основне меню програми
     */
    private static void displayMenu() {
        System.out.println("\n===== МЕНЮ =====");
        System.out.println("1. Додати нове завдання");
        System.out.println("2. Переглянути всі завдання");
        System.out.println("3. Позначити завдання як виконане");
        System.out.println("4. Видалити завдання");
        System.out.println("5. Зберегти дані");
        System.out.println("0. Вихід");
        System.out.print("Ваш вибір: ");
    }

    /**
     * Отримує вибір користувача з обробкою помилок введення
     */
    private static int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищаємо буфер після введення числа
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Очищаємо буфер, щоб уникнути безкінечного циклу
            return -1; // Повертаємо недійсний вибір
        }
    }

    /**
     * Додає нове завдання у список
     */
    private static void addTask() throws TaskException {
        System.out.println("\n--- ДОДАВАННЯ НОВОГО ЗАВДАННЯ ---");

        System.out.print("Введіть назву завдання: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            throw new TaskException("Назва завдання не може бути порожньою!");
        }

        System.out.print("Введіть опис завдання: ");
        String description = scanner.nextLine().trim();

        System.out.print("Введіть дату виконання (у форматі ДД.ММ.РРРР або залиште порожнім для сьогодні): ");
        String dateStr = scanner.nextLine().trim();

        Date dueDate = null;
        if (!dateStr.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                dateFormat.setLenient(false);
                dueDate = dateFormat.parse(dateStr);
            } catch (Exception e) {
                throw new TaskException("Неправильний формат дати. Використовуйте ДД.ММ.РРРР.");
            }
        } else {
            dueDate = new Date(); // Сьогоднішня дата
        }

        System.out.print("Введіть пріоритет (1-Високий, 2-Середній, 3-Низький): ");
        int priorityInput;
        try {
            priorityInput = Integer.parseInt(scanner.nextLine().trim());
            if (priorityInput < 1 || priorityInput > 3) {
                throw new TaskException("Пріоритет має бути від 1 до 3.");
            }
        } catch (NumberFormatException e) {
            throw new TaskException("Введіть коректне число для пріоритету.");
        }

        Priority priority;
        switch (priorityInput) {
            case 1: priority = Priority.HIGH; break;
            case 2: priority = Priority.MEDIUM; break;
            default: priority = Priority.LOW;
        }

        // Створюємо нове завдання та додаємо його до списку
        Task newTask = new Task(title, description, dueDate, priority);
        todoList.addTask(newTask);

        System.out.println("Завдання успішно додано!");
    }

    /**
     * Відображає всі завдання у списку
     */
    private static void viewTasks() {
        System.out.println("\n--- СПИСОК ВСІХ ЗАВДАНЬ ---");

        List<Task> tasks = todoList.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("Список завдань порожній.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        // Відображаємо завдання у вигляді таблиці
        System.out.println("ID | Статус | Пріоритет | Дата виконання | Назва");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "✓" : " ";
            String dueDate = dateFormat.format(task.getDueDate());

            System.out.printf("%-3d| %-7s| %-10s| %-15s| %s%n",
                    i + 1,
                    status,
                    task.getPriority().toString(),
                    dueDate,
                    task.getTitle());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Всього завдань: " + tasks.size());
    }

    /**
     * Позначає завдання як виконане
     */
    private static void markTaskAsCompleted() throws TaskException {
        System.out.println("\n--- ПОЗНАЧЕННЯ ЗАВДАННЯ ЯК ВИКОНАНЕ ---");

        if (todoList.getAllTasks().isEmpty()) {
            System.out.println("Список завдань порожній.");
            return;
        }

        viewTasks();

        System.out.print("\nВведіть ID завдання для позначення як виконане: ");
        try {
            int taskId = Integer.parseInt(scanner.nextLine().trim());

            // Перевіряємо коректність ID
            if (taskId < 1 || taskId > todoList.getAllTasks().size()) {
                throw new TaskException("Неіснуючий ID завдання.");
            }

            // ID для користувача починається з 1, але в масиві - з 0
            todoList.markTaskAsCompleted(taskId - 1);
            System.out.println("Завдання позначено як виконане!");

        } catch (NumberFormatException e) {
            throw new TaskException("Введіть коректний ID завдання.");
        }
    }

    /**
     * Видаляє завдання зі списку
     */
    private static void removeTask() throws TaskException {
        System.out.println("\n--- ВИДАЛЕННЯ ЗАВДАННЯ ---");

        if (todoList.getAllTasks().isEmpty()) {
            System.out.println("Список завдань порожній.");
            return;
        }

        viewTasks();

        System.out.print("\nВведіть ID завдання для видалення: ");
        try {
            int taskId = Integer.parseInt(scanner.nextLine().trim());

            // Перевіряємо коректність ID
            if (taskId < 1 || taskId > todoList.getAllTasks().size()) {
                throw new TaskException("Неіснуючий ID завдання.");
            }

            // Запитуємо підтвердження
            System.out.print("Ви впевнені, що хочете видалити це завдання? (так/ні): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("так")) {
                // ID для користувача починається з 1, але в масиві - з 0
                todoList.removeTask(taskId - 1);
                System.out.println("Завдання успішно видалено!");
            } else {
                System.out.println("Видалення скасовано.");
            }

        } catch (NumberFormatException e) {
            throw new TaskException("Введіть коректний ID завдання.");
        }
    }

    /**
     * Зберігає дані у файл
     */
    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FILE_NAME))) {

            oos.writeObject(todoList);

        } catch (IOException e) {
            System.out.println("Помилка при збереженні даних: " + e.getMessage());
        }
    }

    /**
     * Завантажує дані з файлу
     */
    private static void loadData() {
        // Перевіряємо, чи існує файл
        if (!Files.exists(Paths.get(FILE_NAME))) {
            System.out.println("Файл даних не знайдено. Створюємо новий список завдань.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FILE_NAME))) {

            // Зчитуємо об'єкт зі списком завдань
            todoList = (TodoList) ois.readObject();
            System.out.println("Дані успішно завантажено з файлу.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при завантаженні даних: " + e.getMessage());
            System.out.println("Створюємо новий список завдань.");
            todoList = new TodoList();
        }
    }
}

/**
 * Клас, що представляє список справ
 */
class TodoList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Додає нове завдання до списку
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Видаляє завдання за індексом
     */
    public void removeTask(int index) throws TaskException {
        if (index < 0 || index >= tasks.size()) {
            throw new TaskException("Недійсний індекс завдання.");
        }
        tasks.remove(index);
    }

    /**
     * Позначає завдання як виконане
     */
    public void markTaskAsCompleted(int index) throws TaskException {
        if (index < 0 || index >= tasks.size()) {
            throw new TaskException("Недійсний індекс завдання.");
        }
        tasks.get(index).setCompleted(true);
    }

    /**
     * Повертає список всіх завдань
     */
    public List<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Повертає кількість завдань у списку
     */
    public int getTaskCount() {
        return tasks.size();
    }
}

/**
 * Клас, що представляє окреме завдання
 */
class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private Date dueDate;
    private boolean completed;
    private Priority priority;

    public Task(String title, String description, Date dueDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
        this.priority = priority;
    }

    // Геттери і сеттери
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}

/**
 * Перелік для пріоритетів завдань
 */
enum Priority {
    HIGH("Високий"),
    MEDIUM("Середній"),
    LOW("Низький");

    private final String displayName;

    Priority(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

/**
 * Спеціальний клас виключення для завдань
 */
class TaskException extends Exception {
    public TaskException(String message) {
        super(message);
    }
}