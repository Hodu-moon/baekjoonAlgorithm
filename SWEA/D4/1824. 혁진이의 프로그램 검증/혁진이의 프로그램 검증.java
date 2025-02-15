
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int R, C;
    static char[][] arr;

    // 상 하 좌 우
    static int[] dx = {-1 , 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean canEnd ;
    static boolean[][][][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            String input;
            String split[];
            input = br.readLine();
            split = input.split(" ");
            R = Integer.parseInt(split[0]);
            C = Integer.parseInt(split[1]);


            arr = new char[R][C];
            visited = new boolean[R][C][4][16];

//            System.out.println(R + " : " + C);

            canEnd = false;
            for(int i = 0; i < R; i++){
                input = br.readLine();
                for(int j = 0; j < C; j++){
                    arr[i][j] = input.charAt(j);

//                    if(arr[i][j] == '@')
//                        canEnd = true;
                }
            }

//            printArr();

//            if(!canEnd){
//                System.out.println("NO");
//                continue;
//            }

            BFS();

            if(!canEnd){
                System.out.println("#" +  (t+1)+ " NO");
            }else {
                System.out.println("#" +  (t+1)+ " YES");
            }

        }


    }

    static void BFS(){
        Queue<int[]> queue = new ArrayDeque<>();
        int firstMem = 0;
        if('0' <= arr[0][0] && arr[0][0] <= '9'){
            firstMem = arr[0][0] - '0';
        }
        // x, y, dir, mem

        queue.offer(new int[]{0, 0, 3, firstMem });
        // TODO visited
//        visited[0][0][3][firstMem] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            int mem = cur[3];

            if(arr[x][y] == '@'){
                canEnd = true;
                return;
            }


            if(visited[x][y][dir][mem])
                continue;

            visited[x][y][dir][mem] = true;

            if(arr[x][y] == '?'){
                for(int i = 0; i < 4; i++){
                    int nx = (x + dx[i] + R) % R;
                    int ny = (y + dy[i] + C) % C;
                    // TODO visited

                    queue.offer(new int[]{nx, ny, i, mem});

                }
            }else if(arr[x][y] == '>'){
                dir = 3;
            }else if(arr[x][y] == '<'){
                dir = 2;
            }else if(arr[x][y] == '^'){
                dir = 0;
            }else if(arr[x][y] == 'v'){
                dir = 1;
            }else if(arr[x][y] == '_'){
                if(mem == 0){
                    dir = 3;
                }else {
                    dir = 2;
                }
            }else if(arr[x][y] == '|'){
                if (mem == 0){
                    dir = 1;
                }else {
                    dir = 0;
                }
            }else if('0' <=arr[x][y]  && arr[x][y] <= '9'){
                mem = arr[x][y] - '0';
            }else if(arr[x][y] == '+'){
                mem = (mem + 1) % 16;
            }else if(arr[x][y] == '-'){
                mem = (mem - 1 + 16) % 16;
            }


            // TODO visited check
            int nx = (x + dx[dir] + R) % R;
            int ny = (y + dy[dir] + C) % C;


            queue.offer(new int[]{nx, ny, dir, mem});


        }





    }
    static void printArr(){
        System.out.println();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//3
//2 6
//6>--v.
//.^--_@

//<	이동 방향을 왼쪽으로 바꾼다.
//>	이동 방향을 오른쪽으로 바꾼다.
//^	이동 방향을 위쪽으로 바꾼다.
//v	이동 방향을 아래쪽으로 바꾼다.
//_	메모리에 0이 저장되어 있으면 이동 방향을 오른쪽으로 바꾸고, 아니면 왼쪽으로 바꾼다.
//|	메모리에 0이 저장되어 있으면 이동 방향을 아래쪽으로 바꾸고, 아니면 위쪽으로 바꾼다.
//?	이동 방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네 방향 동일하다.
//.	아무 것도 하지 않는다.
//@	프로그램의 실행을 정지한다.
//0~9	메모리에 문자가 나타내는 값을 저장한다.
//+	메모리에 저장된 값에 1을 더한다. 만약 더하기 전 값이 15이라면 0으로 바꾼다.
//-	메모리에 저장된 값에 1을 뺀다. 만약 빼기 전 값이 0이라면 15로 바꾼다.