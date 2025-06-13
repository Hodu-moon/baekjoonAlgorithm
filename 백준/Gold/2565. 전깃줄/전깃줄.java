
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[501];
        int[] LIS = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
            B[A[i]] = sc.nextInt();
        }

        Arrays.sort(A);

        int max = -1;

        for(int i = 0; i < N; i++){
            LIS[i] = 1;

            for(int j = 0; j < i; j++){

                if(B[A[j]] < B[A[i]] && LIS[i] < LIS[j] + 1){
                    LIS[i] = LIS[j] + 1;
                }
            }

            max = Math.max(max, LIS[i]);
        }

        System.out.println( N - max);

    }
}
//8
//1 8
//3 9
//2 2
//4 1
//6 4
//10 10
//9 7
//7 6
