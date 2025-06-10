package ua.com.sendiuk.lesson2;

public class PriorityOperations {

    public static void main(String[] args) {
        // 1. Найвищий пріоритет: дужки ()
        int result1 = (2 + 3) * 4;  // 20, а не 14
        System.out.println("(2 + 3) * 4 = " + result1);

        // 2. Унарні оператори: ++, --, +, -, !
        int result2 = -5 + 3 * 2;  // -5 + 6 = 1
        System.out.println("-5 + 3 * 2 = " + result2);

        // 3. Мультиплікативні операції: *, /, %
        int result3 = 5 + 4 * 3 / 2;  // 5 + 6 = 11
        System.out.println("5 + 4 * 3 / 2 = " + result3);

        // 4. Адитивні операції: +, -
        int result4 = 10 - 3 + 5 * 2;  // 10 - 3 + 10 = 17
        System.out.println("10 - 3 + 5 * 2 = " + result4);

        // 5. Оператори зсуву: <<, >>, >>>
        // зміщують двійкове представлення числа вліво або вправо
        int result5 = 8 >> 1 + 1;  // 8 >> 2 = 2
        System.out.println("8 >> 1 + 1 = " + result5);

        // 6. Операції порівняння: <, >, <=, >=, instanceof
        boolean result6 = 5 + 3 < 10 - 2;  // 8 < 8 = false
        System.out.println("5 + 3 < 10 - 2 = " + result6);

        // 7. Оператори рівності: ==, !=
        boolean result7 = 5 * 2 == 3 + 7;  // 10 == 10 = true
        System.out.println("5 * 2 == 3 + 7 = " + result7);

        // 8. Побітові операції: &, ^, |
        int result8 = 5 & 3 + 2;  // 5 & 5 = 5
        System.out.println("5 & 3 + 2 = " + result8);

        // 9. Логічні операції: &&, ||
        boolean result9 = true || false && false;  // true || false = true
        System.out.println("true || false && false = " + result9);

        // 10. Тернарний оператор: ?:
        int result10 = (5 > 3) ? 2 + 3 : 4 * 5;  // 5
        System.out.println("(5 > 3) ? 2 + 3 : 4 * 5 = " + result10);

        // 11. Найнижчий пріоритет: присвоєння =, +=, -= тощо
        int x = 5;
        x *= 2 + 3;  // x = x * (2 + 3) = 25
        System.out.println("x *= 2 + 3 → x = " + x);
    }
}
