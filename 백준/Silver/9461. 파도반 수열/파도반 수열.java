
import java.util.Scanner;

public class Main {
    static long[] array = new long[101];
    public static void main(String[] args) {
        array[1] = 1;
        array[2] = 1;
        array[3] = 1;
        array[4] = 2;
        array[5] = 2;
        array[6] = 3;
        array[7] = 4;
        array[8] = 5;
        array[9] = 7;
        array[10] = 9;

        for(int i = 11; i <= 100; i ++){
            array[i] = array[i - 1] + array[i - 5];
        }

        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int i = 0; i < T; i++){
            int N = scanner.nextInt();
            sb.append(array[N]).append("\n");
        }

        System.out.println(sb);

    }
}
