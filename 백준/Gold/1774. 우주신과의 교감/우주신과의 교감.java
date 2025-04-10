
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Position> positions;
    static int[] parents;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        positions = new ArrayList<>();

        makeSet();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            positions.add(new Position(x, y));
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0; i < positions.size(); i++){
            for(int j = i +1; j< positions.size() ; j++){

                double weight = Math.sqrt(
                        Math.pow(positions.get(i).x - positions.get(j).x, 2) +
                                Math.pow(positions.get(i).y - positions.get(j).y , 2)
                );

                pq.offer(new Edge(i + 1, j + 1 ,weight));
            }
        }


        int cnt = 0;
        double result = 0;

        while(!pq.isEmpty()){

            Edge edge = pq.poll();

            if(union(edge.from, edge.to)){
                result += edge.weight;

                if(++cnt == N - 1)
                    break;
            }


        }

        System.out.printf("%.2f\n", result);

    }


    static void makeSet(){
        parents = new int[N + 1];

        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(a == parents[a]){
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB){
            return false;
        }

        parents[parentB] = parentA;

        return true;
    }

    static class Edge implements Comparable<Edge>{
        int from, to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(weight, o.weight);
        }
    }
    static class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

//4 1
//1 1
//3 1
//2 3
//4 3
//1 4