
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr  = new int[N + 1][N + 1];
            for(int i = 1 ; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] +  sc.nextInt();
                }
            }

//        printArr(arr);

            int result = -1;
            for(int i = M; i <= N; i++){
                for(int j = M; j <= N; j++){
                    int sum = arr[i][j] - arr[i - M][j] - arr[i][j - M] + arr[i - M][j - M];
                    result = Math.max(result, sum);
                }
            }

            System.out.println("#" + t + " " + result);



        }



    }
    static void printArr(int[][] arr){
        for(int[] xx : arr){
            for (int x : xx){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

//5 2
//1 3 3 6 7
//8 13 9 12 8
//4 16 11 12 6
//2 4 1 23 2
//9 13 4 7 3
