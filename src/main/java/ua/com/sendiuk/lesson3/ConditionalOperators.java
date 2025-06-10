package ua.com.sendiuk.lesson3;

public class ConditionalOperators {

    public static void main(String[] args) {
        System.out.println("===== ДЕМОНСТРАЦІЯ УМОВНИХ ОПЕРАТОРІВ В JAVA =====\n");

        // Оголошення змінних для тестування
        int a = 10;
        int b = 20;
        int c = 10;
        boolean isActive = true;
        String status = "OK";

        // 1. Простий if
        System.out.println("1. Простий if:");
        if (a < b) {
            System.out.println("   a менше за b");
        }

        // 2. if-else
        System.out.println("\n2. if-else:");
        if (a > b) {
            System.out.println("   a більше за b");
        } else {
            System.out.println("   a не більше за b");
        }

        // 3. if-else if-else (множинні розгалуження)
        System.out.println("\n3. if-else if-else:");
        if (a > b) {
            System.out.println("   a більше за b");
        } else if (a < b) {
            System.out.println("   a менше за b");
        } else {
            System.out.println("   a дорівнює b");
        }

        // 4. Вкладені if
        System.out.println("\n4. Вкладені if:");
        if (a <= b) {
            System.out.println("   a менше або дорівнює b");
            if (a == c) {
                System.out.println("   і a дорівнює c");
            }
        }

        // 5. Логічні оператори в умовах
        System.out.println("\n5. Логічні оператори:");
        // AND (&&) - обидві умови повинні бути true
        if (a < b && a == c) {
            System.out.println("   a менше за b І a дорівнює c");
        }

        // OR (||) - хоча б одна умова повинна бути true
        if (a > b || a == c) {
            System.out.println("   a більше за b АБО a дорівнює c");
        }

        // NOT (!) - інвертує значення умови
        if (!isActive) {
            System.out.println("   isActive є false");
        } else {
            System.out.println("   isActive є true");
        }

        // 6. Перевірка дорівнює (==) і не дорівнює (!=)
        System.out.println("\n6. Перевірка рівності:");
        if (a == c) {
            System.out.println("   a дорівнює c");
        }

        if (a != b) {
            System.out.println("   a не дорівнює b");
        }

        // 7. Перевірка String за допомогою equals()
        System.out.println("\n7. Порівняння рядків:");
        if (status.equals("OK")) {
            System.out.println("   Статус: OK");
        }

        // Важливо! НЕ використовуйте == для порівняння рядків
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        if (str1 == str2) {
            System.out.println("   str1 == str2 (порівняння посилань)");
        } else {
            System.out.println("   str1 != str2 (різні посилання, хоча вміст однаковий)");
        }

        if (str1.equals(str2)) {
            System.out.println("   str1.equals(str2) (порівняння вмісту)");
        }

        // 8. Тернарний оператор ? : (скорочена форма if-else)
        System.out.println("\n8. Тернарний оператор:");
        String result = (a < b) ? "a менше за b" : "a не менше за b";
        System.out.println("   " + result);

        // 9. Switch-case конструкція
        System.out.println("\n9. Switch-case:");
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("   Понеділок");
                break;
            case 2:
                System.out.println("   Вівторок");
                break;
            case 3:
                System.out.println("   Середа");
                break;
            case 4:
                System.out.println("   Четвер");
                break;
            case 5:
                System.out.println("   П'ятниця");
                break;
            case 6:
            case 7:
                System.out.println("   Вихідний");
                break;
            default:
                System.out.println("   Некоректний день тижня");
        }
    }
}
