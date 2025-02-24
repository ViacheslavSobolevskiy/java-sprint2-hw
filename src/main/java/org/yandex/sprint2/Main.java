package org.yandex.sprint2;

import java.util.Scanner;

import static org.yandex.sprint2.Constants.*;

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

    static void printMenu() {
        // вывод доступных команд
        System.out.print(MENU);
        System.out.print(INPUT);
    }
}
