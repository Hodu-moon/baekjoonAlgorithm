
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            int s = scanner.nextInt();

            int Y = 0;
            if(s % h == 0){
                Y = h * 100;
            }else
                Y = (s % h) * 100;

            int X = 0;

            if( s % h == 0){
                X = (s / h);
            }else
                X = ( s / h) + 1;

            int yyxx = Y + X;
            sb.append(yyxx).append("\n");
        }
        System.out.println(sb);
    }
}
