import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Vertex>> edges;
    static List<List<Vertex>> reverseEdges;
    static int N, M, K, resultCity;
    static int[] destinations;
    static boolean[] isDestination;
    static long resultDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        reverseEdges = new ArrayList<>();
        destinations = new int[K];
        resultCity = Integer.MAX_VALUE;
        resultDistance = Integer.MIN_VALUE;

        for(int i = 0; i <= N; i++){
            edges.add(new ArrayList<>());
            reverseEdges.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.get(from).add(new Vertex(to, weight));
            reverseEdges.get(to).add(new Vertex(from, weight));
        }

        // K 받기
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++){
            destinations[i] = Integer.parseInt(st.nextToken());
            // 제일 작은 놈
//            resultCity = Math.min(resultCity, destinations[i]);
//            resultDistance = 0;

            // 인덱스 처리
        }

        solve();


        System.out.println(resultCity);
        System.out.println(resultDistance);


    }

    static void solve(){
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        long[] temp = new long[N + 1];
        Arrays.fill(temp, Long.MAX_VALUE);

        for(int destination : destinations){
            temp[destination] = 0;
            pq.offer(new Vertex(destination, 0));
        }

        int cnt = 0;

        while(!pq.isEmpty()){
            // 1. 최적의 값 선택
            Vertex current = pq.poll();

            if(visited[(int) current.index])
                continue;

            visited[(int) current.index] = true;
            temp[(int) current.index] = current.weight;

//            if(++cnt == N ){
//                break;
//            }


            // 2. 가중치 업데이트
            for(Vertex next : reverseEdges.get((int) current.index)){

                if(visited[(int) next.index])
                    continue;

                if(temp[(int) next.index] > temp[(int) current.index] + next.weight){
                    temp[(int) next.index] = temp[(int) current.index] + next.weight;
                    pq.offer(new Vertex(next.index, temp[(int) next.index]));
                }
            }
        }

//        
//        for (int i = 1; i <= N; i++) {
//        	System.out.print(temp[i] + " ");
//        }
//        
//        System.out.println();
        
        // 거리 비교
        for (int i = 1; i <= N; i++) {
            if( resultDistance < temp[i] ) {
            	resultDistance = temp[i];
            	resultCity = i;
            }
        }


    }

    static class Vertex implements Comparable<Vertex>{
        long index, weight;

        public Vertex(long index2, long temp) {
            this.index = index2;
            this.weight = temp;
        }

        @Override
        public int compareTo(Vertex o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}

//6 10 2
//2 6 2
//1 4 1
//6 1 5
//2 5 1
//5 1 4
//4 5 6
//6 2 3
//3 5 1
//3 1 1
//5 2 2
//1 2