
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int R;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        for(int i = 0; i < R; i++){
            rotateArr();
        }
//        rotateArr();

        printArr();

    }

    static void rotateArr() {

        int left = 0;
        int right = M - 1;
        int top = 0;
        int bottom = N - 1;

        int c = Math.min(N, M) / 2;

        for(int i = 0; i < c; i++){
            int temp = arr[i][i];

//            System.out.println("first");
//            printArr();
            for(int j = left; j < right ; j++){
                arr[top][j] = arr[top][j + 1];
            }
            top++;
//            System.out.println("after 1");

//            printArr();

            for(int j = top; j <= bottom; j++){
                arr[j - 1][right] = arr[j][right];
            }
            right--;
//            System.out.println("after 2");

//            printArr();

            for(int j = right; j >= left; j--){
                arr[bottom][j+1] = arr[bottom][j];
            }
            bottom--;
//            System.out.println("after 3");

//            printArr();

            for(int j = bottom; j >= top; j--){
                arr[j +1][left] = arr[j][left];
            }
            left++;

//            System.out.println("after 4");
//            printArr();


            arr[i+1][i] = temp;
        }


    }

    static void printArr() {
//        System.out.println("----- start print arr----- ");
        for (int[] aa : arr) {
            for (int a : aa) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
//        System.out.println("----- end print arr----- ");

    }
}
//4 4 2
//1 2 3 4
//5 6 7 8
//9 10 11 12
//13 14 15 16

/**


 // input
 4 4 2
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16
 = 2
 5 4 7
 1 2 3 4
 7 8 9 10
 13 14 15 16
 19 20 21 22
 25 26 27 28
 =3
 2 2 3
 1 1
 1 1
 =4
 2 2 3
 1 2
 3 4
 =5
 5 2 5
 2 2
 1 3
 1 3
 1 3
 4 4
 = 6
 2 4 3
 1 2 3 4
 5 6 7 8
 =
 4 2 3
 1 2
 3 4
 5 6
 7 8
 =
 9 4 7
 1 1 1 1
 2 2 2 2
 3 3 3 3
 4 4 4 4
 5 5 5 5
 6 6 6 6
 7 7 7 7
 8 8 8 8
 9 9 9 9
 =
 5 4 6
 1 1 1 1
 2 2 2 2
 3 3 3 3
 4 4 4 4
 5 5 5 5
 =
 4 9 7
 1 2 3 4 5 6 7 8 9
 1 2 3 4 5 6 7 8 9
 1 2 3 4 5 6 7 8 9
 1 2 3 4 5 6 7 8 9
 =
 6 9 7
 1 2 3 4 5 6 7 8 9
 1 2 3 4 5 6 7 8 9
 1 2 3 4 5 6 7 8 9
 1 2 3 4 5 6 7 8 9
 1 2 3 4 5 6 7 8 9
 1 2 3 4 5 6 7 8 9

 // output
 1)
 3 4 8 12
 2 11 10 16
 1 7 6 15
 5 9 13 14

 2)
 28 27 26 25
 22 9 15 19
 16 8 21 13
 10 14 20 7
 4 3 2 1

 3)
 1 1
 1 1

 4)
 3 1
 4 2

 5)
 4 4
 3 1
 3 1
 3 1
 2 2

 6)
 4 8 7 6
 3 2 1 5

 7)
 6 8
 4 7
 2 5
 1 3

 8)
 5 6 7 8
 4 8 8 9
 3 7 7 9
 2 6 6 9
 1 5 5 9
 1 4 4 8
 1 3 3 7
 1 2 2 6
 2 3 4 5

 9)
 4 5 5 5
 3 2 2 5
 2 3 3 4
 1 4 4 3
 1 1 1 2

 10)
 8 9 9 9 9 8 7 6 5
 7 8 7 6 5 4 3 2 4
 6 8 7 6 5 4 3 2 3
 5 4 3 2 1 1 1 1 2

 11)
 8 9 9 9 9 9 9 8 7
 7 8 8 8 7 6 5 4 6
 6 8 5 4 3 3 4 3 5
 5 7 6 7 7 6 5 2 4
 4 6 5 4 3 2 2 2 3
 3 2 1 1 1 1 1 1 2
 */
