
import java.util.Scanner;

public class Solution {
    static int D, W, K;
    static int[][] cells;

    static int minInject;

    static int injectedRowList[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){

            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            cells = new int[D][W];
            minInject = Integer.MAX_VALUE;
            injectedRowList = new int[D];


            for(int i = 0; i < D; i++){
                for(int j = 0; j < W; j++){
                    cells[i][j] = sc.nextInt();
                }
            }
            // check 하고 들어가자
            sb.append("#").append(t).append(" ");
            solve(0, 0);

            sb.append(minInject).append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean check(){
        // 세로로 열 별로 체크해야함
        for(int col = 0; col < W; col++){
            int cnt = 1;
            for (int row = 0; row < D -1; row++){
                int cur = injectedRowList[row] == -1 ? cells[row][col] : injectedRowList[row];
                int next = injectedRowList[row + 1] == -1 ? cells[row + 1][col] : injectedRowList[row + 1];
                if(cur == next){
                    cnt++;

                    if(cnt >= K){
                        // 기준치를 만족했다면 row 이 col은 통과
                        break;
                    }
                }else{
                    cnt = 1;
                }
            }

            if(cnt < K){
                return false;
            }
        }

        return true;
    }

    // dfs
    // -1, 0, 1
    // -1 => 약물 투입 X
    // 0  => A 투입
    // 1  => B 투입
    static void solve(int depth , int inject){
        // depth
        // 가지치기 inject가 minInject를 넘어가면 할 필요가 없음
        if(inject >= minInject){
            return;
        }

        if(depth == D){
            // check 하고 리턴해야함
            if(check()){
                minInject = Math.min(minInject, inject);
            }
            return;
        }

        for(int i = -1; i <=1; i++){
            injectedRowList[depth] = i;
            if(i == -1){
                solve(depth + 1, inject);
            }else{
                solve(depth + 1, inject + 1);
            }
        }

    }
}

//1. 시간제한 : 최대 50개 테스트 케이스를 모두 통과하는데, C/C++/Java 모두 5초
//
//2. 보호 필름의 두께 D는 3이상 13이하의 정수이다. (3≤D≤13)
//
//3. 보호 필름의 가로크기 W는 1이상 20이하의 정수이다. (1≤W≤20)
//
//4. 합격기준 K는 1이상 D이하의 정수이다. (1≤K≤D)

//6 8 3
//0 0 1 0 1 0 0 1
//0 1 0 0 0 1 1 1
//0 1 1 1 0 0 0 0
//1 1 1 1 0 0 0 1
//0 1 1 0 1 0 0 1
//1 0 1 0 1 1 0 1