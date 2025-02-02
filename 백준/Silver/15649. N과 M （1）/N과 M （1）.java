
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static boolean [] visited;

    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        visited = new boolean[N];

        back(0);

        System.out.println(sb.toString());
    }

    public static void back(int depth){

        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                back(depth + 1);
                visited[i] = false;
            }
        }
    }

//    public static int back(int start, boolean[] visited,int N, int M){
//
//        for(int i = 0; i < N; i++){
//            visited
//        }
//
//    }
}
 // 4 2
// 1 2
//1 3
//1 4
//2 1
//2 3
//2 4
//3 1
//3 2
//3 4
//4 1
//4 2
//4 3
