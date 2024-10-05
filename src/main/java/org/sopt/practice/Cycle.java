package org.sopt.practice;

public class Cycle implements Vehicle{

    public String run(Driver driver) {
        if(driver.canDrive()){
            return "오토바이 동작";
        } else {
            return "안됩니다";
        }
    }
}
