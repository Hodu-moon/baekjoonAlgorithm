
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] dx = {-1,1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        List<Position> positionList = new ArrayList<>();

        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'O'){
                    positionList.add(new Position(i , j));
                    visited[i][j] = true;
                }else if(map[i][j] == 'X'){
                    visited[i][j] = true;
                }

            }
        }

        // O 위치
        for(Position position : positionList){

            for(int d = 0; d < 4; d++){
                for(int l = 1; ; l++){
                    int nx = position.x + dx[d] * l;
                    int ny = position.y + dy[d] * l;

                    if(!isIn(nx, ny))
                        break;

                    if(map[nx][ny] == 'O' || map[nx][ny] == 'X'){
                        break;
                    }

                    visited[nx][ny] = true;

                }
            }
        }
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    sb.append('B');
                }else{
                    sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        

    }


    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    static class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}



//5
//...XO
//..XOO
//...XO
//O....
//OXX..