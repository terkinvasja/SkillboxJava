import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final boolean isDebugEnabled = false;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static void main(String[] args) throws IOException {

        Set<String> emailList = new HashSet<>();
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        while (true) {
            System.out.print("Введите команду (LIST, ADD email@test.com, EXIT): ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine().trim();
            if (isDebugEnabled) {
                debug("str = " + str);
            }
            if (!str.isEmpty()) {
                int firstSpace = str.indexOf(" ");
                Command command;
                try {
                    command = getCommand(str, firstSpace);
                } catch (IllegalArgumentException e) {
                    errorMessage();
                    continue;
                }
                switch (command) {
                    case EXIT: {
                        System.out.println("Выход из приложения.");
                        return;
                    }
                    case LIST: {
                        emailList.forEach(System.out::println);
                        break;
                    }
                    case ADD: {
                        String email = str.substring(firstSpace + 1);
                        if (!email.isEmpty()) {
                            Matcher matcher = pattern.matcher(email);
                            if (matcher.matches()) {
                                emailList.add(email);
                            } else {
                                System.out.println("Введен некорректный email");
                            }
                        } else {
                            System.out.println("Введена некорректно команда ADD");
                        }
                        break;
                    }
                    default: errorMessage();
                }
            }
        }
    }

    private static Command getCommand(String str, int firstSpace) throws IllegalArgumentException {
        Command command;
        if (firstSpace != -1) {
            command = Command.valueOf(str.substring(0, firstSpace));
        } else {
            command = Command.valueOf(str);
        }
        return command;
    }

    private static void errorMessage() {
        System.out.println("Введены некорректные данные");
    }

    private static void debug(String str) {
        System.out.println("DEBUG Main.class: " + str);
    }
}
