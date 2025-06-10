package ua.com.sendiuk.lesson10;

/**
 * Основи багатопоточності в Java
 * - Створення потоків
 * - Два способи реалізації потоків: успадкування Thread та імплементація Runnable
 * - Синхронізація потоків
 */
public class MultithreadingBasics {

    public static void main(String[] args) {
        System.out.println("===== ОСНОВИ БАГАТОПОТОЧНОСТІ В JAVA =====");

        // Інформація про головний потік
        Thread mainThread = Thread.currentThread();
        System.out.println("Головний потік: " + mainThread.getName() +
                " (пріоритет: " + mainThread.getPriority() + ")");

        // ========== 1. СТВОРЕННЯ ПОТОКІВ ==========
        System.out.println("\n----- 1. Створення та запуск потоків -----");

        // Спосіб 1: Успадкування класу Thread
        System.out.println("\n1.1. Через успадкування класу Thread:");
        MyThread thread1 = new MyThread("Потік-1");
        MyThread thread2 = new MyThread("Потік-2");

        // Запуск потоків
        thread1.start();  // НЕ викликаємо run() напряму!
        thread2.start();

        // Чекаємо завершення потоків перед продовженням
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано");
        }

        // Спосіб 2: Реалізація інтерфейсу Runnable
        System.out.println("\n1.2. Через реалізацію інтерфейсу Runnable:");
        MyRunnable runnable1 = new MyRunnable("Runnable-1");
        MyRunnable runnable2 = new MyRunnable("Runnable-2");

        // Створення потоків з об'єктами Runnable
        Thread thread3 = new Thread(runnable1);
        Thread thread4 = new Thread(runnable2);

        // Запуск потоків
        thread3.start();
        thread4.start();

        // Чекаємо завершення потоків перед продовженням
        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано");
        }

        // Використання лямбда-виразів (починаючи з Java 8)
        System.out.println("\n1.3. Використання лямбда-виразів для Runnable:");
        Thread thread5 = new Thread(() -> {
            String name = "Лямбда-потік";
            System.out.println(name + " запущено");

            for (int i = 1; i <= 3; i++) {
                System.out.println(name + ": крок " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(name + " перервано");
                }
            }

            System.out.println(name + " завершено");
        });

        thread5.start();
        try {
            thread5.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано");
        }

        // ========== 2. СИНХРОНІЗАЦІЯ ПОТОКІВ ==========
        System.out.println("\n----- 2. Синхронізація потоків -----");

        // 2.1. Проблема гонки даних (race condition)
        System.out.println("\n2.1. Проблема гонки даних (без синхронізації):");
        UnsafeCounter unsafeCounter = new UnsafeCounter();

        // Створюємо потоки, які збільшують лічильник
        Thread incrementer1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsafeCounter.increment();
            }
        });

        Thread incrementer2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsafeCounter.increment();
            }
        });

        incrementer1.start();
        incrementer2.start();

        try {
            incrementer1.join();
            incrementer2.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано");
        }

        // Очікуваний результат 2000, але можливо буде менше через гонку даних
        System.out.println("Небезпечний лічильник: " + unsafeCounter.getCount() +
                " (очікувалось: 2000)");

        // 2.2. Вирішення через синхронізований метод
        System.out.println("\n2.2. Синхронізований метод:");
        SafeCounter safeCounter = new SafeCounter();

        Thread incrementer3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.increment();
            }
        });

        Thread incrementer4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.increment();
            }
        });

        incrementer3.start();
        incrementer4.start();

        try {
            incrementer3.join();
            incrementer4.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано");
        }

        System.out.println("Безпечний лічильник: " + safeCounter.getCount() +
                " (очікувалось: 2000)");

        // 2.3. Синхронізований блок
        System.out.println("\n2.3. Синхронізований блок:");
        SharedResource resource = new SharedResource();

        Thread worker1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.useResource("Працівник-1");

                // Невеликий проміжок між операціями
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Потік перервано");
                }
            }
        });

        Thread worker2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.useResource("Працівник-2");

                // Невеликий проміжок між операціями
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Потік перервано");
                }
            }
        });

        worker1.start();
        worker2.start();

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано");
        }

        System.out.println("\n===== ЗАВЕРШЕННЯ ПРОГРАМИ =====");
    }
}

/**
 * Спосіб 1: Створення потоку через успадкування класу Thread
 */
class MyThread extends Thread {

    public MyThread(String name) {
        super(name);  // Встановлюємо ім'я потоку
    }

    @Override
    public void run() {
        System.out.println(getName() + " запущено");

        // Імітація виконання завдання
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + ": крок " + i);
            try {
                // Призупиняємо потік на короткий час
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(getName() + " перервано");
                return;
            }
        }

        System.out.println(getName() + " завершено");
    }
}

/**
 * Спосіб 2: Створення потоку через реалізацію інтерфейсу Runnable
 */
class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " запущено");

        // Імітація виконання завдання
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + ": крок " + i);
            try {
                // Призупиняємо потік на короткий час
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(name + " перервано");
                return;
            }
        }

        System.out.println(name + " завершено");
    }
}

/**
 * Клас з небезпечним (не синхронізованим) методом
 * Демонструє проблему гонки даних (race condition)
 */
class UnsafeCounter {
    private int count = 0;

    // Метод без синхронізації - може викликати гонку даних
    public void increment() {
        count++;  // Не атомарна операція!
    }

    public int getCount() {
        return count;
    }
}

/**
 * Клас з синхронізованим методом
 * Вирішує проблему гонки даних
 */
class SafeCounter {
    private int count = 0;

    // Синхронізований метод - потоки будуть виконувати його по черзі
    public synchronized void increment() {
        count++;
    }

    // Цей метод теж синхронізований для коректного отримання актуального стану
    public synchronized int getCount() {
        return count;
    }
}

/**
 * Клас, що демонструє використання синхронізованого блоку
 */
class SharedResource {
    private Object lock = new Object();  // Об'єкт для синхронізації

    public void useResource(String user) {
        // Синхронізований блок - тільки один потік може бути тут одночасно
        synchronized (lock) {
            System.out.println(user + " починає використовувати ресурс");

            // Імітація використання ресурсу
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Потік перервано");
            }

            System.out.println(user + " закінчує використовувати ресурс");
        }
    }
}