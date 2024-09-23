package ru.rikorotkov;

import java.util.Scanner;

public class StepTracker {
    int goalByStepsPerDay = 10000;
    Scanner scanner;
    Converter converter = new Converter();
    MonthData[] monthToData = new MonthData[12];

    StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        System.out.println("1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь,\n" +
                "  7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
        // ввод и проверка номера месяца
        int month = scanner.nextInt();

        if (!(month > 0 && month <= 12)) {
            System.out.println("Вы ввели неправильный номер месяца.");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        // ввод и проверка дня
        int day = scanner.nextInt();

        if (!(day > 0 && day < 31)) {
            System.out.println("Вы ввели неправильный день месяца.");
            return;
        }

        System.out.println("Введите количество шагов");
        // ввод и проверка количества шагов
        int steps = scanner.nextInt();

        if (steps < 0) {
            System.out.println("Количество шагов должно быть больше 0.");
            return;
        }

        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - 1];
        // сохранение полученных данных
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal(int goalByStepsPerDay) {
        if (goalByStepsPerDay <= 0) {
            System.out.println("Количество шагов должно быть больше 0.");
        } else {
            this.goalByStepsPerDay = goalByStepsPerDay;
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        System.out.println("1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь,\n" +
                "  7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (!(month < 1 && month > 12)) {
            System.out.println("Число месяца должно быть от 1 до 12 включительно.");
        }

        MonthData monthData = monthToData[month - 1];

        int sumSteps = monthData.sumStepsFromMonth();
        int maxSteps = monthData.maxSteps();
        int averageSteps = monthData.averageSteps();
        int wayInKm = converter.convertToKm(sumSteps);
        int caloriesPerMonth = converter.convertStepsToKilocalories(sumSteps);
        int bestSeries = monthData.bestSeries(month);

        monthData.printDaysAndStepsFromMonth();
        System.out.println("*".repeat(30));
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("*".repeat(30));
        System.out.println("Максимальное пройденное количество шагов за месяц: " + maxSteps);
        System.out.println("*".repeat(30));
        System.out.println("Среднее количество шагов: " + averageSteps);
        System.out.println("*".repeat(30));
        System.out.println("Пройденная дистанция (в км): " + wayInKm);
        System.out.println("*".repeat(30));
        System.out.println("Количество сожжённых килокалорий: " + caloriesPerMonth);
        System.out.println("*".repeat(30));
        System.out.println("Лучшая серия: " + bestSeries);

    }
}
