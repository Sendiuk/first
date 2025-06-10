package ua.com.sendiuk.lesson5;

public class OOPComprehensive {
    public static void main(String[] args) {

        // Створення об'єктів класу Person
        System.out.println("Демонстрація створення об'єктів класу Person:");

        // Кожен об'єкт має власний стан (ім'я та вік)
        Person person1 = new Person("Іван", 25);
        Person person2 = new Person("Марія", 30);

        // Виведення інформації про об'єкти
        System.out.println("Інформація про person1: " + person1.getInfo());
        System.out.println("Інформація про person2: " + person2.getInfo());

        // Виклик методів об'єктів
        person1.celebrateBirthday();
        System.out.println("Після дня народження: " + person1.getInfo() + "\n");

        // ===== ПОЛЯ (АТРИБУТИ) ТА МЕТОДИ КЛАСУ =====
        // Демонстрація різних типів полів і методів
        System.out.println("Демонстрація статичних полів та методів:");

        // Статичне поле - спільне для всіх об'єктів класу
        System.out.println("Початкова кількість осіб: " + Person.getPersonCount());
        Person person3 = new Person("Олег", 40);
        System.out.println("Після створення person3, кількість осіб: " + Person.getPersonCount());

        // Виклик статичного методу
        System.out.println("Максимальний вік серед усіх осіб: " + Person.getMaxAge() + "\n");

        // ===== СТВОРЕННЯ ТА ВИКОРИСТАННЯ ОБ'ЄКТІВ =====
        System.out.println("===== СТВОРЕННЯ ТА ВИКОРИСТАННЯ ОБ'ЄКТІВ =====\n");

        // Створення об'єкта з використанням параметризованого конструктора
        Car car1 = new Car("Toyota", "Camry", 2020);
        System.out.println("car1: " + car1.getInfo());

        // Створення об'єкта з використанням конструктора за замовчуванням
        Car car2 = new Car();
        System.out.println("car2 (до встановлення значень): " + car2.getInfo());

        // Встановлення значень полів через сетери
        car2.setBrand("Honda");
        car2.setModel("Civic");
        car2.setYear(2018);
        System.out.println("car2 (після встановлення значень): " + car2.getInfo());

        // Використання методів об'єкта
        car1.accelerate(20);
        System.out.println("car1 швидкість після прискорення: " + car1.getSpeed() + " км/год");

        car1.brake(5);
        System.out.println("car1 швидкість після гальмування: " + car1.getSpeed() + " км/год\n");

        // Порівняння об'єктів
        System.out.println("Порівняння об'єктів:");
        Car car3 = new Car("Toyota", "Camry", 2020);

        System.out.println("car1 і car3 однакові через ==: " + (car1 == car3));                  // Порівняння посилань
        System.out.println("car1 і car3 однакові через equals: " + car1.equals(car3) + "\n");    // Порівняння вмісту

        // Демонстрація принципів ООП
        // 1. Інкапсуляція

        BankAccount account = new BankAccount("123456789", "Петро Іваненко");
        account.deposit(1000);
        System.out.println(account.getAccountInfo());

        // balance є private, тому доступ можливий лише через методи
        // account.balance = 5000; // Це викликало б помилку компіляції
        account.deposit(500);
        System.out.println("Після внесення коштів: " + account.getAccountInfo());
        account.withdraw(200);
        System.out.println("Після зняття коштів: " + account.getAccountInfo() + "\n");

        // 2. Наслідування
        // Створення об'єкта підкласу
        SavingsAccount savingsAccount = new SavingsAccount("987654321", "Олена Петренко", 2.5);
        savingsAccount.deposit(1000);
        System.out.println(savingsAccount.getAccountInfo());

        // Виклик методу, успадкованого від базового класу
        savingsAccount.withdraw(100);
        System.out.println("Після зняття коштів: " + savingsAccount.getAccountInfo());

        // Виклик унікального методу підкласу
        savingsAccount.addInterest();
        System.out.println("Після нарахування відсотків: " + savingsAccount.getAccountInfo() + "\n");

        // 3. Поліморфізм
        System.out.println("Однаковий інтерфейс, різна реалізація. Перевизначення методів у підкласах");
        System.out.println("Перевантаження методів (різні параметри)\n");

        // Створення масиву рахунків різних типів - Динамічний поліморфізм
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new BankAccount("111111", "Клієнт 1");
        accounts[1] = new SavingsAccount("222222", "Клієнт 2", 3.0);
        accounts[2] = new CheckingAccount("333333", "Клієнт 3", 500);

        // Перебір рахунків і виклик методу deposit
        // Демонстрація поліморфізму - один і той самий метод, різна поведінка
        System.out.println("Внесення 1000 грн на кожен рахунок:");
        for (BankAccount acc : accounts) {
            acc.deposit(1000);
            // Виклик методу toString(), який перевизначений в кожному класі
            System.out.println(acc);
        }

        // Перевантаження методів - Статичний поліморфізм
        System.out.println("\nДемонстрація перевантаження методів:");
        Calculator calc = new Calculator();
        System.out.println("Сума двох чисел: " + calc.add(5, 3));
        System.out.println("Сума трьох чисел: " + calc.add(5, 3, 2));
        System.out.println("Сума двох дійсних чисел: " + calc.add(5.5, 3.5) + "\n");

        // 4. Абстракція
        System.out.println("Виділення суттєвих характеристик об'єкта. Приховування складної реалізації");
        System.out.println("Використання абстрактних класів та інтерфейсів\n");

        // Створення об'єктів, які реалізують інтерфейс Shape
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        System.out.println("Круг з радіусом 5:");
        System.out.println("Площа: " + circle.calculateArea());
        System.out.println("Периметр: " + circle.calculatePerimeter());

        System.out.println("\nПрямокутник 4x6:");
        System.out.println("Площа: " + rectangle.calculateArea());
        System.out.println("Периметр: " + rectangle.calculatePerimeter());
    }
}

