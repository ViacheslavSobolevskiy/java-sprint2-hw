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
                    return;
                default:
                    System.out.println("Неверный код команды. Введите код от 1 до 4 (включительно).");
                    break;
            }
        }
    }

    private static final String MENU = """
            Введите код команды:
            1. Ввести количество шагов за определённый день
            2. Изменить цель по количеству шагов в день
            3. Напечатать статистику за определённый месяц
            4. Выйти из приложения
            """;

    private static final String INPUT = "--> ";

    static void printMenu() {
        // вывод доступных команд
        System.out.print(MENU);
        System.out.print(INPUT);
    }
}
