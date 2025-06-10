package ua.com.sendiuk.lesson3;

public class LoopTasks {

    public static void main(String[] args) {

        // Обчислення факторіалу з використанням for
        int number = 6;
        int factorial = 1;

        System.out.println("\n1. Обчислення факторіалу числа " + number + " за допомогою циклу for:");
        System.out.print("   " + number + "! = ");

        for (int i = 1; i <= number; i++) {
            factorial *= i;
            System.out.print(i);
            if (i < number) {
                System.out.print(" × ");
            }
        }
        System.out.println(" = " + factorial);

        // Обчислення факторіалу з використанням while
        int num = 5;
        int fact = 1;
        int i = 1;

        System.out.println("\n2. Обчислення факторіалу числа " + num + " за допомогою циклу while:");
        System.out.print("   " + num + "! = ");

        while (i <= num) {
            fact *= i;
            System.out.print(i);
            if (i < num) {
                System.out.print(" × ");
            }
            i++;
        }
        System.out.println(" = " + fact);

        // Рекурсивний підхід до обчислення факторіалу (для порівняння)
        System.out.println("\n5. Рекурсивне обчислення факторіалу числа 7:");
        System.out.println("   7! = " + calculateFactorial(7));

    }

    //Рекурсивне обчислення факторіалу
    public static long calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
