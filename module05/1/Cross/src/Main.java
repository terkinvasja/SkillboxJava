public class Main {

    private final static int CROSS_SIZE = 7;

    public static void main(String[] args) {

        char[][] cross = new char[CROSS_SIZE][CROSS_SIZE];

        for (int i = 0; i < CROSS_SIZE; i++) {
            for (int j = 0; j < CROSS_SIZE; j++) {
                if (j == i || j == CROSS_SIZE - 1 - i) {
                    cross[i][j] = 'x';
                } else {
                    cross[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i < CROSS_SIZE; i++) {
            for (int j = 0; j < CROSS_SIZE; j++) {
                System.out.print(cross[i][j]);
                if (j == CROSS_SIZE - 1) {
                    System.out.println("");
                }
            }
        }
    }
}
