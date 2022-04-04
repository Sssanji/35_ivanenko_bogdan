package Task5;
/** Интерфейс
 * консольной команды;
 * шаблон Command
 * @author Иваненко Богдан
 */
public interface ConsoleCommand extends Command {
    /** Горячая клавиша команды;
     * шаблон Command
     * @return символ горячей клавиши
     */
    public char getKey();
}