/**
 * Клас, що представляє особу
 */
class Person {
    // Поля екземпляра (нестатичні) - кожен об'єкт має свої власні значення
    private String name;
    private int age;

    // Статичні поля - спільні для всіх об'єктів класу
    private static int personCount = 0;

    /**
     * Конструктор - спеціальний метод для ініціалізації об'єктів
     */
    public Person(String name, int age) {
        this.name = name;       // this посилається на поточний об'єкт
        this.age = age;
        personCount++;          // Збільшуємо лічильник осіб при створенні нового об'єкта
    }

    /**
     * Метод екземпляра - повертає інформацію про особу
     */
    public String getInfo() {
        return name + ", " + age + " років";
    }

    /**
     * Метод екземпляра - імітує святкування дня народження
     */
    public void celebrateBirthday() {
        age++;
        System.out.println(name + " святкує день народження! Тепер йому/їй " + age + " років.");
    }

    /**
     * Статичний метод - повертає загальну кількість створених об'єктів Person
     */
    public static int getPersonCount() {
        return personCount;
    }

    /**
     * Статичний метод - знаходить максимальний вік серед усіх осіб
     * (це просто приклад; у реальному коді потрібно було б зберігати всіх осіб)
     */
    public static int getMaxAge() {
        // Для простоти прикладу повертаємо фіксоване значення
        return 40;
    }
}

/**
 * Клас, що представляє автомобіль
 */
class Car {
    // Поля класу
    private String brand;
    private String model;
    private int year;
    private int speed;

    /**
     * Конструктор за замовчуванням
     */
    public Car() {
        this.brand = "Невідомо";
        this.model = "Невідомо";
        this.year = 0;
        this.speed = 0;
    }

    /**
     * Параметризований конструктор
     */
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = 0;
    }

    // Гетери і сетери
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSpeed() {
        return speed;
    }

    /**
     * Повертає інформацію про автомобіль
     */
    public String getInfo() {
        return brand + " " + model + " (" + year + ")";
    }

    /**
     * Метод для прискорення автомобіля
     */
    public void accelerate(int amount) {
        speed += amount;
        System.out.println(brand + " " + model + " прискорюється на " + amount + " км/год.");
    }

    /**
     * Метод для гальмування автомобіля
     */
    public void brake(int amount) {
        if (speed >= amount) {
            speed -= amount;
        } else {
            speed = 0;
        }
        System.out.println(brand + " " + model + " гальмує на " + amount + " км/год.");
    }

    /**
     * Перевизначення методу equals для порівняння об'єктів за вмістом
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Car car = (Car) obj;
        return year == car.year &&
                brand.equals(car.brand) &&
                model.equals(car.model);
    }
}

/**
 * Клас, що демонструє інкапсуляцію
 */
