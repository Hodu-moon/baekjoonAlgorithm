
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, M, K;
    static long sum;
    static long[] result;
    static List<Colony> colonies;
    static Map<Position, List<Colony>> positionMap;
    static List<Position> samePositions;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;

    // dir 1상 2하 3좌 4우
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            // N M K
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            sum = 0;
            map = new int[N][N];
            result = new long[M + 1];
            colonies = new ArrayList<>();
            colonies.add(new Colony(0, 0, 0, 0)); // 1번부터 K 번까지 쓸거 쓰레기
            makeBorder();


            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                sum += count;

                colonies.add(new Colony(x, y, count, dir));
            }

            result[0] = sum;
            positionMap = new HashMap<>();
            samePositions = new ArrayList<>();

            for(int m = 1; m <= M; m++){
//                System.out.println("!!!!! m = " + m + " !!!!!");
                positionMap.clear();
                samePositions.clear();
                // move
                for(int i = 1; i <= K; i++){
                    Colony colony = colonies.get(i);


                    if(colony.count == 0)
                        continue;

                    move(colonies.get(i));
                }

                merge();

                result[m] = sum;
            }

//            printResult();

            sb.append("#").append(t).append(" ").append(result[M]).append("\n");
        }

        System.out.println(sb);


    }
    static void printResult(){
        System.out.println(Arrays.toString(result));
    }

    static void merge(){
        for(Position position : samePositions){
            List<Colony> colonyList = positionMap.get(position);

//            System.out.println();
//            System.out.println("======= before  merge =======");
//            for(Colony colony1 : colonyList){
//                System.out.println(colony1);
//            }
            long max = 0, sumCount = 0;
            Colony maxColony = null;

            for(Colony colony : colonyList){
                if(max < colony.count){
                    max = colony.count;
                    maxColony = colony;
                }
                sumCount += colony.count;
                colony.count = 0;
            }


            if(maxColony != null)
                maxColony.count = sumCount;
//            System.out.println();
//            System.out.println("======= after  merge =======");
//            for(Colony colony1 : colonyList){
//                System.out.println(colony1);
//            }
        }
    }
    static void move(Colony colony){
        colony.x = colony.x + dx[colony.dir];
        colony.y = colony.y + dy[colony.dir];

        if(isBorder(colony.x, colony.y)){
            long origin = colony.count;
            if(colony.count != 0)
                colony.count /= 2;
            long next = origin - colony.count;
//            System.out.println(origin + " " + next);

            sum -= next;

            // 방향도 바꿔야함  1상 2하 3좌 4우
            if(colony.dir == 1){
                colony.dir = 2;
            }else if(colony.dir == 2){
                colony.dir = 1;
            }else if(colony.dir == 3){
                colony.dir = 4;
            }else if (colony.dir == 4){
                colony.dir = 3;
            }

        }

        Position position = new Position(colony.x, colony.y);


        if(positionMap.containsKey(position)){
            positionMap.get(position).add(colony);
            //list에도 추가
        }else{
            ArrayList<Colony> colonies1 = new ArrayList<>();
            colonies1.add(colony);
            positionMap.put(position, colonies1);
            samePositions.add(position);
        }


    }

    static boolean isBorder(int x, int y){
        return map[x][y] == -1;
    }

    static void makeBorder(){
        for(int i = 0; i < N; i++){
            map[i][0] = -1;
            map[N-1][i] = -1;
            map[0][i] = -1;
            map[i][N-1] = -1;
        }


    }

    static class Colony{
        public int x, y, dir;

        long count;

        public Colony(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Colony{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    ", dir=" + dir +
                    '}';
        }
    }


    static class Position{
        public int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return this.x == ((Position)obj).x && this.y == ((Position)obj).y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y ;
        }
    }
}

//10 5 28
//3 3 796 1
//7 2 798 2
//2 6 622 1
//3 5 179 3
//7 8 888 4
//5 8 634 3
//1 8 646 1
//3 7 433 4
//6 7 416 1
//2 7 651 3
//6 4 476 2
//5 6 712 4
//1 7 869 4
//6 1 789 2
//8 8 585 3
//7 6 426 1
//1 5 154 2
//1 2 692 1
//2 4 549 3
//2 1 60 2
//4 8 996 4
//8 2 437 2
//3 6 195 2
//1 3 734 4
//3 8 355 2
//1 1 945 1
//2 5 558 2
//7 7 144 2

// 10768
// 9709


// 런타임 에러 뜸
// TC는 괜찮은데 문제에서 런타임에러 뜨신분들 미생물이 0이되서 없어질 때 처리 해주세요~
