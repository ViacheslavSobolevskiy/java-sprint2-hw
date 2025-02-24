package org.yandex.sprint2;

public class Constants {
    static final int MIN_MONTH = 1;
    static final int MAX_MONTH = 12;
    static final int MIN_DAY = 1;
    static final int MAX_DAY = 30;
    static final int MIN_STEPS = 1;

    static final int DEFAULT_STEPS_PER_DAY = 10_000;

    static final int SM_PER_STEP = 75; // 1 шаг = 75 см
    static final int SM_PER_KM = 1000_00; // 1 км = 100000 см
    static final int CALORIES_PER_STEP = 50; // 1 шаг = 50 кал
    static final int CALORIES_PER_KILOCALORIES = 1000; // 1 ккал = 1000 кал

    static final String MENU = """
            Введите код команды:
            1. Ввести количество шагов за определённый день
            2. Изменить цель по количеству шагов в день
            3. Напечатать статистику за определённый месяц
            4. Выйти из приложения
            """;

    static final String monthInput = "Введите номер месяца" + System.lineSeparator() +
            MIN_MONTH + " - Январь, " +
            (MIN_MONTH + 1) + " - Февраль, " +
            (MIN_MONTH + 2) + " - Март, " +
            (MIN_MONTH + 3) + " - Апрель, " +
            (MIN_MONTH + 4) + " - Май, " +
            (MIN_MONTH + 5) + " - Июнь," + System.lineSeparator() +
            (MIN_MONTH + 6) + " - Июль, " +
            (MIN_MONTH + 7) + " - Август, " +
            (MIN_MONTH + 8) + " - Сентябрь, " +
            (MIN_MONTH + 9) + " - Октябрь, " +
            (MIN_MONTH + 10) + " - Ноябрь, " +
            (MIN_MONTH + 11) + " - Декабрь" + System.lineSeparator();

    static final String INPUT = "--> ";
}
