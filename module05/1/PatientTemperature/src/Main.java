import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {

    private final static int MIN_TEMPERATURE = 32;
    private final static int MAX_TEMPERATURE = 40;
    private final static int NUMBER_TEMPERATURE_VALUES = 30;
    private final static int PRECISE = 10;

    private final static double MIN_HEALTHY_TEMPERATURE = 36.2;
    private final static double MAX_HEALTHY_TEMPERATURE = 36.9;

    public static void main(String[] args) {

        int[] temperatureArray = generateTemperaturesArray(
                MIN_TEMPERATURE,
                MAX_TEMPERATURE,
                NUMBER_TEMPERATURE_VALUES
        );
        BigDecimal mean = new BigDecimal(
                Arrays.stream(temperatureArray).sum()*1.0 / (NUMBER_TEMPERATURE_VALUES * PRECISE),
                new MathContext(4)
        ).setScale(2, RoundingMode.HALF_UP);
        System.out.println(String.format("Средняя температура по больнице: %s °C", mean.doubleValue()));

        long numberOfHealthyPatients = Arrays.stream(temperatureArray)
                .filter(x -> x >= (int)(MIN_HEALTHY_TEMPERATURE * PRECISE) && x <= (int)(MAX_HEALTHY_TEMPERATURE * PRECISE))
                .count();
        System.out.println("Количество здоровых пациентов: " + numberOfHealthyPatients);
    }

    private static int[] generateTemperaturesArray(int min, int max, int quantity) {
        int minT = min * PRECISE;
        int maxT = max * PRECISE;
        int[] temperatureArray = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            temperatureArray[i] = (int)((Math.random() * ((maxT - minT) + 1)) + minT);
        }
        return temperatureArray;
    }
}
