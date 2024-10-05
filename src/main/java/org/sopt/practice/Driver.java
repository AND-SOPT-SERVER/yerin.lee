package org.sopt.practice;

public class Driver {
    private final Person person;

    Driver(Person person) {
        this.person = person;
    }

    public boolean canDrive(){
        return person.getAge() >= 20;
        //NPE(NullPointerException) - RuntimeError
    }
}
