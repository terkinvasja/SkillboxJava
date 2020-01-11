public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        System.out.println(new Main().sumDigits(10));
    }

    public Integer sumDigits(Integer number)
    {
        String numberString = number.toString();
        int result = 0;
        for (int i = 0; i < numberString.length(); i++) {
            result += Character.getNumericValue(numberString.charAt(i));
        }
        //@TODO: write code here
        return result;
    }
}
