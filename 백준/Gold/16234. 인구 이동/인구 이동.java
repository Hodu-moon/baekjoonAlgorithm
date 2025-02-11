import java.util.*;

public class Main {

    static int N, L, R;
    static int[][]arr;
    static boolean[][] visited;
    // 상 하 좌 우우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int day = 0;
    static int BFScount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        arr = new int[N][N];
        for(int i = 0; i < N;i++){
            for(int j =0; j < N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        // 인구 이동 한번 

        while(true){
            BFScount = 0;
            visited = new boolean[N][N];

            for(int i = 0; i < N;i++){
                for(int j =0; j < N; j++){
                    if(!visited[i][j]){
                        BFS(i, j);
                    }
                }
            }


           
            if(BFScount == 0){
                break;
            }
            // System.out.println(day);
            // printArr();

            // System.out.println("call day + 1 ");
            day+=1;
            
        }
        

        
        System.out.println(day);


    }

    private static void printArr(){
        System.out.println();
        for(int[] xx : arr){
            for(int x : xx){
                System.out.print(x + " ");
            }

            System.out.println();
        }
        System.out.println();
    }

    private static void BFS(int x, int y){
        List<int[]> federations = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();

        federations.add(new int[]{x, y});

        queue.offer(new int[]{x, y});
        visited[x][y]=true;
        while(!queue.isEmpty()){
            int[] xy = queue.poll();


            for(int i = 0; i < 4; i++){
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if(isIn(nx, ny) && !visited[nx][ny] &&  canMerge(xy[0], xy[1], nx, ny)){
                    BFScount+=1;
                    visited[nx][ny]=true;
                    // System.out.println("day :" + day + " " + nx + " : " + ny);
                    queue.offer(new int[]{nx, ny});
                    federations.add(new int[]{nx, ny});
                }
            }
        }

        // System.out.println("day : " + day + " BFScount : " +  BFScount);
        // for(int[] xy : federations){
        //     System.out.println(xy[0] + " : " + xy[1]);
        // }

        int sum = 0;
        for(int[] xy : federations){
            sum += arr[xy[0]][xy[1]];
        }

        int avg = sum / federations.size();

        for(int[] xy : federations){
            arr[xy[0]][xy[1]] = avg;
        }

    }

    private static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static boolean canMerge(int x, int y, int nx, int ny){
        int a  = arr[x][y];
        int b = arr[nx][ny];

        int diff = Math.abs(a - b);

        return diff >= L && diff <= R ;
    }
}
