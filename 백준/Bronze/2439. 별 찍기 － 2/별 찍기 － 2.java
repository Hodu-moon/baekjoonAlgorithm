
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        printStart(N);

        System.out.println(sb);
    }

    static void printStart(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i + j < n-1){
                    sb.append(" ");
                }else{
                    sb.append("*");
                }

//                if(i + j >= n-1){
//                    sb.append("*");
//                }else{
//                    sb.append(" ");
//                }
            }
            sb.append("\n");
        }
    }
}
