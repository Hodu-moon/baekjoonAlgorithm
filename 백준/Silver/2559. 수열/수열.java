
import java.util.Scanner;

public class Main {
    static int N;
    static int K;
    static int[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int max = Integer.MIN_VALUE;

        int[] sumArray = new int[N];
        array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
            // 3일 이라고 잡은거
            if(i >= K - 1){
                for(int j = 0; j < K; j++){
                    sumArray[i] += array[i - j ];
                }

                max = Math.max(sumArray[i], max);
            }

        }

        System.out.println(max);
    }
}
