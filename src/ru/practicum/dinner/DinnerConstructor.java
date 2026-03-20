package ru.practicum.dinner;

import ru.practicum.dinner.objects.DishType;

import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {

    private final DishesService SERVICE = new DishesService();
    private final ArrayList<DishType> DISH_TYPES_LIST = SERVICE.getDishTypesList();
    private final Random RANDOM  = new Random();

    public void buildDinner(ArrayList<String> dishTypesIn, int combosCounter) {
        for (int i = 0; i < combosCounter; i++) {
            System.out.println("Комбо номер " + (i + 1) + ": " + makeCombo(dishTypesIn));
        }
    }

    private String makeCombo(ArrayList<String> dishTypesIn) {
        ArrayList<DishType> selectedDishesType = selectDishesType(dishTypesIn);

        String dishCombo = "";
        String dish;
        int dishRandomIndex;

        for (DishType dishType : selectedDishesType) {
            dishRandomIndex = RANDOM.nextInt(dishType.getDishes().size());
            dish = dishType.getDishes().get(dishRandomIndex);
            dishCombo += dish + ", ";
        }

        return dishCombo;
    }

    private ArrayList<DishType> selectDishesType(ArrayList<String> dishTypesIn) {
        ArrayList<DishType> selectedDishesType = new ArrayList<>();
        for (String string : dishTypesIn) {
            for (DishType dishType : DISH_TYPES_LIST) {
                if (dishType.getName().equals(string)) {
                    selectedDishesType.add(dishType);
                    break;
                }
            }
        }
        return selectedDishesType;
    }
}
