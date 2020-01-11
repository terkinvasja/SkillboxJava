
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        int num1 = Integer.parseInt(text.substring((text.indexOf("тал") + 3), text.indexOf("руб")).trim());
        int num2 = Integer.parseInt(text.substring((text.indexOf("Маша") + 6), text.lastIndexOf("руб")).trim());
        System.out.println(num1 + num2);
    }
}