package ru.rikorotkov;

public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps  = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps  += days[i];
        }
        return sumSteps ;
    }

    int maxSteps() {
        int maxSteps  = days[0];
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps ) {
                maxSteps  = days[i];
            }
        }
        return maxSteps ;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length - 1; i++) {
            if (days[i] >= goalByStepsPerDay && days[i + 1] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                finalSeries = currentSeries;
            }
        }
        if (currentSeries > finalSeries) {
            finalSeries = currentSeries;
        }
        return finalSeries;
    }

    int averageSteps() {
        int averageSteps = 0;
        int countDays = 0;
        for (int i = 0; i < days.length; i++) {
            averageSteps += days[i];
            if (days[i] > 0) {
                countDays++;
            }
        }
        return averageSteps / countDays;
    }
}
