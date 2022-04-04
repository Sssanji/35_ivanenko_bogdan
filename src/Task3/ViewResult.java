package Task3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.company.Item;
/** ConcreteProduct
 * (Шаблон проектирования
 * Factory Method)<br>
 * сохранение и отображение
 * результатов
 * @author Иваненко Богдан
 * @see View
 */
public class ViewResult implements View {
    /** Имя файла, используемое при сериализации */
    private static final String FNAME = "items.bin";
    /** Определяет количество значений для вычисления по умолчанию */
    private static final int DEFAULT_NUM = 10;
    /** Коллекция десятичных чисел и результатов вычислений */
    private ArrayList<Item> items = new ArrayList<>();
    /** Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
     * с параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }
    /** Инициализирует коллекцию {@linkplain ViewResult#items}
     * @param n начальное количество элементов
     */
    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            items.add(new Item());
        }
    }
    /** Получить значение {@linkplain ViewResult#items}
     * @return текущее значение ссылки на объект {@linkplain ArrayList}
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    /** Вычисляет значение чередований.
     * @param x - десятичное число.
     * @return результат вычисления.
     */
    private int calc(int x) {
        String BinaryS = Integer.toBinaryString((int) x);
        int binary = Integer.parseInt (Integer.toBinaryString((int) x));
        int counter =0;
        int buff = binary%10;
        binary = binary/10;
        for(int i=0;i<BinaryS.length()-2;i++) {
            if(buff != binary%10) {
                counter++;
            }
            buff = binary%10;
            binary = binary/10;
        }
        return counter;
    }
    /** Вычисляет значение чередований и сохраняет
     * результат в коллекции {@linkplain ViewResult#items}
     * @param stepX шаг приращения десятичного числа
     */
    public void init(int stepX) {
        int x =(int)(0 + Math.random()*1000);
        for(Item item : items) {
            item.setXY(x, calc(x));
            x = stepX +(int)(0 + Math.random()*100) ;
        }
    }
    /** Вызывает <b>init(int stepX)</b> со случайным значением десятичного числа<br>
     * {@inheritDoc}
     */
    @Override
    public void viewInit() {
        init((int)(0 + Math.random()*1000));
    }
    /** Реализация метода {@linkplain View#viewSave()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }
    /** Реализация метода {@linkplain View#viewRestore()}<br>
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item>) is.readObject();
        is.close();
    }
    /** Реализация метода {@linkplain View#viewHeader()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }
    /** Реализация метода {@linkplain View#viewBody()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewBody() {
        for(Item item : items) {
            System.out.printf("Decimal number: %d; \nNumber of alternations 0 and 1 in binary representation: %d \n\n", item.getX(), item.getY());
        }
        System.out.println();
    }
    /** Реализация метода {@linkplain View#viewFooter()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        System.out.println("End.");
    }
    /** Реализация метода {@linkplain View#viewShow()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}