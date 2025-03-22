
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
        int start = N-1, end = N-1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N * 2 - 1; j++){
                if(  start <= j && j <= end){
                    sb.append("*");
                }else if( j < start){
                    sb.append(" ");
                }else if( j > end){
                    break;
                }

            }
            start--;
            end++;
            sb.append("\n");
        }
    }
}
