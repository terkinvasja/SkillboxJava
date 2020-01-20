import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static boolean isDebugEnabled = false;

    public static void main(String[] args) throws IOException {

        List<ToDoTask> toDoTasks = new LinkedList<>();

        while (true) {
            System.out.print("Введите команду (LIST, ADD, EDIT, DELETE, EXIT): ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine().trim();
            if (isDebugEnabled) {
                debug("str = " + str);
            }
            if (!str.isEmpty()) {
                int firstSpace = str.indexOf(" ");
                Command command;
                try {
                    if (firstSpace != -1) {
                        command = Command.valueOf(str.substring(0, firstSpace));
                    } else {
                        command = Command.valueOf(str);
                    }
                } catch (IllegalArgumentException e) {
                    continue;
                }

                switch (command) {
                    case EXIT: {
                        System.out.println("Выход из приложения.");
                        return;
                    }
                    case LIST: {
                        int i = 0;
                        for (ToDoTask toDoTask : toDoTasks) {
                            System.out.println(String.format("%s - %s", i, toDoTask.getComment()));
                            i++;
                        }
                        break;
                    }
                    case ADD: {
                        int secondSpace = str.indexOf(" ", firstSpace + 1);
                        String comment;
                        if (secondSpace != -1) {
                            int index = -1;
                            try {
                                index = Integer.parseInt(str.substring(firstSpace + 1, secondSpace));
                                comment = str.substring(secondSpace + 1);
                            } catch (NumberFormatException e) {
                                comment = str.substring(firstSpace + 1);
                            }
                            if (index == -1) {
                                toDoTasks.add(new ToDoTask(comment));
                            } else {
                                toDoTasks.add(index, new ToDoTask(comment));
                            }
                        } else {
                            comment = str.substring(firstSpace + 1);
                            toDoTasks.add(new ToDoTask(comment));
                        }
                        break;
                    }
                    case EDIT: {
                        int secondSpace = str.indexOf(" ", firstSpace + 1);
                        if (secondSpace != -1) {
                            try {
                                int index = Integer.parseInt(str.substring(firstSpace + 1, secondSpace));
                                String comment = str.substring(secondSpace + 1);
                                toDoTasks.get(index).setComment(comment);
                            } catch (NumberFormatException e) {
                                errorMessage();
                            }
                        } else {
                            errorMessage();
                        }
                        break;
                    }
                    case DELETE: {
                        try {
                            int number = Integer.parseInt(str.substring(firstSpace + 1));
                            ToDoTask toDoTask = toDoTasks.remove(number);
                            if (toDoTask != null) {
                                System.out.println(String.format("Задача удалена: %s - %s.", number, toDoTask.getComment()));
                            } else {
                                System.out.println("Не удалось удалить задачу под номером: " + number);
                            }
                        } catch (NumberFormatException e) {
                            errorMessage();
                        }
                        break;
                    }
                    default: {
                        errorMessage();
                    }
                }
            }
        }
    }

    private static void errorMessage() {
        System.out.println("Введены некорректные данные");
    }

    private static void debug(String str) {
        System.out.println("DEBUG Main.class: " + str);
    }
}
