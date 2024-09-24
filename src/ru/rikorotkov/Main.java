package ru.rikorotkov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            try {
                String command = scanner.next();
                int commandParseInt = Integer.parseInt(command);

                if (commandParseInt == 1) {
                    stepTracker.addNewNumberStepsPerDay();
                } else if (commandParseInt == 2) {
                    System.out.println("Введите новую цель по количеству шагов в день.");
                    int stepGoal = scanner.nextInt();
                    stepTracker.changeStepGoal(stepGoal);
                } else if (commandParseInt == 3) {
                    stepTracker.printStatistic();
                } else if (commandParseInt == 4) {
                    return;
                } else {
                    System.out.println("Неверная команда.");
                }
            } catch (Exception e) {
                System.out.println("Неверная команда.");
            }

        }

    }

    static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1. Ввести количество шагов за определенный день.");
        System.out.println("2. Изменить цель по количеству шагов за день.");
        System.out.println("3. Напечатать статистику за определенный месяц.");
        System.out.println("4. Выйти из приложения.");
    }
}