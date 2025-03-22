
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        printStart(N);

        System.out.println(sb);
    }

    static void printStart(int N) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if( i <= j ){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
            sb.append("\n");

        }
    }
}
