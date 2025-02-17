
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result =0;
        int S = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1 ; i < (1 << N); i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                if((i & (1 << j)) != 0){
                    sum += arr[j];
                }
            }

            if(sum == S){
//                System.out.println(i);
//                System.out.println(sum);
                result++;
            }
        }

        System.out.println(result);

    }
}
