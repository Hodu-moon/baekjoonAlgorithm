
import java.util.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    // W - 바다
    // L - 육지
    // 1. 땅 만나면 너비우선 탐색 조지기
    // 이유 50, 50 임

    static int X, Y;
    static char[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Position> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();

        map = new char[X][Y];
        dp = new int[X][Y];
        sc.nextLine();

        for(int i = 0; i < X; i++){
            String input = sc.nextLine();
            for(int j = 0; j < Y; j++){
                map[i][j] = input.charAt(j);
            }
        }

//        printMap();
        int max = -1;


        for(int i = 0; i < X; i++){
            for(int j= 0; j < Y; j++){
                if(map[i][j] == 'L'){
                    max = Math.max(max, BFS(i, j));
                }
            }
        }

        System.out.println(max);
    }

    static int BFS(int x, int y){
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(x, y));
        boolean[][] visited = new boolean[X][Y];
        visited[x][y] = true;

        int cnt = -1;

        while(!queue.isEmpty()){

            int size = queue.size();
            cnt++;

            for(int i = 0; i < size; i++){
                Position current = queue.poll();
//                -> 여기서 visited 처리를 해버리면 넣은거 또 넣고 또 넣고
//                visited[current.x][current.y] = true;

                for(int d = 0; d < 4; d++){
                    int nx = current.x + dx[d];
                    int ny = current.y + dy[d];

                    if(!isIn(nx, ny) || visited[nx][ny])
                        continue;

                    if(map[nx][ny] == 'L') {
//                        if(dp[nx][ny] < cnt + 1)
//                            continue;
                        queue.offer(new Position(nx, ny));
                        visited[nx][ny] = true;
                    }
                }


            }

        }


//        System.out.println(x + " " + y + "  : " + cnt);
        return cnt ;
    }

    static class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static void printMap(){
        for(char[] xx : map){
            for(char x : xx){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    static boolean isIn(int x, int y){
        return 0 <= x && x < X && 0 <= y && y < Y;
    }
}
//5 7
//WLLWWWL
//LLLWLLL
//LWLWLWW
//LWLWLLL
//WLLWLWW
