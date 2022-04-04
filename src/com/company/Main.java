package com.company;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/** Вычисление и отображение результатов.
 * Содержит реализацию статического метода main().
 * @author Иваненко Богдан
 * @see Main#main
 */
public class Main {
    /** Объект класса {@linkplain Calc}.<br>Решает задачу инд. задания. */
    private final Calc calc = new Calc();
    /** Отображает меню. */
    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'e'xit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'e' -> System.out.println("Exit.");
                case 'v' -> {
                    System.out.println("View current.");
                    calc.show();
                }
                case 'g' -> {
                    System.out.println("Random generation.");
                    calc.init((int)(0 + Math.random()*1000));
                    calc.show();
                }
                case 's' -> {
                    System.out.println("Save current.");
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                case 'r' -> {
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                default -> System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'e');
    }
    /** Выполняется при запуске программы.
     * Вычисляется значение количество чередований 0 и 1 в двоичном представлении
     * заданного десятичного числа.
     * Результаты вычислений выводятся на экран.
     * @param args - параметры запуска программы.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}