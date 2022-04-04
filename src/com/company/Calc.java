package com.company;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Содержит реализацию методов для вычисления и отображения результатов.
 * @author Иваненко Богдан
 */
public class Calc {
    /** Имя файла, используемое при сериализации. */
    private static final String FNAME = "Item.bin";
    /** Сохраняет результат вычислений. Объект класса {@linkplain Item} */
    private Item result;
    /** Инициализирует {@linkplain Calc#result} */
    public Calc() {
        result = new Item();
    }
    /** Установить значение {@linkplain Calc#result}
     * @param result - новое значение ссылки на объект {@linkplain Item}
     */
    public void setResult(Item result) {
        this.result = result;
    }
    /** Получить значение {@linkplain Calc#result}
     * @return текущее значение ссылки на объект {@linkplain Item}
     */
    public Item getResult() {
        return result;
    }
    /** Вычисляет значение чередований.
     * @param x - десятичное число.
     * @return результат вычисления.
     */
    private int calc(int x) {

        int i = 0;  //Количество повторенний символа 01
        int j = 0;  //Количество повторенний символа 10
        int sum;

        String str = Integer.toString(x); // Перевод переменной number из int в string
        str = Integer.toString(x, 2); // Перевод числа в двоичную систему


        int index = (str.indexOf("01")); // Индекс символа 01 в строке
        int index2 = (str.indexOf("10")); // Индекс символа 10 в строке
        while (i < index){
            index++;
            index = (str.indexOf("01", index));
            i++;


        }

        while (j < index2){
            index2++;
            index2 = (str.indexOf("10", index2));
            j++;


        }
        sum = i+j;
    return sum;
    }
    /** Вычисляет значение чередований и сохраняет
     * результат в объекте {@linkplain Calc#result}
     * @param x - десятичное число.
     * @return
     */
    public int init(int x ) {
        result.setX(x);
        return result.setY(calc(x));
    }
    /** Выводит результат вычислений. */
    public void show() {
        System.out.println(result);
    }
    /** Сохраняет {@linkplain Calc#result} в файле {@linkplain Calc#FNAME}
     * @throws IOException
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new
                FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }
    /** Восстанавливает {@linkplain Calc#result} из файла {@linkplain Calc#FNAME}
     * @throws Exception
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item)is.readObject();
        is.close();
    }
}