package com.sopt_server.seminar.api.enums;

public enum Category {
    FOOD("food"),
    WORKOUT("workout"),
    PROGRAMMING("programming");

    public String category;

    Category(String category) {
        this.category = category;
    }
}
