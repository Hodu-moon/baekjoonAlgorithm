
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static final int[] dx = new int[]{0, 0, -1, 1};
    static final int[] dy = new int[]{-1, 1, 0, 0};


    static boolean[][] visited;
    static char[][] array;
    static int N;

    static int R;
    static int G;
    static int B;

    static int RG;




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        array = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String s = scanner.next();
            for(int j = 0; j < N; j++){
                array[i][j] = s.charAt(j);
            }
        }


//        RRRBB
//        GGBBB
//        BBBRR
//        BBRRR
//        RRRRR

        // R
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                if(!visited[i][j] && array[i][j] == 'R') {
                    dfs(i, j, new char[]{'R'});
                    R++;
                }
                if(!visited[i][j] && array[i][j] == 'G') {
                    dfs(i, j, new char[]{'G'});
                    G++;
                }

                if(!visited[i][j] && array[i][j] == 'B') {
                    dfs(i, j, new char[]{'B'});
                    B++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i], false);
        }

        // RG
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                if(!visited[i][j] && (array[i][j] == 'R' || array[i][j] == 'G' )) {
                    dfs(i, j, new char[]{'R', 'G'});
                    RG++;
                }

            }
        }

        System.out.print(R + G + B + " ");
        System.out.println(RG + B);



    }

    public static void dfs(int x, int y, char[] c){  // N은 사이즈 char c -> R, G, B 중 한개  ?
        Stack<int[]> stack = new Stack<>();

        stack.add(new int[]{x, y});
        visited[x][y] = true;

        while(!stack.isEmpty()){
            int[] pop = stack.pop();

            for(int i = 0; i < 4; i++){
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];

                if( nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] ){
                    for(char RGB : c){
                        if(array[nx][ny] == RGB){
                            stack.push(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }





    }


}


