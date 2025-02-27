
import java.util.Scanner;

public class Main {
    static int N, result;
    static boolean[] col , slash, bSlash;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new boolean[N + 1];
        slash = new boolean[2 * N + 1];
        bSlash = new boolean[2 * N ];

        solve(1);

        System.out.println(result);

    }

    static void solve(int depth){
        // 기저 조건
        if( depth == N +1){
            result++;
            return;
        }

        // 열 한칸씩 내리기
        for(int i = 1; i <= N; i++){
            if(!col[i] && !slash[i + depth] && !bSlash[i - depth  + N]){
                col[i] = slash[i + depth] = bSlash[i - depth + N] = true;
                solve(depth + 1);
                col[i] = slash[i + depth] = bSlash[i - depth + N] = false;
            }

        }
    }

}
