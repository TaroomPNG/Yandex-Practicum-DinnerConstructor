package ru.practicum.dinner;

import ru.practicum.dinner.objects.DishType;

import java.util.ArrayList;

public class DishesService {
    private static final ArrayList<DishType> DISH_TYPES = new ArrayList<>();

    public void addNewDishes(String dishesTypeName, String dishesName) {
        for (DishType dishType : DISH_TYPES) {
            if (dishType.getName().equals(dishesTypeName)) {
                ArrayList<String> dishesList = dishType.getDishes();
                dishesList.add(dishesName);
                System.out.println(dishesName + " добавлен в " + dishType.getName());
                return;
            }
        }
        registerNewDishesType(dishesTypeName, dishesName);
    }


    public void getAllDishesType () {
        int i = 1;
        for (DishType dishType : DISH_TYPES) {
            System.out.println("Блюдо номер " + i + ": " + dishType.getName());
            i++;
        }
    }

    public ArrayList<DishType> getDishTypesList() {
        return DISH_TYPES;
    }

    private void registerNewDishesType (String dishesTypeName, String dishesName) {
        DishType dishType = new DishType(dishesTypeName);
        DISH_TYPES.add(dishType);

        dishType.getDishes().add(dishesName);

        System.out.println("Создан тип блюд: " + dishType.getName());
        System.out.println(dishesName + " добавлен в " + dishType.getName());
    }
}
