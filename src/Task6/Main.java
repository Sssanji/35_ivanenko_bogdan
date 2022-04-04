package Task6;

import Task3.View;
import Task3.ViewableResult;
import Task5.ChangeConsoleCommand;
import Task5.GenerateConsoleCommand;
import Task5.Menu;
import Task5.ViewConsoleCommand;
/** Вычисление и отображение
 * результатов; содержит реализацию
 * статического метода main()
 * @author Иваненко Богдан
 * @see Main#main
 */
public class Main {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain com.company.Item};
     * инициализируется с помощью Factory Method
     */
    private View view = new ViewableResult().getView();
    /** Объект класса {@linkplain Menu};
     * макрокоманда (шаблон Command)
     */
    private Menu menu = new Menu();
    /** Обработка команд пользователя */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }
    /** Выполняется при запуске программы
     * @param args параметры запуска программы
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}