package org.yandex.sprint2;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int i = scanner.nextInt();
            // обработка выбранной команды
            switch (i) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                case 4:
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Недействительная команда. Введите номер от 1 до 4 (включительно).");
                    break;
            }
        }
    }

    private static final String MENU = """
            Меню:
            1. Ввод количество шагов за день
            2. Изменение целевого количество шагов за месяц
            3. Вывод статистики за месяц
            4. Выход из программы
            """;

    static void printMenu() {
        // вывод доступных команд
        System.out.println(MENU);
    }
}