package com.company;
import java.io.Serializable;
/** Хранит исходные данные и результат вычислений.
 * @author Иваненко Богдан
 *
 */
public class Item implements Serializable {
    /** Вычисляемое значение. */
// transient
    private int x;
    /** Результат вычисления. */
    private int y;

    /** Автоматически сгенерированная константа */
    private static final long serialVersionUID = 1L;
    /** Инициализирует поля {@linkplain Item#x}, {@linkplain Item#y} */
    public Item() {

    }
    /** Устанавливает значения полей: десятичного числа
     * и результата вычисления .
     * @param x - значение для инициализации поля {@linkplain Item#x}
     * @param y - значение для инициализации поля {@linkplain Item#y}
     */
    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /** Установка значения поля {@linkplain Item#x}
     * @param x - значение для {@linkplain Item#x}
     * @return Значение {@linkplain Item#x}
     */
    public double setX(int x) {
        return this.x = x;
    }
    /** Получение значения поля {@linkplain Item#x}
     * @return Значение {@linkplain Item#x}
     */
    public int getX() {
        return x;
    }
    /** Установка значения поля {@linkplain Item#y}
     * @param y - значение для {@linkplain Item#y}
     * @return Значение {@linkplain Item#y}
     */
    public int setY(int y) {
        return this.y = y;
    }
    /** Получение значения поля {@linkplain Item#y}
     * @return значение {@linkplain Item#y}
     */
    public int getY() {
        return y;
    }
    /** Установка значений {@linkplain Item#x} и {@linkplain Item#y}
     * @param x - значение для {@linkplain Item#x}
     * @param y - значение для {@linkplain Item#y}
     * @return this
     */
    public Item setXY(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }
    /** Представляет результат вычислений в виде строки.<br>{@inheritDoc} */
    @Override
    public String toString() {
        return "Generated decimal number = " + x + "\nNumber of alternations 0 and 1 in binary representation\n" +
                "Given decimal number.. = " + y;
    }
}