
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] array= new int[N + 1];

        for(int i = 1; i <= N; i++){
            array[i] = sc.nextInt();
        }

        int K = sc.nextInt();
        for(int i = 0; i < K; i++){
            int gender = sc.nextInt();
            int num = sc.nextInt();

            int j= 1;
            if(gender == 1){
                // N까지 접근 가능
                while(num * j <= N){
                    array[num * j]  = array[num * j] ^ 1;
                    j++;
                }
            } else{
                // num == 1
                // num -1 num + 1;
                int start = num - 1;
                int end = num + 1;

                while(start >= 1 && end <= N){
                    if(array[start] != array[end]){
                        break;
                    }
                    start--;
                    end++;
                }

                start ++;
                end--;

                for(int k = start; k <= end; k++){
                    array[k] ^= 1;
                }

            }
        }


        for(int i = 1; i <= N; i++){
            System.out.print(array[i] + " ");
            if(i % 20 == 0){
                System.out.println();
            }
        }

    }
}
