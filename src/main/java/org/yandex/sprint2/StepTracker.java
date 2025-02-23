package org.yandex.sprint2;

import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10_000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        this.scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно.");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        // ввод и проверка дня
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно.");
            return;
        }

        System.out.println("Введите количество шагов");
        // ввод и проверка количества шагов
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Количество шагов должно быть положительным числом.");
            return;
        }

        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - 1];

        // сохранение введенных данных в массив
        monthData.days[day - 1] = steps;
        System.out.println("Данные успешно сохранены.");
    }

    void changeStepGoal() {
        System.out.println("Введите новое целевое количество шагов");
        int newGoal = scanner.nextInt();
        if (newGoal <= 0) {
            System.out.println("Целевое количество шагов должно быть больше 0.");
            return;
        }
        goalByStepsPerDay = newGoal;
        System.out.println("Целевое количество шагов успешно изменено.");
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно.");
            return;
        }

        MonthData monthData = monthToData[month - 1]; // получение соответствующего месяца

        int sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth(); // вывод общей статистики по дням

        // вывод суммы шагов за месяц
        System.out.println("Сумма шагов за месяц: " +
                sumSteps);

        // вывод максимального пройденного количества шагов за месяц
        System.out.println("Максимальное количество шагов за месяц: " +
                monthData.getMaxSteps());

        // вывод среднего пройденного количества шагов за месяц
        System.out.println("Среднее количество шагов за месяц: " +
                (double) sumSteps / monthData.days.length);

        // вывод пройденной за месяц дистанции в километрах
        System.out.println("Пройденная за месяц дистанция в километрах: " +
                converter.convertToKm(sumSteps));

        // вывод количества сожжённых килокалорий за месяц
        System.out.println("Количество сожжённых килокалорий за месяц: " +
                converter.convertStepsToKilocalories(sumSteps));

        // вывод лучшей серии
        System.out.println("Лучшая серия за месяц: " +
                monthData.bestSeries(goalByStepsPerDay));
    }
}
