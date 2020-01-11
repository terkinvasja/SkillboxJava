import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vasily on 12.10.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Введите количество ящиков: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int box = Integer.parseInt(reader.readLine());
        int quantityBox = 27;
        int container = 1;
        int quantityContainer = 12;
        int truck = 1;

        System.out.println("Грузовик " + truck + ":");
        System.out.println("\tКонтейнер " + container + ":");
        for (int i = 1; i <= box; i++) {
            if (i == (quantityBox * container + 1)) {
                container++;
                if (container == quantityContainer * truck + 1) {
                    truck++;
                    System.out.println("Грузовик " + truck + ":");
                }
                System.out.println("\tКонтейнер " + container + ":");
            }

            System.out.println("\t\tЯщик  " + i);
        }
        System.out.println("Количество ящиков: " + box);
        System.out.println("Количество контейнеров: " + container);
        System.out.println("Количество грузовиков: " + truck);
    }
}
