package ua.com.sendiuk.lesson2;

public class Test {

    public static void main(String[] args) {
        Car car1 = new Car("Audi", 2010);
        System.out.println(car1.carName);
        System.out.println(car1.year);
        System.out.println(car1.speed);
        System.out.println(Car.distance);
        car1.run();
        Car car2 = new Car("BMW", 2015);
        System.out.println(car2.carName);
        System.out.println(car2.year);
        Car.distance = 15000;
        System.out.println(Car.distance);

        Car car3 = new Car("BMW2", 2016);
        System.out.println(car3.carName);
        System.out.println(car3.year);
        System.out.println(Car.distance);


        int a1 = 10;
        int a2 = 20;
        System.out.println("a1=" + a1 + ", a2=" + a2);
        car3.swap(10, 20);
        a1 = 50;
        a2 = 100;
        System.out.println("a1=" + a1 + ", a2=" + a2);



    }
}
