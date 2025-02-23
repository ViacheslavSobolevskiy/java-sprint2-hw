package org.yandex.sprint2;

class Converter {
    int convertToKm(int steps) {
        return (steps * 75) / 100000; // 1 шаг = 75 см; 1 км = 100000 см
    }

    int convertStepsToKilocalories(int steps) {
        return (steps * 50) / 1000; // 1 шаг = 50 кал; 1 ккал = 1000 кал.
    }
}