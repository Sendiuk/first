package ua.com.sendiuk.lesson7;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Приклад роботи з масивами та колекціями в Java
 * - Одновимірні масиви
 * - Двовимірні масиви
 * - Collection Framework: ArrayList, LinkedList
 * - HashMap та інші колекції
 */
public class ArraysAndCollections {
    public static void main(String[] args) {
        System.out.println("===== ОДНОВИМІРНІ МАСИВИ =====");
        workWithOneDimArrays();

        System.out.println("\n===== ДВОВИМІРНІ МАСИВИ =====");
        workWithTwoDimArrays();

        System.out.println("\n===== Collection Framework =====");
        System.out.println("--- ArrayList і LinkedList ---");
        workWithLists();

        System.out.println("\n--- HashSet ---");
        workWithHashSet();

        System.out.println("\n--- HashMap ---");
        workWithHashMap();

        System.out.println("\n--- TreeMap ---");
        workWithTreeMap();

        System.out.println("\n--- Інтерфейси колекцій ---");
        collectionInterfaces();
    }

    /**
     * Робота з одновимірними масивами
     */
    private static void workWithOneDimArrays() {
        // Створення масиву із вказаним розміром
        int[] numbers = new int[5];

        // Заповнення масиву значеннями
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 10;
        }

        // Виведення елементів масиву
        System.out.println("Елементи масиву чисел:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // Створення та ініціалізація масиву одним рядком
        String[] fruits = {"Яблуко", "Банан", "Апельсин", "Груша", "Ківі"};

        // Виведення за допомогою for-each циклу
        System.out.println("\nСписок фруктів:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }

        // Зміна елемента масиву
        fruits[2] = "Мандарин";
        System.out.println("\nТретій фрукт після зміни: " + fruits[2]);

        // Копіювання масиву
        String[] fruitsCopy = new String[fruits.length];
        System.arraycopy(fruits, 0, fruitsCopy, 0, fruits.length);
        System.out.println("\nКопія масиву фруктів:");
        for (String fruit : fruitsCopy) {
            System.out.println("- " + fruit);
        }
    }

    /**
     * Робота з двовимірними масивами
     */
    private static void workWithTwoDimArrays() {
        // Створення двовимірного масиву
        int[][] matrix = new int[3][4];

        // Заповнення масиву значеннями
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i * 10 + j;
            }
        }

