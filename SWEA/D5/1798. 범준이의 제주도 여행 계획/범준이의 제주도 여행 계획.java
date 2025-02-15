
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Solution {
    static int N, M;

    static int[][] map;
    static List<Point> hotels;
    static Point airport;
    static List<Point> points;

    static int maxSatis ;

    static Stack<Integer> tempStack = new Stack<>();
    static List<Integer> bestStack = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            String input = br.readLine();
            String[] split = input.split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);

            maxSatis = Integer.MIN_VALUE;
            map = new int[N + 1][N + 1];
            for (int r = 1; r < N; r++) {
                input = br.readLine();
                split = input.split(" ");
                int cnt = 0;
                for (int c = r + 1; c < N + 1; c++) {
                    map[r][c] = map[c][r] =  Integer.parseInt(split[cnt]);
                    cnt++;
                }
            }


            hotels = new ArrayList<>();
            points = new ArrayList<>();
            for(int i = 1; i <= N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                if(type.equals("A")){
                    airport = new Point(type, i);
                }else if(type.equals("H")){
                    hotels.add(new Point(type, i));
                }else
                    points.add(new Point(type, st.nextToken(), st.nextToken(), i));
            }

            // point 들 돌면서 near Hotel 찾기 check 완료
            for(Point point : points){
                int minTime = Integer.MAX_VALUE;
                for(Point hotel : hotels){
                    if(minTime > map[point.idx][hotel.idx]){
                        point.nearHotel = hotel;
                        minTime = map[point.idx][hotel.idx];
//                        System.out.println("here");
                    }
                }
            }

            sol(0, airport, 0, 0, new boolean[N + 1], 0);

            sb.append("#").append(t).append(" ");
            if(maxSatis == Integer.MIN_VALUE){
                sb.append("0");
            }else{
                sb.append(maxSatis).append(" ");

                for(int x : bestStack){
                    sb.append(x).append(" ");
                }
            }



            sb.append("\n");



        }

        System.out.println(sb.toString());

    }

    private static void sol(int day, Point start, int satis, int time, boolean[] visited, int visitedCount){
        // 기저 조건
        if(day == M || visitedCount == points.size()){
            if(maxSatis < satis){
                maxSatis = satis;
                bestStack = new ArrayList<>(tempStack);
            }
            return;

        }

        boolean canNext = false;
        for(int i = 0; i < points.size(); i++){
            Point tour = points.get(i);

            if(!visited[tour.idx]){
                int tempTime = 0;
                if(M - 1 == day){ // 마지막 날엔 공항에 가야해요
                    tempTime = time + map[start.idx][tour.idx] + tour.playTime + map[tour.idx][airport.idx];
                }else{ // 마지막 날이 아니면 호텔로 가야 해요
                    tempTime = time + map[start.idx][tour.idx] + tour.playTime + map[tour.idx][tour.nearHotel.idx];
                }

                if(tempTime > 540)
                    continue;

                canNext = true;
                visited[tour.idx] = true;
                int tourTime = time + map[start.idx][tour.idx] + tour.playTime;
                tempStack.push(tour.idx);
                sol(day, tour, satis + tour.satis, tourTime, visited, visitedCount + 1);
                tempStack.pop();
                visited[tour.idx] = false;
            }

        }

        if(!canNext){ // 위에선
            if(day == M - 1){ // 마지막날엔 공항에 가야지
                tempStack.push(airport.idx);
                sol(day + 1, airport, satis, 0, visited,  visitedCount);
                tempStack.pop();
            }else{
                // hotel로 가야지
                for(Point hotel : hotels){
                    if(time + map[start.idx][hotel.idx] < 540){
                        tempStack.push(hotel.idx);
                        sol(day + 1, hotel, satis, 0, visited, visitedCount);
                        tempStack.pop();
                    }

                }
            }

        }

    }
    static void printMap(){
        for(int i = 0; i < N + 1; i++){
            for(int j = 0; j < N + 1 ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Point{
        String type;
        int playTime, satis, idx;
        Point nearHotel;

        public Point(String type, int idx) {
            this.type = type;
            this.idx = idx;
        }

        public Point(String type, String playTime, String satis, int idx) {
            this.type = type;
            this.playTime = Integer.parseInt(playTime);
            this.satis = Integer.parseInt(satis);
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "type='" + type + '\'' +
                    ", playTime=" + playTime +
                    ", satis=" + satis +
                    ", idx=" + idx +
                    ", nearHotel=" + nearHotel +
                    '}';
        }
    }
}

//1
//10 3
//60 90 100 110 240 40 30 60 30
//60 120 140 200 120 100 60 60
//90 110 170 100 100 30 90
//50 110 40 80 90 90
//70 30 50 90 90
//100 140 180 120
//40 90 40
//100 20
//70
//A
//P 240 6
//P 120 4
//P 240 5
//P 60 4
//P 200 6
//P 180 1
//P 180 1
//H
//H
