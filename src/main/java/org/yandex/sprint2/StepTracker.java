package org.yandex.sprint2;

import java.util.Arrays;
import java.util.Scanner;

import static org.yandex.sprint2.Constants.*;

class StepTracker {

    Scanner scanner;
    MonthData[] monthToData = new MonthData[MAX_MONTH - MIN_MONTH + 1];
    int goalByStepsPerDay = DEFAULT_STEPS_PER_DAY;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        this.scanner = scan;
        Arrays.setAll(monthToData, i -> new MonthData());
    }

    void addNewNumberStepsPerDay() {
        System.out.print(monthInput);
        System.out.print(INPUT);
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < MIN_MONTH || month > MAX_MONTH) {
            System.out.println("Неверный номер месяца");
            return;
        }

        System.out.println("Введите день от " + MIN_DAY + " до " + MAX_DAY + " (включительно)");
        System.out.print(INPUT);
        // ввод и проверка дня
        int day = scanner.nextInt();
        if (day < MIN_DAY || day > MAX_DAY) {
            System.out.println("Указан неверный день");
            return;
        }

        System.out.println("Введите количество шагов");
        System.out.print(INPUT);
        // ввод и проверка количества шагов
        int steps = scanner.nextInt();
        if (steps < MIN_STEPS) {
            System.out.println("Указано неверное количество шагов");
            return;
        }

        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - MIN_MONTH];

        // сохранение введенных данных в массив
        monthData.days[day - MIN_DAY] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель по шагам:");
        System.out.print(INPUT);
        int newGoal = scanner.nextInt();
        if (newGoal <= 0) {
            System.out.println("Цель должна быть больше нуля!");
            return;
        }
        goalByStepsPerDay = newGoal;
        System.out.println("Новая цель по шагам успешно сохранена.");
    }

    void printStatistic() {
        System.out.print(monthInput);
        System.out.print(INPUT);
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < MIN_MONTH || month > MAX_MONTH) {
            System.out.println("Неверный номер месяца");
            return;
        }

        MonthData monthData = monthToData[month - MIN_MONTH]; // получение соответствующего месяца

        int sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth(); // вывод общей статистики по дням

        // вывод суммы шагов за месяц
        System.out.println("*** Общее количество шагов за месяц: " +
                sumSteps);

        // вывод максимального пройденного количества шагов за месяц
        System.out.println("*** Максимальное пройденное количество шагов за месяц: " +
                monthData.getMaxSteps());

        // вывод среднего пройденного количества шагов за месяц
        System.out.println("*** Среднее количество шагов: " +
                sumSteps / monthData.days.length);

        // вывод пройденной за месяц дистанции в километрах
        System.out.println("*** Пройденная дистанция (в км): " +
                converter.convertToKm(sumSteps));

        // вывод количества сожжённых килокалорий за месяц
        System.out.println("*** Количество сожжённых килокалорий: " +
                converter.convertStepsToKilocalories(sumSteps));

        // вывод лучшей серии
        System.out.println("*** Лучшая серия: " +
                monthData.bestSeries(goalByStepsPerDay));
    }
}
