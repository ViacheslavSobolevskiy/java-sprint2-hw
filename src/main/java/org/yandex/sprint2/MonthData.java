package org.yandex.sprint2;

import static org.yandex.sprint2.Constants.*;

class MonthData {
    int[] days = new int[MAX_DAY - MIN_DAY + 1];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + MIN_DAY) + "-й день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int getMaxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps)
                maxSteps = days[i];
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            currentSeries = (days[i] >= goalByStepsPerDay) ? currentSeries + 1 : 0;
            if (currentSeries > finalSeries)
                finalSeries = currentSeries;
        }
        return finalSeries;
    }
}
