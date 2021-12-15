package com.company;
import java.util.Scanner;

/**
 * @author Byldina Valeria
 * @version 2.1
 */
public class Main {
    /**
     * функция  main
     * @param args - аргументы
     */
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var initialize = 0;
        var count = 0;
        int number = 1;

        while (number!=0) {
            try {
                System.out.println("Введите размер списка и количество итераций:");
                initialize = in.nextInt();
                count = in.nextInt();
                if (initialize >= 0 && count >= 0) {
                    ParserResults.testPerformance(initialize, count);
                    System.out.println("Каждый метод выполнялся " + count + " раз");
                } else System.out.println("Неверный ввод");
            } catch (Exception expected) {
                System.out.println(expected.getMessage());
            }
        }
    }
}