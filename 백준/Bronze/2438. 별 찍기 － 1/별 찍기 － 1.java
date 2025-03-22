
import java.util.Scanner;

public class Main {
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        printStart(N);

        System.out.println(sb);
    }

    static void printStart(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
    }
}
