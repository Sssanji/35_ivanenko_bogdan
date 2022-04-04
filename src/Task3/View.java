package Task3;
import java.io.IOException;
/** Product
 * (шаблон проектирования
 * Factory Method)<br>
 * Интерфейс "фабрикуемых"
 * объектов<br>
 * Объявляет методы
 * отображения объектов
 * @author Иваненко Богдан
 *
 */
public interface View {
    /** Отображает заголовок */
    public void viewHeader();
    /** Отображает основную часть */
    public void viewBody();
    /** Отображает окончание */
    public void viewFooter();
    /** Отображает объект целиком */
    public void viewShow();
    /** Выполняет инициализацию */
    public void viewInit();
    /** Сохраняет данные для последующего восстановления
     * @throws java.io.IOException */
    public void viewSave() throws IOException;
    /** Восстанавливает ранее сохранённые данные
     * @throws java.lang.Exception */
    public void viewRestore() throws Exception;
}