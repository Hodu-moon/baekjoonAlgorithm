
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        
        for(int i = 1; i <= N; i++){
            arr[i] = arr[i - 1] + sc.nextInt(); 
        }


        // printArr(arr);

        for(int i = 0; i < M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(arr[end] - arr[start - 1]);
        }
    }
    
    static void printArr(int[] arr){
        for(int  x : arr){
           System.out.print(x + " ");
        }
    }
}
