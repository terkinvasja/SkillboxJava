import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E");

        int toDayYear = Calendar.getInstance().get(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1987, Calendar.APRIL, 2, 2, 0, 0);

        int years = toDayYear - calendar.get(Calendar.YEAR);
        for (int i = 0; i <= years; i++) {
            Date date = calendar.getTime();
            System.out.println(String.format("%s - %s", i, dateFormat.format(date)));
            calendar.add(Calendar.YEAR, 1);
        }
    }
}
