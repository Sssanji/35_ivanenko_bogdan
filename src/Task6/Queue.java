package Task6;

import Task5.Command;
/** Представляет
 * методы для помещения
 * и извлечения задач
 * обработчиком потока;
 * шаблон Worker Thread
 * @author Иваненко Богдан
 * @see Command
 */
public interface Queue {
    /** Добавляет новую задачу в очередь;
     * шаблон Worker Thread
     * @param cmd задача
     */
    void put(Command cmd);
    /** Удаляет задачу из очереди;
     * шаблон Worker Thread
     * @return удаляемая задача
     */
    Command take();
}