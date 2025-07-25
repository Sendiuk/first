package ua.com.sendiuk.lesson7;

import java.util.*;

public class ListPerformanceTest {

    private static final int ELEMENTS = 100_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("==== Додавання в кінець ====");
        measureAddToEnd(arrayList, "ArrayList");
        measureAddToEnd(linkedList, "LinkedList");

        System.out.println("\n==== Додавання на початок ====");
        measureAddToStart(arrayList, "ArrayList");
        measureAddToStart(linkedList, "LinkedList");

        System.out.println("\n==== Додавання в середину ====");
        measureAddToMiddle(arrayList, "ArrayList");
        measureAddToMiddle(linkedList, "LinkedList");

        System.out.println("\n==== Отримання елементів за індексом ====");
        measureRandomAccess(arrayList, "ArrayList");
        measureRandomAccess(linkedList, "LinkedList");

        System.out.println("\n==== Видалення з початку ====");
        measureRemoveFromStart(new ArrayList<>(arrayList), "ArrayList");
        measureRemoveFromStart(new LinkedList<>(linkedList), "LinkedList");

        System.out.println("\n==== Видалення з середини ====");
        measureRemoveFromMiddle(new ArrayList<>(arrayList), "ArrayList");
        measureRemoveFromMiddle(new LinkedList<>(linkedList), "LinkedList");

        System.out.println("\n==== Видалення з кінця ====");
        measureRemoveFromEnd(new ArrayList<>(arrayList), "ArrayList");
        measureRemoveFromEnd(new LinkedList<>(linkedList), "LinkedList");
    }

    private static void measureAddToEnd(List<Integer> list, String name) {
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        printTime(name, end - start);
    }

    private static void measureAddToStart(List<Integer> list, String name) {
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(0, i);
        }
        long end = System.nanoTime();
        printTime(name, end - start);
    }

    private static void measureAddToMiddle(List<Integer> list, String name) {
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(list.size() / 2, i);
        }
        long end = System.nanoTime();
        printTime(name, end - start);
    }

    private static void measureRandomAccess(List<Integer> list, String name) {
        int sum = 0;
        long start = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            int index = (int) (Math.random() * ELEMENTS);
            sum += list.get(index);
        }
        long end = System.nanoTime();
        printTime(name, end - start);
    }

    private static void measureRemoveFromStart(List<Integer> list, String name) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            list.remove(0);
        }
        long end = System.nanoTime();
        printTime(name, end - start);
    }

    private static void measureRemoveFromMiddle(List<Integer> list, String name) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            list.remove(list.size() / 2);
        }
        long end = System.nanoTime();
        printTime(name, end - start);
    }

    private static void measureRemoveFromEnd(List<Integer> list, String name) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
        long end = System.nanoTime();
        printTime(name, end - start);
    }

    private static void printTime(String name, long nanoTime) {
        System.out.printf("%-12s: %8.2f мс%n", name, nanoTime / 1_000_000.0);
    }
}
