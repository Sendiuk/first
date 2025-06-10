package ua.com.sendiuk.lesson2;

public class PrimitiveExample {

    public static void main(String[] args) {
        // Примітивні типи (порівняння через ==)
        int a = 10;
        int b = 10;
        System.out.println("Порівняння примітивів (==):");
        System.out.println("a == b: " + (a == b));  // true - порівнюються значення

        // Об'єктні типи (порівняння через == та equals())

        String str1 = "Привіт";
        String str2 = "Привіт";
        String str3 = new String("Привіт");

        System.out.println("Порівняння рядків:");
        System.out.println("str1 == str2: " + (str1 == str2));       // true (пул рядків)
        System.out.println("str1 == str3: " + (str1 == str3));       // false (різні об'єкти)
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true (однаковий вміст)

        // Масиви (порівняння через == та Arrays.equals())

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = arr1;

        System.out.println("Порівняння масивів:");
        System.out.println("arr1 == arr2: " + (arr1 == arr2));       // false (різні об'єкти)
        System.out.println("arr1 == arr3: " + (arr1 == arr3));       // true (одне посилання)
        System.out.println("Arrays.equals(arr1, arr2): " + java.util.Arrays.equals(arr1, arr2)); // true (однаковий вміст)
    }
}
