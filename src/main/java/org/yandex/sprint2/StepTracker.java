package org.yandex.sprint2;

import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10_000;
    Converter converter = new Converter();

    private static final String monthInput = """
                Введите номер месяца
                1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь,
                7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь
                """;
    private static final String INPUT = "--> ";

    StepTracker(Scanner scan) {
        this.scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.print(monthInput);
        System.out.print(INPUT);
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Неверный номер месяца");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        System.out.print(INPUT);
        // ввод и проверка дня
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Указан неверный день");
            return;
        }

        System.out.println("Введите количество шагов");
        System.out.print(INPUT);
        // ввод и проверка количества шагов
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Указано неверное количество шагов");
            return;
        }

        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - 1];

        // сохранение введенных данных в массив
        monthData.days[day - 1] = steps;
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
        if (month < 1 || month > 12) {
            System.out.println("Неверный номер месяца");
            return;
        }

        MonthData monthData = monthToData[month - 1]; // получение соответствующего месяца

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
