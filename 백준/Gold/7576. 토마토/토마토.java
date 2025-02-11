import java.util.*;
import java.util.Scanner;

public class Main {
    static int W, H;

    static int[][] arr;
    static boolean[][] visited;
    // 상 하 좌 우 왼위 오위 왼아 오아
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int maxCount = 0;
    static int zeroCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        H = sc.nextInt();

        arr = new int[H][W];

        Queue<int[]> queue = new ArrayDeque<>();

        visited = new boolean[H][W];
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 1)
                    queue.add(new int[]{i, j, 0});
                else if(arr[i][j] == 0){
                    zeroCount++;
                }
            }
        }

        while(!queue.isEmpty()){
            int[]xy = queue.poll();
            visited[xy[0]][xy[1]] = true;
            
            int count = xy[2];

            if(maxCount < count){
                maxCount = count;
            }

            // System.out.println("x :" + xy[0] + " y:" + xy[1] + "count: " + count);
            
            for(int i = 0; i < dx.length; i++){
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if(isIn(nx, ny ) && !visited[nx][ny] && arr[nx][ny] == 0){
                    arr[nx][ny] =  1;
                    zeroCount--;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
            // printArr();
            // System.out.println(maxCount);

        }

        if(zeroCount > 0){
            System.out.println(-1);
        }else
            System.out.println(maxCount);


        
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    public static void printArr(){
        System.out.println();
        for(int x[] : arr){
            for(int xx : x){
                System.out.print(xx + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

//
// 6 4
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 1