package Task4;
import Task3.ViewableResult;
import Task3.View;
/** ConcreteCreator
 * (шаблон проектирования
 * Factory Method)<br>
 * Объявляет метод,
 * "фабрикующий" объекты
 * @author Иваненко Богдан
 * @see ViewableResult
 * @see ViewableTable#getView()
 */
public class ViewableTable extends ViewableResult {
    /** Создаёт отображаемый объект {@linkplain ViewTable} */
    @Override
    public View getView() {
        return new ViewTable();
    }
}