class BankAccount {
    // Приватні поля - доступ обмежений цим класом
    private String accountNumber;
    private String ownerName;
    private double balance;

    /**
     * Конструктор
     */
    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    /**
     * Публічний метод для внесення коштів
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Внесено " + amount + " грн на рахунок " + accountNumber);
        } else {
            System.out.println("Сума внесення має бути більше нуля");
        }
    }

    /**
     * Публічний метод для зняття коштів
     */
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Знято " + amount + " грн з рахунку " + accountNumber);
        } else if (amount <= 0) {
            System.out.println("Сума зняття має бути більше нуля");
        } else {
            System.out.println("Недостатньо коштів на рахунку");
        }
    }

    /**
     * Гетер для отримання інформації про рахунок
     */
    public String getAccountInfo() {
        return "№ " + accountNumber + ", власник: " + ownerName + ", баланс: " + balance + " грн";
    }

    /**
     * Перевизначення методу toString
     */
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

/**
 * Підклас, що демонструє наслідування
 */
class SavingsAccount extends BankAccount {
    private double interestRate; // Процентна ставка

    /**
     * Конструктор
     */
    public SavingsAccount(String accountNumber, String ownerName, double interestRate) {
        // Виклик конструктора батьківського класу
        super(accountNumber, ownerName);
        this.interestRate = interestRate;
    }

    /**
     * Унікальний метод для ощадного рахунку
     */
    public void addInterest() {
        // Спочатку потрібно знати поточний баланс
        // Але ми не можемо напряму отримати доступ до приватного поля balance (можна замінити на protected)
        // Тому використовуємо непрямий підхід

        // Розраховуємо суму відсотків
        double interest = Double.parseDouble(getAccountInfo().split("баланс: ")[1].split(" грн")[0]) * interestRate / 100;

        // Використовуємо метод deposit для додавання відсотків
        deposit(interest);
        System.out.println("Нараховано " + interest + " грн відсотків за ставкою " + interestRate + "%");
    }

    /**
     * Перевизначення методу toString
     */
    @Override
    public String toString() {
        return "SavingsAccount{" + getAccountInfo() + ", interestRate=" + interestRate + "%}";
    }
}

/**
 * Ще один підклас для демонстрації поліморфізму
 */
class CheckingAccount extends BankAccount {
    private double overdraftLimit; // Кредитний ліміт

    /**
     * Конструктор
     */
    public CheckingAccount(String accountNumber, String ownerName, double overdraftLimit) {
        super(accountNumber, ownerName);
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Перевизначення методу withdraw для підтримки Кредитного ліміту
     */
    @Override
    public void withdraw(double amount) {
        // Отримуємо поточний баланс (непрямо)
        double currentBalance = Double.parseDouble(getAccountInfo().split("баланс: ")[1].split(" грн")[0]);

        if (amount > 0 && (currentBalance + overdraftLimit) >= amount) {
            // Виконуємо базовий метод withdraw, який вже має потрібну логіку
            super.withdraw(amount);

            // Додаткове повідомлення, якщо використовується овердрафт
            if (currentBalance < amount) {
                System.out.println("Використано Кредитний ліміт");
            }
        } else if (amount <= 0) {
            System.out.println("Сума зняття має бути більше нуля");
        } else {
            System.out.println("Перевищено ліміт овердрафту");
        }
    }

    /**
     * Перевизначення методу toString
     */
    @Override
    public String toString() {
        return "CheckingAccount{" + getAccountInfo() + ", overdraftLimit=" + overdraftLimit + "}";
    }
}

/**
 * Клас, що демонструє перевантаження методів
 */
class Calculator {
    /**
     * Додавання двох цілих чисел
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Додавання трьох цілих чисел (перевантаження)
     */
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Додавання двох дійсних чисел (перевантаження)
     */
    public double add(double a, double b) {
        return a + b;
    }
}

/**
 * Інтерфейс(це чистий контракт до Java 8), що демонструє повну абстракцію
 * Починаючи з Java 8, можна додавати default і static методи (тобто реалізацію)
 */
interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

/**
 * Клас, що реалізує інтерфейс Shape
 */
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

/**
 * Ще один клас, що реалізує інтерфейс Shape
 */
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}