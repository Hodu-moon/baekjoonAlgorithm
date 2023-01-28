
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][]apt = new int[16][16];

        for(int i = 0; i < 15; i++){
            apt[i][1] = 1;
            apt[0][i] = i;
        }

        for(int i = 1; i < 15; i++){

            for(int j = 2; j < 15; j++){
                apt[i][j] =  apt[i-1][j]+ apt[i][j-1];
            }
        }

        int N = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            sb.append(apt[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}
