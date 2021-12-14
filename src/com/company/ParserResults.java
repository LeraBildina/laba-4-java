package com.company;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

/**
 * Этот класс печатает результаты тестирования
 */
public class ParserResults {

    /**
     * Это основной метод
     * @param initialize - начальный размер списка
     * @param count - количество итераций
     */
    public static void testPerformance(int initialize, int count) {
        Tester tester1 = new Tester(new ArrayList<>(), initialize, count);
        Tester tester2 = new Tester(new LinkedList<>(), initialize, count);

        System.out.println(parseResult(Method.ADD, tester1.testAdd(), tester2.testAdd()));
        System.out.println(parseResult(Method.GET, tester1.testGet(), tester2.testGet()));
        System.out.println(parseResult(Method.DELETE, tester1.testDelete(), tester2.testDelete()));
    }

    /**
     * Этот метод считывает результаты и возвращает их в табличной форме
     * @param method - метод тестируемый
     * @param map1 - карта скорости ArrayList
     * @param map2 - карта скорости LinkedList
     * @return res - табличная форма
     */
    public static String parseResult(Method method, Map<Position, Long> map1, Map<Position, Long> map2) {
        String res = "";

        switch (method) {
            case ADD: {
                res += "ADD\n";
                break;
            }
            case GET: {
                res += "GET\n";
                break;
            }
            case DELETE: {
                res += "DELETE\n";
                break;
            }
        }

        res += String.format("%10s|%15s|%15s|\n", "      ", "ArrayList", "LinkedList");
        res += String.format("%10s|%15s|%15s|\n", Position.BEGIN, map1.get(Position.BEGIN), map2.get(Position.BEGIN));
        res += String.format("%10s|%15s|%15s|\n", Position.MIDDLE, map1.get(Position.MIDDLE), map2.get(Position.MIDDLE));
        res += String.format("%10s|%15s|%15s|\n", Position.END, map1.get(Position.END), map2.get(Position.END));

        return res;
    }
}