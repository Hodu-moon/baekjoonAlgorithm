
import java.util.Scanner;

public class Main {

    static char[] mal = {'D', 'C', 'B', 'A', 'E'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            int k = 0;

            for(int j = 0; j < 4; j++){
                int next = sc.nextInt();
                if(next == 1){
                    k++;
                }
            }

            sb.append(mal[k]).append("\n");
        }
        System.out.println(sb);
    }
}
//0 1 0 1
//1 1 1 0
//0 0 1 1
