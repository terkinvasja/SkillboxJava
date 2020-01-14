import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Введите номер в любом формате: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String phoneNumber = str.trim().replaceAll("[^0-9]", "");
        System.out.println("Номер после очистки: +" + phoneNumber);
    }
}
