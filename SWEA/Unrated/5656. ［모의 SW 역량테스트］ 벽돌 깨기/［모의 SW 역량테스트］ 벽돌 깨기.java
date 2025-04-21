
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.*;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int EMPTY = 0;

    static int[][] copyMap;

    static void setCopyMap(){
        copyMap = new int[X][Y];
        for(int i = 0; i < X; i++){
            for(int j = 0; j < Y; j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }

    static boolean isIn(int x, int y){
        return 0 <= x && x < X && 0 <= y && y < Y;
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bombBlock(){

        for(int colIndex : marbleArray){
            int rowIndex = 0;

            for(; rowIndex < X; rowIndex++){

                if(copyMap[rowIndex][colIndex] != EMPTY){
                    break;
                }
            }

            // rowIndex == X 즉 높이와 같다면 다음거 하면 된다.
            if(rowIndex == X){
                continue;
            }

            Queue<Block> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[X][Y];
            queue.offer(new Block(rowIndex, colIndex, copyMap[rowIndex][colIndex]));
            copyMap[rowIndex][colIndex] = 0;
            visited[rowIndex][colIndex] = true;

            while(!queue.isEmpty()){

                Block current = queue.poll();

                for(int i = 0; i < 4; i++){
                    int distance = current.distance;
                    for(int l = 1; l < distance; l++){
                        int nx = current.x + dx[i] * l;
                        int ny = current.y + dy[i] * l;

                        if(!isIn(nx, ny))
                            continue;

                        if(copyMap[nx][ny] == EMPTY)
                            continue;

                        queue.offer(new Block(nx, ny, copyMap[nx][ny]));
                        copyMap[nx][ny] = 0;

                    }


                }


            }

            downBlock();

        }

    }

    static void downBlock(){
        for(int j = 0; j < Y; j++){
            Queue<Integer> queue = new ArrayDeque<>();

            for(int i = X - 1; i >= 0; i-- ){
                if(copyMap[i][j] != EMPTY){
                    queue.offer(copyMap[i][j]);
                    copyMap[i][j] =0;
                }
            }

            for(int i = X - 1; i >= 0; i--){
                if(queue.isEmpty()){
                    break;
                }

                copyMap[i][j] = queue.poll();
            }
        }


    }


    static void permutation(int depth){
        if(depth == marbleCount){
            // 여기서 처리
            // map -> copyMap
            setCopyMap();

            bombBlock();

            countBlock();



            return;
        }

        for(int i = 0; i < Y; i++){
            marbleArray[depth] =  i;
            permutation(depth + 1);
        }

    }

    static void countBlock(){
        int count = 0;
        for(int i = 0; i < X; i++){
            for(int j = 0; j < Y ; j++){
                if(copyMap[i][j] != EMPTY)
                    count++;
            }
        }

        maxBlockCount = Math.min(maxBlockCount, count);

    }


    static class Block{
        int x, y, distance;

        public Block(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){

            // 입력 받기
            inputTestCase();

            // 중복 순열
            permutation(0);


            sb.append("#").append(t).append(" ").append(maxBlockCount).append("\n");
        }

        System.out.println(sb);
    }


    static long maxBlockCount;
    static int X, Y, marbleCount;
    static int[][] map;
    static int[] marbleArray;
    static void inputTestCase() throws Exception{
        st = new StringTokenizer(br.readLine().trim());
        // X -> H , Y -> W
        // N W H
        marbleCount = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new int[X][Y];
        maxBlockCount = Long.MAX_VALUE;

        marbleArray = new int[marbleCount];

        for(int i = 0; i < X; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < Y; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }



}
