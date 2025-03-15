
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, M, R, C, L, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            result = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            printMap();

            BFS();


            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb);

    }

    static void BFS() {
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(R, C));
        visited[R][C] = true;


        for (int level = 0; level < L; level++) {
            // tree level
//            System.out.println("queue Size" + queue.size() );
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                Position cur = queue.poll();
                result++;

                int currentType = map[cur.x][cur.y];
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];


                    // d -> 상 하 좌 우
                    if (!isIn(nx, ny))
                        continue;

                    if (map[nx][ny] == 0)
                        continue;

                    if (visited[nx][ny]) {
                        continue;
                    }

                    int next = map[nx][ny];
                    if (d == 0) { // 위로 올라갈 때

                        if (
                                (currentType == 1 ||
                                        currentType == 2 ||
                                        currentType == 4 ||
                                        currentType == 7)
                                        && (
                                        next == 1 ||
                                                next == 2 ||
                                                next == 5 ||
                                                next == 6
                                )
                        ) {
                            queue.offer(new Position(nx, ny));
                            visited[nx][ny] = true;
                        }

                    } else if (d == 1) {
                        if ((
                                currentType == 1 ||
                                        currentType == 2 ||
                                        currentType == 5 ||
                                        currentType == 6

                        )
                                &&
                                (next == 1 ||
                                        next == 2 ||
                                        next == 4 ||
                                        next == 7)
                        ) {
                            queue.offer(new Position(nx, ny));
                            visited[nx][ny] = true;
                        }

                    } else if (d == 2) {
                        if (
                                (
                                        currentType == 1 ||
                                                currentType == 3 ||
                                                currentType == 6 ||
                                                currentType == 7
                                        ) && (
                                next == 1 ||
                                        next == 3 ||
                                        next == 4 ||
                                        next == 5
                                )
                        ) {
                            queue.offer(new Position(nx, ny));
                            visited[nx][ny] = true;
                        }

                    } else if (d == 3) {
                        if (
                                (
                                        currentType == 1 ||
                                                currentType == 3 ||
                                                currentType == 4 ||
                                                currentType == 5
                                        )
                                &&(
                                next == 1 ||
                                next == 3 ||
                                next == 6 ||
                                next == 7
                        )
                        ) {
                            queue.offer(new Position(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }


                }

            }
        }


    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void printMap() {
        for (int[] xx : map) {
            System.out.println(Arrays.toString(xx));
        }
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }


}


//          5
//        5 6 2 1 3
//        0 0 5 3 6 0
//        0 0 2 0 2 0
//        3 3 1 3 7 0
//        0 0 0 0 0 0
//        0 0 0 0 0 0


//1
//5 6 2 1 1
//0 0 5 3 6 0
//0 0 2 0 2 0
//3 3 1 3 7 0
//0 0 0 0 0 0
//0 0 0 0 0 0