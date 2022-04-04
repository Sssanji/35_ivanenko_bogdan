package Task3;
/** Creator
 * (шаблон проектирования
 * Factory Method)<br>
 * Объявляет метод,
 * "фабрикующий" объекты
 * @author Иваненко Богдан
 * @see Viewable#getView()
 */
public interface Viewable {
    /** Создаёт объект, реализующий {@linkplain View} */
    public View getView();
}