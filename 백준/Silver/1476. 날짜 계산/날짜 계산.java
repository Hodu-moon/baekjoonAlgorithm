
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int E, S, M;
        E = scanner.nextInt();
        S = scanner.nextInt();
        M = scanner.nextInt();

        calculate(E, S, M);
    }

    public static void calculate(int E, int S, int M){
            // E : 1 ~ 15 | S : 1 ~ 28 | : M : 1 ~ 19
        for(int i = 0; i <= 7980/15; i++){
            for(int j = 0; j <= 7980/28;j++){
                for(int k = 0; k <= 7980/19;k++){
                    if(i*15+E == j*28+S && j*28+S == k*19+M){
                        System.out.println(i*15+E);
                        return;
                    }
                }
            }
        }



    }
}

