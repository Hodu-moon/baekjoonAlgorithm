
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, result;
    static int[][] map;

    static int[] dx = {0, -1, 0 , 1};
    static int[] dy = {1,  0, -1, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[101][101];
        for(int i = 0; i < N; i++){
            int x , y, dir, g;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            solve(y, x, dir, g);



        }

        calc();
        System.out.println(result);


    }

    static void solve(int x, int y, int dir, int g){
        List<Integer> origin = new ArrayList<>();
        origin.add(dir);

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        map[x][y] = 1;
        map[nx][ny] = 1;

        for(int gen = 1; gen <= g; gen++){
            int size = origin.size();

            for(int i = size - 1; i >= 0; i--){

                int d = origin.get(i);
                d = change90(d);

                nx = nx + dx[d];
                ny = ny + dy[d];

                map[nx][ny] =  1;

                origin.add(d);

            }

        }


    }

    static void printMap(){

        System.out.println("############### print Map #############");
        for(int i = 0; i < 10; i++){
            for(int j= 0 ; j < 10; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int change90(int x){
        return (x + 1) % 4;
    }

    static int changeSemetric(int x){
        return (x + 2) % 4;
    }

    static void calc(){
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){

                if(map[i][j] == 1
                && map[i + 1][j] == 1
                && map[i][j+1] == 1
                    && map[i + 1][j + 1] == 1
                    ){
                    result++;
                }
            }
        }
    }
}

//3
//3 3 0 1
//4 2 1 3
//4 2 2 1