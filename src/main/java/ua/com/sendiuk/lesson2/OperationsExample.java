package ua.com.sendiuk.lesson2;

public class OperationsExample {

    public static void main(String[] args) {
        //  Порівняння для перевірки рівності/нерівності
        int a = 5;
        int b = 3;

        System.out.println("Порівняння:");

        System.out.println("a == b: " + (a == b)); // false (5 не дорівнює 3)
        System.out.println("a != b: " + (a != b)); // true (5 не дорівнює 3)
        System.out.println("a > b: " + (a > b));   // true (5 більше за 3)
        System.out.println("a < b: " + (a < b));   // false (5 не менше за 3)
        System.out.println("a >= b: " + (a >= b)); // true (5 більше або дорівнює 3)
        System.out.println("a <= b: " + (a <= b)); // false (5 не менше і не дорівнює 3)

        System.out.println("Логічні оператори:");

        //  Логічні ➔ для комбінацій умов
        boolean condition1 = (a > b);    // true
        boolean condition2 = (b > 10);   // false

        System.out.println("condition1 && condition2: " + (condition1 && condition2));
        // false (обидві умови мають бути true для &&)
        //якщо перша умова false, Java вже знає що результат буде false, тому другу умову НЕ перевіряє.

        System.out.println("condition1 || condition2: " + (condition1 || condition2));
        // true (хоча б одна умова true для ||)
        //якщо перша умова true, Java вже знає що результат буде true, тому другу умову НЕ перевіряє.

        System.out.println("!condition1: " + (!condition1));
        // false (заперечення: condition1 true ➔ !true = false)

        System.out.println("condition1 & condition2: " + (condition1 & condition2));
        // false (обидві умови мають бути true для &)

        System.out.println("condition1 | condition2: " + (condition1 | condition2));
        // true (хоча б одна умова має бути true для |)
    }
}
