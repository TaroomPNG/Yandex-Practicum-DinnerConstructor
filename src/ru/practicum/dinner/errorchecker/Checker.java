package ru.practicum.dinner.errorchecker;

import ru.practicum.dinner.DishesService;
import ru.practicum.dinner.objects.DishType;

import java.util.ArrayList;

public class Checker {
    private static final DishesService SERVICE = new DishesService();

    public boolean checkString(String string) {
        if (string == null) {
            return false;
        }
        if (string.isEmpty()) {
            System.out.println("Ошибка: Строка пуста");
            return false;
        }
        if (Character.isDigit(string.charAt(0))) {
            System.out.println("Ошибка: Вы ввели цифру");
            return false;
        }
        return true;
    }

    public boolean checkInt (String inputInt) {
        if (inputInt == null || inputInt.isEmpty()) {
            System.out.println("Ошибка: Строка пуста");
            return false;
        }

        try {
            Integer.parseInt(inputInt);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Вы ввели не цифру");
            return false;
        }
    }

    public boolean checkDishesTypeContains (String dishesTypeIn) {
        ArrayList<DishType> dishTypes = SERVICE.getDishTypesList();

        if (Character.isDigit(dishesTypeIn.charAt(0))) {
            System.out.println("Ошибка: Вы ввели цифру");
            return false;
        }
        for (DishType dishType : dishTypes) {
            if (dishType.getName().equals(dishesTypeIn)) {
                return true;
            }
        }
        System.out.println("Ошибка: Данный тип блюд отсутсвует.");
        System.out.println("проверьте корректность написания " + dishesTypeIn);
        return false;
    }
}
