
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int prefixSum[][] = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j= 1; j <= N; j++){
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i -1][j -1]
                        + sc.nextInt();
            }
        }

//        System.out.println();

//        for(int [] xx : prefixSum){
//            for(int x : xx){
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }

        for(int i = 0; i < M; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            //
            //2 2 3 4

            // ㅁ ㅁ ㅁ ㅁ
            // ㅁ ㅁ ㅁ ㅁ
            // ㅁ ㅁ ㅁ ㅁ
            // ㅁ ㅁ ㅁ ㅁ
            //3 4 3 4 -> 6
            // 3 4 -> 42 - 24 - 27 + 15
            // -36
            System.out.println(
                    prefixSum[x2][y2] - prefixSum[x1 -1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1]
            );
        }
    }
}
//4 3
//1 2 3 4
//2 3 4 5
//3 4 5 6
//4 5 6 7
//2 2 3 4
//3 4 3 4
//1 1 4 4
