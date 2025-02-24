package org.yandex.sprint2;

import static org.yandex.sprint2.Constants.*;

class Converter {
    int convertToKm(int steps) {
        return (steps * SM_PER_STEP) / SM_PER_KM;
    }

    int convertStepsToKilocalories(int steps) {
        return (steps * CALORIES_PER_STEP) / CALORIES_PER_KILOCALORIES;
    }
}