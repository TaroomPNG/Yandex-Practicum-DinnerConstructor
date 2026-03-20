package ru.practicum.dinner.objects;

import java.util.ArrayList;

public class DishType {

    private String name;
    private ArrayList<String> dishes;

    public DishType(String name) {
        this.name = name;
        this.dishes = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public ArrayList<String> getDishes() {
        return dishes;
    }
}
