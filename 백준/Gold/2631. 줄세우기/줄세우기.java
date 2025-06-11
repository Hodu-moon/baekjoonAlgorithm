
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr, LIS;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        LIS = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int max = -1;

        for(int i = 0; i < N; i++){

            LIS[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1){
                    LIS[i] = LIS[j] + 1;
                }
            }
            max = Math.max(max, LIS[i]);
        }

//        System.out.println("LIS");
//        for(int x : LIS){
//            System.out.print(x + " ");
//        }

        System.out.println(N - max);


    }
}
