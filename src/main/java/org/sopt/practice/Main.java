package org.sopt.practice;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(21);
        Driver driver = new Driver(person);

        Vehicle vehicle1 = new Car("GV80", "현대");
        Vehicle vehicle2 = new Cycle();

        System.out.println(vehicle1.run(driver));
        System.out.println(vehicle2.run(driver));
        //vehicle1.bbang() 불가

        Car car = new Car("GV80", "현대");
        car.bbang();

        if (driver.canDrive()) {
            System.out.println("운전가능");
        } else {
            System.out.println("집에가라");
        }
    }
}

