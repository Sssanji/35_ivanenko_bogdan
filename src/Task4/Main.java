package Task4;


import Task3.View;
/** Вычисление и отображение результатов<br>
 * Содержит реализацию статического метода main()
 * @author Иваненко Богдан
 * @see Main#main
 */


public class Main extends Task3.Main {

    public Main(View view) {
        super(view);
    }


    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}