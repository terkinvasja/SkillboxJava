public class Main {

    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        text = text.replaceAll("[^0-9,]", "");
        String[] nums = text.split(",");
        int summa = 0;
        for (String num : nums) {
            summa += Integer.parseInt(num);
        }
        System.out.println(summa);
    }
}
