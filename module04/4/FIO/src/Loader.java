import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {

    private static boolean isDebugEnabled = false;

    public static void main(String[] args) throws IOException {
        System.out.println("Введите ФИО одной строкой в формате (Фамилия Имя Отчество)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine().trim();

        int firstSpace = str.indexOf(" ");
        if (isDebugEnabled) {
            debug("firstSpace = " + firstSpace);
        }
        String surname;
        if (firstSpace != -1) {
            surname = str.substring(0, firstSpace);
        } else {
            errorMessage();
            return;
        }

        int secondSpace = str.indexOf(" ", firstSpace + 1);
        if (isDebugEnabled) {
            debug("secondSpace = " + secondSpace);
        }
        String name;
        if (secondSpace != -1) {
            name = str.substring(firstSpace + 1, secondSpace);
        } else {
            errorMessage();
            return;
        }

        String patronymic = str.substring(secondSpace + 1);

        System.out.println("Фамилия: " + surname);
        System.out.println("Имя: " + name);
        System.out.println("Отчество: " + patronymic);
    }

    private static void errorMessage() {
        System.out.println("Введены некорректные данные");
    }

    private static void debug(String str) {
        System.out.println(str);
    }
}
