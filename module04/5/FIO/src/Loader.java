import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Введите ФИО одной строкой в формате (Фамилия Имя Отчество)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] words = str.trim().replaceAll("[^А-Яа-яёЁA-Za-z\\s]", "").split("\\s+");

        if (words.length == 3) {
            System.out.println("Фамилия: " + words[0]);
            System.out.println("Имя: " + words[1]);
            System.out.println("Отчество: " + words[2]);
        } else {
            System.out.println("Введены некоректные данные.");
        }
    }
}
