
import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static int maxSum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x,y;
        x = scanner.nextInt();
        y = scanner.nextInt();

        matrix = new int[x][y];
        for(int i = 0; i < matrix.length; i++){
            for(int j=0; j < matrix[i].length;j++) {
                int a = scanner.nextInt();
                matrix[i][j] = a;
            }
        }
        case1();
        case2();
        case3();
        case4();
        case5();
        System.out.println(maxSum);

    }
    static void case1(){
        int count;
        // ----
        for(int i = 0; i < matrix.length; i++){
            for(int j=0; j < matrix[i].length - 3;j++) {
                count = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + matrix[i][j+3];
                maxSum = Math.max(maxSum, count);
            }
        }
        // | 이모양..
        for(int i = 0; i < matrix.length-3; i++){
            for(int j=0; j < matrix[i].length;j++) {
                count = matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] + matrix[i+3][j];
                maxSum = Math.max(maxSum, count);
            }
        }
    }

    static void case2(){
        int count;
        for(int i = 0; i < matrix.length-1; i++){
            for(int j=0; j < matrix[i].length-1;j++) {
                count = matrix[i][j] + matrix[i+1][j] + matrix[i][j+1] +matrix[i+1][j+1];
                maxSum = Math.max(maxSum, count);
            }
        }
    }
    static void case3(){
        int count;
        //  x
        //  x
        //  x x
        for(int i = 0; i < matrix.length-2; i++){
            for(int j=0; j < matrix[i].length-1;j++) {
                count = matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] +matrix[i+2][j+1];
                maxSum = Math.max(maxSum, count);
            }
        }
        //  x x
        //  x
        //  x
        for(int i = 0; i < matrix.length-2; i++){
            for(int j=0; j < matrix[i].length-1;j++) {
                count = matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] +matrix[i][j+1];
                maxSum = Math.max(maxSum, count);
            }
        }
        //  x x
        //    x
        //    x
        for(int i = 0; i < matrix.length-2; i++){
            for(int j=0; j < matrix[i].length-1;j++) {
                count = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j+1] +matrix[i+2][j+1];
                maxSum = Math.max(maxSum, count);
            }
        }
        //    x
        //    x
        //  x x
        for(int i = 0; i < matrix.length-2; i++){
            for(int j=0; j < matrix[i].length-1;j++) {
                count = matrix[i][j+1] + matrix[i+1][j+1] + matrix[i+2][j+1] +matrix[i+2][j];
                maxSum = Math.max(maxSum, count);
            }
        }
        // x x x
        // x
        for(int i = 0; i < matrix.length-1; i++){
            for(int j=0; j < matrix[i].length-2;j++) {
                count = matrix[i][j] + matrix[i+1][j] + matrix[i][j+1] +matrix[i][j+2];
                maxSum = Math.max(maxSum, count);
            }
        }
        // x
        // x x x
        for(int i = 0; i < matrix.length-1; i++){
            for(int j=0; j < matrix[i].length-2;j++) {
                count = matrix[i][j] + matrix[i+1][j] + matrix[i+1][j+1] +matrix[i+1][j+2];
                maxSum = Math.max(maxSum, count);
            }
        }
        // x x x
        //     x
        for(int i = 0; i < matrix.length-1; i++){
            for(int j=0; j < matrix[i].length-2;j++) {
                count = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] +matrix[i+1][j+2];
                maxSum = Math.max(maxSum, count);
            }
        }
        //     x
        // x x x
        for(int i = 0; i < matrix.length-1; i++){
            for(int j=0; j < matrix[i].length-2;j++) {
                count = matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j+2] +matrix[i][j+2];
                maxSum = Math.max(maxSum, count);
            }
        }

    }
    static void case4(){
        int count;
        // x
        // x x
        //   x
        for(int i = 0; i < matrix.length-2; i++){
            for(int j=0; j < matrix[i].length-1;j++) {
                count = matrix[i][j] + matrix[i+1][j] + matrix[i+1][j+1] +matrix[i+2][j+1];
                maxSum = Math.max(maxSum, count);
            }
        }
        //   x
        // x x
        // x
        for(int i = 0; i < matrix.length-2; i++){
            for(int j=0; j < matrix[i].length-1;j++) {
                count = matrix[i][j+1] + matrix[i+1][j+1] + matrix[i+1][j] +matrix[i+2][j];
                maxSum = Math.max(maxSum, count);
            }
        }
        //   x x
        // x x
        for(int i = 0; i < matrix.length-1; i++){
            for(int j=0; j < matrix[i].length-2;j++) {
                count = matrix[i+1][j] + matrix[i+1][j+1] + matrix[i][j+1] +matrix[i][j+2];
                maxSum = Math.max(maxSum, count);
            }
        }
        // x x
        //   x x
        for(int i = 0; i < matrix.length-1; i++){
            for(int j=0; j < matrix[i].length-2;j++) {
                count = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j+1] +matrix[i+1][j+2];
                maxSum = Math.max(maxSum, count);
            }
        }
    }
    static void case5(){
        int count;

        for(int i = 0; i < matrix.length-1; i++){
            for(int j=0; j < matrix[i].length-2;j++) {
                // x x x
                //   x
                count = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] +matrix[i+1][j+1];
                maxSum = Math.max(maxSum, count);
                //   x
                // x x x
                count = matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j+2] +matrix[i][j+1];
                maxSum = Math.max(maxSum, count);
            }
        }

        for(int i = 0; i < matrix.length-2; i++){
            for(int j=0; j < matrix[i].length-1;j++) {
                //   x
                // x x
                //   x
                count = matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1] +matrix[i+2][j+1];
                maxSum = Math.max(maxSum, count);
                // x
                // x x
                // x
                count = matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] +matrix[i+1][j+1];
                maxSum = Math.max(maxSum, count);
            }
        }


    }
    static void printMatrix(){
        for(int i = 0; i < matrix.length; i++){
            for(int j=0; j < matrix[i].length;j++) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }

//                5 5
//            1 2 3 4 5
//            5 4 3 2 1
//            2 3 4 5 6
//            6 5 4 3 2
//            1 2 1 2 1
//
 }
