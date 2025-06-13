package ua.com.sendiuk.lesson2;

public class Car {

    int  speed= 30;
    String carName;
    int year;
    Wheel wheel;
    static int distance = 12000;

    public Car(String carName, int year) {
        this.carName = carName;
        this.year = year;
    }



    {
        int a = 10;
    }


    void run(){
        int newVar = 40;
        speed = 60;

        newVar = 60;

    }
    void run2(){
        //newVar = 50;
        speed = 60;
    }



    void swap (int x, int y) {
        System.out.println("x=" + x + ", y=" + y);
        int t =x;
        x = y;
        y = t;
        System.out.println("x=" + x + ", y=" + y);
    }

}
