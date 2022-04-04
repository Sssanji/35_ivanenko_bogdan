package Task5;

import Task3.View;
import Task4.ViewableTable;

public class Application {
/** Формирует и отображает
 * меню; реализует шаблон
 * Singleton
 * @author Иваненко Богдан
 */
    /** Ссылка на экземпляр класса Application; шаблон Singleton
     * @see Application
     */
    private static Application instance = new Application();
    /** Закрытый конструктор; шаблон Singleton
     * @see Application
     */
    private Application() {}
    /** Возвращает ссылку на экземпляр класса Application;
     * шаблон Singleton
     * @see Application
     */
    public static Application getInstance() {
        return instance;
    }
    /** Объект, реализующий интерфейс {@linkplain View};
     * инициализируется с помощью Factory Method
     */
    private View view = new ViewableTable().getView();
    /** Объект класса {@linkplain Menu};
     * макрокоманда (шаблон Command)
     */
    private Menu menu = new Menu();
    /** Обработка команд пользователя
     * @see Application
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.execute();
    }
}