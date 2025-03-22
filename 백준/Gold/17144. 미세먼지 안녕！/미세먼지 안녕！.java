
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, T, result, cleanerX1, cleanerX2 ;
    static int[][] nextMap;
    static int[][] curMap;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        curMap = new int[R][C];

        int c = 0;

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++){
                curMap[i][j] = Integer.parseInt(st.nextToken());


                if(curMap[i][j] == -1 && c == 0){
                    cleanerX1 = i;
                    cleanerX2 = i + 1;
                    c++;
                }

                result += curMap[i][j];


                if(curMap[i][j] == -1){
                    curMap[i][j] = 0;
                }

            }
        }

        result += 2;

//        System.out.println(result);

//        printCurMap();

        for(int t = 0; t < T; t++){
            solve();
//            printNextMap();
        }

        System.out.println(sum());

    }

    static int sum(){
        int result = 0;
        for(int i = 0; i < R; i++){
            for(int j =0; j < C; j++){
                result += curMap[i][j];
            }
        }

        return result;
    }


    static void solve(){
//        System.out.println("ehre");
        nextMap = new int[R][C];
//        System.out.println("before diffusing");
//        printCurMap();
//        System.out.println(sum());

        diffusing();

//        System.out.println("after diffusing");
        curMap = nextMap;
//        printNextMap();

//        System.out.println("before calc ");
//        printCurMap();
        // curMap으로 계산
        calc();
//        System.out.println("after calc");
//        printCurMap();

    }
    static void calc(){
//        System.out.println(curMap[cleanerX1 - 1][0] +" " + curMap[cleanerX2 +1 ][0]);

        result -= curMap[cleanerX1 - 1][0];
        result -= curMap[cleanerX2 +1 ][0];

        curMap[cleanerX1 -1][0] = 0;
        curMap[cleanerX2 + 1][0] = 0;

        // 윗부분 반시계
        for(int i = cleanerX1 -1; i >= 0; i--){
            curMap[i + 1][0] = curMap[i][0];
        }

        for(int i = 1; i < C; i++){
            curMap[0][i - 1] = curMap[0][i];
        }

        for(int i = 1; i <= cleanerX1; i++ ){
            curMap[i - 1][C - 1] = curMap[i][C - 1];
        }

        for(int i = C -1; i >= 1; i-- ){
            curMap[cleanerX1][i] = curMap[cleanerX1][i - 1];
        }
        // 밑 부분 시계방향

        for(int i = cleanerX2 + 1; i < R ; i++){
            curMap[i - 1][0] = curMap[i][0];
        }

        for(int i = 1; i < C; i++){
            curMap[R - 1][i - 1] = curMap[R - 1][i];
        }

        for(int i = R - 2; i >= cleanerX2; i--){
            curMap[i + 1][C - 1] = curMap[i][C - 1];
        }

        for(int i = C - 2; i >= 0; i--){
            curMap[cleanerX2][i + 1] = curMap[cleanerX2][i];
        }

    }

    static void diffusing(){

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                int diffused = curMap[i][j] / 5;


                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(!isIn(nx, ny)){
                        continue;
                    }

                    if((nx == cleanerX1 && ny == 0) ||
                            (nx == cleanerX2 && ny == 0)){
                        continue;
                    }

                    nextMap[nx][ny] += diffused;
                    curMap[i][j] -= diffused;


                }

                nextMap[i][j] += curMap[i][j];

            }
        }

    }

    static void printCurMap(){
        for(int[] xx : curMap){
            System.out.println(Arrays.toString(xx));
        }
    }
    static void printNextMap(){
        for(int[] xx : nextMap){
            System.out.println(Arrays.toString(xx));
        }
    }

    static boolean isIn(int x, int y){
        return 0 <= x && x < R && 0 <= y && y < C;
    }
}

//7 8 1
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
