import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private static final String OUT_DATA_FORMAT = "Имя: %s, Телефон: %s";
    // TreeMap<String phoneNumber, String name>
    private static Map<String, String> phoneBook = new TreeMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("Введите имя, номер или команду (LIST, EXIT): ");
            String str = reader.readLine().trim();

            if ("EXIT".equalsIgnoreCase(str)) {
                return;
            } else if ("LIST".equalsIgnoreCase(str)) {
                list();
            } else {
                if (!str.isEmpty()) {
                    if (str.matches("\\d+")) {
                        if (!findByPhoneNumber(str)) {
                            addPhoneNumberToPhoneBook(str);
                        }
                    } else {
                        if (!findByName(str)) {
                            addNameToPhoneBook(str);
                        }
                    }
                }
            }
        }
    }

    /**
     * Метод выводит весь список номеров и их данные в консоль
     */
    private static void list () {
        phoneBook.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach((m) -> printData(m.getKey(), m.getValue()));
    }

    /**
     * Метод ищет номер телефона в справочнике и выводит данные в консоль по этому номеру.
     * @param phoneNumber искомый номер телефона
     */
    private static boolean findByPhoneNumber(String phoneNumber) {
        boolean find = phoneBook.containsKey(phoneNumber);
        if (find) {
            printData(phoneNumber);
        }
        return find;
    }

    /**
     * Метод ищет все совпадения имен в справочнике и выводит данные в консоль.
     * @param name искомое имя
     */
    private static boolean findByName(String name) {
        boolean find = false;
        for (Map.Entry<String, String> pair : phoneBook.entrySet()) {
            if (pair.getValue().equals(name)) {
                find = true;
                printData(pair.getKey(), pair.getValue());
            }
        }
        return find;
    }

    private static void addPhoneNumberToPhoneBook(String phoneNumber) throws IOException {
        System.out.println("Данный номер в базе не найден. Введите имя чтобы внести его в справочник:");
        String name = reader.readLine().trim();
        phoneBook.put(phoneNumber, name);
    }

    private static void addNameToPhoneBook(String name) throws IOException {
        System.out.println("Данное имя в справочнике не найдено. Введите номер телефона чтобы внести его в справочник. Номер должен содержать только числа:");
        String phoneNumber = reader.readLine().trim();
        if (phoneNumber.matches("\\d+")) {
            phoneBook.put(phoneNumber, name);
        } else {
            System.out.println("Введен некоректный номер.");
        }
    }

    private static void printData(String phoneNumber) {
        printData(phoneNumber, phoneBook.get(phoneNumber));
    }

    private static void printData(String phoneNumber, String name) {
        System.out.println(String.format(OUT_DATA_FORMAT, name, phoneNumber));
    }
}
