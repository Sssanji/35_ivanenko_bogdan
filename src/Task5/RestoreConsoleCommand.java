package Task5;

import Task3.View;

/** Консольная команда
 * Restore;
 * шаблон Command
 * @author Иваненко Богдан
 */
public class RestoreConsoleCommand implements ConsoleCommand {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain com.company.Item}
     */

    private View view;
    /** Инициализирует поле {@linkplain RestoreConsoleCommand#view}
     * @param view объект, реализующий интерфейс {@linkplain View}
     */
    public RestoreConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'r';
    }
    @Override
    public String toString() {
        return "'r'estore";
    }
    @Override
    public void execute() {
        System.out.println("Restore last saved.");
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }
}