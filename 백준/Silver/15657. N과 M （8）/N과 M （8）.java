

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;

    static int[] resultArr;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        resultArr = new int[M];
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        back(0, 0);
        System.out.println(sb.toString());
    }
    static void back(int depth, int start){
        if(depth == M){
            for(int x : resultArr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            resultArr[depth] = arr[i];
            back(depth + 1, i );
        }

    }
}

//1 1
//1 7
//1 8
//1 9
//7 7
//7 8
//7 9
//8 8
//8 9
//9 9




