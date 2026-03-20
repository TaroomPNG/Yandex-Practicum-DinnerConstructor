package ru.practicum.dinner;

import ru.practicum.dinner.errorchecker.Checker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static Checker checker;

    static void main(String[] args) {
        scanner = new Scanner(System.in);
        checker = new Checker();

        DishesService dishesService = new DishesService();
        DinnerConstructor dinnerConstructor = new DinnerConstructor();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command){
                case "1":
                    dishesService
                            .addNewDishes(enterDishesTypeName(), enterDishesName());
                    break;
                case "2":
                    dinnerConstructor
                            .buildDinner(enterDishesTypeForGenerator(), enterCombosCounter());
                    break;
                case "3":
                    dishesService
                            .getAllDishesType();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Данной команды нет!");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println(" ");
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Вывести список всех типов блюд");
        System.out.println("0 - Выход");
        System.out.println(" ");
    }


    private static int enterCombosCounter () {
        String combosCounter;
        while (true) {
            System.out.println("Введите количество наборов, которые нужно сгенерировать:");
            combosCounter = scanner.nextLine();
            if (checker.checkInt(combosCounter)) {
                return Integer.parseInt(combosCounter);
            }
        }
    }

    private static ArrayList<String> enterDishesTypeForGenerator() {
        ArrayList<String> dishTypesIn = new ArrayList<>();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter).");
        System.out.println("Для завершения ввода введите пустую строку");

        String nextItem = scanner.nextLine();
        while (!nextItem.isEmpty()) {
            if (checker.checkDishesTypeContains(nextItem)) {
                dishTypesIn.add(nextItem);
            }
            nextItem = scanner.nextLine();
        }

        System.out.print("Выбранные типы блюд: ");
        for (String dishTypes : dishTypesIn) {
            System.out.print(dishTypes + ", ");
        }
        return dishTypesIn;
    }

    private static String enterDishesTypeName() {
        String dishesTypeName;
        while (true) {
            System.out.println("Введите тип блюда:");
            dishesTypeName = scanner.nextLine();
            if (checker.checkString(dishesTypeName)) {
                return dishesTypeName;
            }
        }
    }

    private static String enterDishesName() {
        while (true) {
            System.out.println("Введите название блюда:");
            String dishesName = scanner.nextLine();
            if (checker.checkString(dishesName)) {
                return dishesName;
            }
        }
    }

}