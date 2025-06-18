
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] LIS = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int size = 0;
        for(int i = 0; i < N; i++){
            LIS[i] = 1;
            int target = arr[i];


            int temp = Arrays.binarySearch(LIS, 0, size,  target);

            int pos = Math.abs(temp) - 1;

            if(pos == size)
                size++;

            LIS[pos] = arr[i];

        }

        System.out.println(N - size);

    }
}
//4
//2 3 4 1
