public class Main {

    public static void main(String[] args) {
        String[] rainbowColors = {"Red", "Orange", "Yellow",
                "Green", "Cyan", "Blue", "Violet"};

        for (int i = 0; i < rainbowColors.length / 2; i++) {
            String temp = rainbowColors[i];
            rainbowColors[i] = rainbowColors[rainbowColors.length - 1 - i];
            rainbowColors[rainbowColors.length - 1 - i] = temp;
        }

        for (String s : rainbowColors) {
            System.out.println(s);
        }
    }
}
