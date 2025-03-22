
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int N, M, chickenHouseCount, result;

    static StringBuilder sb = new StringBuilder();
    static List<Position> chickenPositions;
    static List<Position> homePositions;

    static boolean[] visited;
    static int[] tempArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chickenPositions = new ArrayList<>();
        homePositions = new ArrayList<>();

        result = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                int type = Integer.parseInt(st.nextToken());
                if (type == 2){
                    chickenHouseCount++;
                    chickenPositions.add(new Position(i, j, "chicken"));
                }else if(type == 1){
                    homePositions.add(new Position(i, j, "home"));
                }
            }
        }


        // 집마다 chicken distance 구했음
        calcChickenDistance();


        solve();

        System.out.println(result);
    }


    static void solve(){
        // 치킨집이랑 M 크기가 같다면
        if(chickenHouseCount == M){
            int sum = 0;
            for(Position home : homePositions){
                sum += home.chickenDistance;
            }

            result = sum;
        }else{
            // 다르다면 치킨집 수 보다 M 이 적은겨
            // 그렇다면 치킨집 수 에서 M 개를 뽑아야함
            visited =  new boolean[chickenHouseCount];
            tempArr = new int[M];
            combination(0, 0);

        }

    }


    static void combination(int startIdx, int depth){
        // 기저조건
        if(depth == M){
            // 여기서 계산하고 가야함
            // 걍 써버리자

//            for(int i = 0; i < M; i++){
//                System.out.print(tempArr[i] + " ");
//            }
//            System.out.println();

            calcCombinationChickenDistance();
            return;
        }

        for(int i = startIdx; i < chickenHouseCount; i++){

            if(!visited[i]){

                visited[i] = true;
                tempArr[depth] = i;
                combination(i + 1, depth + 1);
                visited[i] = false;
            }

        }


    }

    static void calcCombinationChickenDistance(){
        // tempArr 에 치킨 집 고른거 있음
        // 홈을 돌면서 그 치킨집 까지의 거리를 고를거임
        int sumDistance = 0;

        for(Position home : homePositions){
            int minDistance = Integer.MAX_VALUE;

            for(int chickenIdx : tempArr){
                minDistance = Math.min( minDistance , home.calcChickenDistance(
                        chickenPositions.get(chickenIdx)
                ));

            }

            sumDistance += minDistance;
        }

//        System.out.println("sumDistance : "+sumDistance);

        result = Math.min(result, sumDistance);
    }
    static void calcChickenDistance(){


        for(Position home : homePositions){
            int maxDistance = Integer.MAX_VALUE;
            for(Position chicken : chickenPositions){
                maxDistance = Math.min(maxDistance, home.calcChickenDistance(chicken));
            }

            home.chickenDistance = maxDistance;
        }



    }



    static class Position{
        int x, y, chickenDistance;
        String type;


        public Position(int x, int y, String type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public int calcChickenDistance(Position chicken){
            return Math.abs(this.x - chicken.x ) + Math.abs(this.y - chicken.y);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    ", chickenDistance=" + chickenDistance +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}

//5 3
//0 0 1 0 0
//0 0 2 0 1
//0 1 2 0 0
//0 0 1 0 0
//0 0 0 0 2
