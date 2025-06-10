package ua.com.sendiuk.lesson2;

public class TypeConversion {

    public static void main(String[] args) {

        // 1. Неявне (автоматичне) перетворення (Розширення)
        System.out.println("\n1. Неявне перетворення:");
        int a = 100;
        long b = a;  // int → long
        double c = b; // long → double
        System.out.println("int " + a + " → long " + b + " → double " + c);

        // 2. Явне перетворення (Звуження)
        System.out.println("\n2. Явне перетворення:");
        double x = 9.78;
        int y = (int) x;  // double → int
        System.out.println("double " + x + " → int " + y);

        // 3. Перетворення між цілими типами
        System.out.println("\n3. Цілі типи:");
        byte small = 10;
        int medium = small;  // byte → int
        long large = medium; // int → long
        short s = (short) large;  // long → short
        System.out.println("byte " + small + " → int " + medium + " → long " + large + " → short " + s);

        // 4. Перетворення між цілими і дробовими
        System.out.println("\n4. Цілі ↔ дробові:");
        int i = 100;
        float f = i;  // int → float
        double d = 100.5;
        int j = (int) d;  // double → int
        System.out.println("int " + i + " → float " + f);
        System.out.println("double " + d + " → int " + j);

        // 5. Перетворення char ↔ int
        System.out.println("\n5. char ↔ int:");
        char ch = 'A';
        int code = ch;  // char → int
        char symbol = (char) 66;  // int → char
        System.out.println("char '" + ch + "' → int " + code);
        System.out.println("int 66 → char '" + symbol + "'");

        // 6. Перетворення з String
        System.out.println("\n6. String ↔ числа:");
        String numberStr = "123";
        int num = Integer.parseInt(numberStr);  // String → int
        String text = String.valueOf(123.45);   // double → String
        System.out.println("String \"" + numberStr + "\" → int " + num);
        System.out.println("double 123.45 → String \"" + text + "\"");

        // 7. Перевірка меж при перетворенні
        System.out.println("\n7. Перевірка меж:");
        double bigValue = 1e100;
        if (bigValue <= Integer.MAX_VALUE && bigValue >= Integer.MIN_VALUE) {
            int intValue = (int) bigValue;
            System.out.println("double " + bigValue + " → int " + intValue);
        } else {
            System.out.println("double " + bigValue + " не може бути перетворене в int без втрат");
        }

        // 8. Втрати при перетворенні
        System.out.println("\n8. Втрати даних:");
        float floatValue = 123.456f;
        int intFromFloat = (int) floatValue;
        System.out.println("float " + floatValue + " → int " + intFromFloat + " (втрачається дробова частина)");
    }
}
