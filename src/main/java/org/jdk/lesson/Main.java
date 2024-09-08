/*
В качестве задачи предлагаю вам реализовать код для демонстрации парадокса
Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно убедиться в
верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).

Необходимо:
Создать свой Java Maven или Gradle проект;
Подключить зависимость lombok.
Можно подумать о подключении какой-нибудь математической библиотеки для
работы со статистикой
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям
 */

package org.jdk.lesson;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        test(3, 1000);
        test(5, 1000);
        test(10, 1000);
    }


    private static void test(int numDoors, int numIterations)
    {
        System.out.printf("Тест для %d дверей\n", numDoors);
        Map<Integer, Boolean> res = new HashMap<>();
        for (int i = 0; i < numIterations; i++)
        {
            Game game = new Game(numDoors);
            res.put(i, game.doGame());
        }
        // для вывода статистики используем библиотеку "commons-math3"
        DescriptiveStatistics st = new DescriptiveStatistics();
        Arrays.stream(res.values().toArray(new Boolean[0])).forEach(e -> st.addValue((e ? 1.0: 0)));
        System.out.printf("Игрок выиграл %d из %d раундов (%.1f%% случаев)\n\n", (int) st.getSum(), numIterations, st.getMean()*100);
    }


}