        // Виведення двовимірного масиву
        System.out.println("Матриця розміром " + matrix.length + "x" + matrix[0].length + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Створення та ініціалізація двовимірного масиву одним рядком
        int[][] smallMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Знаходження суми елементів
        int sum = 0;
        for (int[] row : smallMatrix) {
            for (int element : row) {
                sum += element;
            }
        }
        System.out.println("\nСума всіх елементів матриці: " + sum);

        // Приклад масиву з різними розмірами рядків (зубчатий масив)
        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[2];
        jaggedArray[1] = new int[4];
        jaggedArray[2] = new int[3];

        // Заповнення зубчастого масиву
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = i + j;
            }
        }

        // Виведення зубчастого масиву
        System.out.println("\nЗубчастий масив:");
        for (int[] row : jaggedArray) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    /**
     * Робота з колекціями ArrayList і LinkedList
     */
    private static void workWithLists() {
        // Імпорти, які потрібні для колекцій
        // import java.util.ArrayList;
        // import java.util.LinkedList;
        // import java.util.List;

        // Створення ArrayList
        ArrayList<String> arrayList = new ArrayList<>();

        // Додавання елементів
        arrayList.add("Перший");
        arrayList.add("Другий");
        arrayList.add("Третій");

        System.out.println("Вміст ArrayList:");
        for (String item : arrayList) {
            System.out.println("- " + item);
        }

        // Отримання елемента за індексом
        System.out.println("\nДругий елемент: " + arrayList.get(1));

        // Зміна елемента
        arrayList.set(1, "Новий другий");
        System.out.println("Після зміни: " + arrayList.get(1));

        // Видалення елемента
        arrayList.remove(0);
        System.out.println("\nПісля видалення першого елемента, розмір: " + arrayList.size());

        // Перевірка наявності елемента
        boolean contains = arrayList.contains("Третій");
        System.out.println("Чи містить 'Третій': " + contains);

        // Створення LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Додавання елементів
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        System.out.println("\nВміст LinkedList:");
        for (Integer number : linkedList) {
            System.out.println("- " + number);
        }

        // Особливості LinkedList - додавання на початок і кінець
        linkedList.addFirst(5);
        linkedList.addLast(40);

        System.out.println("\nПісля додавання на початок і кінець:");
        System.out.println(linkedList);

        // Основні відмінності між ArrayList і LinkedList
        System.out.println("\nОсновні відмінності між ArrayList і LinkedList:");
        System.out.println("- ArrayList: швидкий доступ за індексом, повільне вставлення/видалення");
        System.out.println("- LinkedList: повільний доступ за індексом, швидке вставлення/видалення");
    }

    /**
     * Робота з HashSet
     */
    private static void workWithHashSet() {
        // Імпорт, який потрібен для HashSet
        // import java.util.HashSet;

        // Створення HashSet
        java.util.HashSet<String> uniqueNames = new java.util.HashSet<>();

        // Додавання елементів
        uniqueNames.add("Іван");
        uniqueNames.add("Марія");
        uniqueNames.add("Петро");
        uniqueNames.add("Іван");  // Дублікат не буде додано

        System.out.println("Унікальні імена в HashSet:");
        for (String name : uniqueNames) {
            System.out.println("- " + name);
        }

        System.out.println("\nРозмір HashSet: " + uniqueNames.size());

        // Перевірка наявності елемента
        boolean hasName = uniqueNames.contains("Марія");
        System.out.println("Чи містить 'Марія': " + hasName);

        // Видалення елемента
        uniqueNames.remove("Петро");
        System.out.println("\nПісля видалення 'Петро', розмір: " + uniqueNames.size());
    }

    /**
     * Робота з HashMap
     */
    private static void workWithHashMap() {
        // Імпорт, який потрібен для HashMap
        // import java.util.HashMap;

        // Створення HashMap (ключ - рядок, значення - ціле число)
        java.util.HashMap<String, Integer> prices = new java.util.HashMap<>();

        // Додавання пар ключ-значення
        prices.put("Яблуко", 50);
        prices.put("Банан", 70);
        prices.put("Апельсин", 85);
        prices.put("Груша", 120);

        // Виведення вмісту HashMap
        System.out.println("Ціни на фрукти:");
        for (String fruit : prices.keySet()) {
            System.out.println(fruit + ": " + prices.get(fruit) + " грн.");
        }

        // Перевірка наявності ключа
        String searchFruit = "Банан";
        if (prices.containsKey(searchFruit)) {
            System.out.println("\nЦіна на " + searchFruit + ": " + prices.get(searchFruit) + " грн.");
        } else {
            System.out.println("\n" + searchFruit + " відсутній у списку.");
        }

        // Зміна значення
        prices.put("Яблуко", 55);
        System.out.println("\nНова ціна на яблука: " + prices.get("Яблуко") + " грн.");

        // Видалення пари ключ-значення
        prices.remove("Груша");
        System.out.println("\nПісля видалення груші, розмір: " + prices.size());

        // Перевірка наявності значення
        if (prices.containsValue(85)) {
            System.out.println("У магазині є фрукти за 85 грн.");
        }

        // Отримання всіх значень
        System.out.println("\nВсі ціни:");
        for (Integer price : prices.values()) {
            System.out.println("- " + price + " грн.");
        }
    }

    /**
     * Робота з TreeMap
     */
    private static void workWithTreeMap() {
        // Імпорт, який потрібен для TreeMap
        // import java.util.TreeMap;

        // Створення TreeMap (сортування за ключем)
        java.util.TreeMap<String, Integer> studentGrades = new java.util.TreeMap<>();

        // Додавання елементів
        studentGrades.put("Петренко", 85);
        studentGrades.put("Іваненко", 92);
        studentGrades.put("Сидоренко", 78);
        studentGrades.put("Бондаренко", 90);

        // Виведення елементів (автоматично відсортовані за ключем)
        System.out.println("Оцінки студентів (в алфавітному порядку):");
        for (java.util.Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " балів");
        }

        // Отримання першого і останнього ключа
        System.out.println("\nПерший студент: " + studentGrades.firstKey());
        System.out.println("Останній студент: " + studentGrades.lastKey());

        // Отримання частини мапи
        java.util.SortedMap<String, Integer> part = studentGrades.subMap("А", "С");
        System.out.println("\nСтуденти від А до С:");
        for (String student : part.keySet()) {
            System.out.println(student + ": " + part.get(student) + " балів");
        }
    }

    /**
     * Інтерфейси колекцій
     */
    private static void collectionInterfaces() {
        System.out.println("Основні інтерфейси Collection Framework:");

        System.out.println("\n1. Collection - базовий інтерфейс для всіх колекцій");
        System.out.println("   Методи: add, remove, contains, size, isEmpty, clear");

        System.out.println("\n2. List - інтерфейс для упорядкованих колекцій");
        System.out.println("   Реалізації: ArrayList, LinkedList, Vector, Stack");
        System.out.println("   Особливості: допускає дублікати, елементи мають індекси");

        System.out.println("\n3. Set - інтерфейс для колекцій унікальних елементів");
        System.out.println("   Реалізації: HashSet, LinkedHashSet, TreeSet");
        System.out.println("   Особливості: без дублікатів, без індексів");

        System.out.println("\n4. Map - інтерфейс для колекцій пар ключ-значення");
        System.out.println("   Реалізації: HashMap, LinkedHashMap, TreeMap, Hashtable");
        System.out.println("   Особливості: ключі унікальні, значення можуть повторюватись");

        System.out.println("\n5. Queue - інтерфейс для черг");
        System.out.println("   Реалізації: LinkedList, PriorityQueue");
        System.out.println("   Особливості: обробка елементів за принципом FIFO");

        System.out.println("\n6. Deque - інтерфейс для двобічних черг");
        System.out.println("   Реалізації: ArrayDeque, LinkedList");
        System.out.println("   Особливості: додавання/видалення з обох кінців");
    }
}