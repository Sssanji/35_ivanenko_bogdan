package Task5;

import Task3.View;
/** Консольная команда
 * View;
 * шаблон Command
 * @author Иваненко Богдан
 */

public class ViewConsoleCommand implements ConsoleCommand {

    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain com.company.Item}
     */
    private View view;
    /** Инициализирует поле {@linkplain SaveConsoleCommand#view}
     * @param view объект, реализующий интерфейс {@linkplain View}
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'v';
    }
    @Override
    public String toString() {
        return "'v'iew";
    }
    @Override
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}