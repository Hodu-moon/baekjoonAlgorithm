

import java.util.*;

public class Solution {
    static int N;
    static  int T;
    static int[] arr;

    static int[] temp;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            N = sc.nextInt();
            arr = new int[N];
            temp = new int[N];
            visited = new boolean[N];
            result = 0;

            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            back(0);

            System.out.println( "#" + t + " "+ result);

        }
    }
    static void back(int depth){ // 순열 뽑기
        // 기저조건
        if(depth == N){
            scale(0, 0, 0);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                temp[depth] = arr[i];
                back(depth + 1);
                visited[i] =false;
            }
        }
    }

    static void scale(int depth, int left, int right){
        // 기저조건
        if(left < right){
            return;
        }
        if(depth == N){
            result++;
            return;
        }

        scale(depth + 1, left  + temp[depth], right); // 왼쪽에 하나 올리는거
        scale(depth + 1, left, right + temp[depth]);

    }
}

//
//3
// 3
//        1 2 4
//        3
//        1 2 3
//        9
//        1 2 3 5 6 4 7 8 9