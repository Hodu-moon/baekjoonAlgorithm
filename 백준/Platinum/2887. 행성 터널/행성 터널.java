
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static long result;
    static int[] parents;
    static List<Planet> planets = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets.add(new Planet(i, x, y, z));
        }

        makeSet();

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // A
        planets.sort((o1, o2) -> {
            return Integer.compare(o1.x, o2.x);
        });

        for(int i = 0; i < N -1; i++){
            pq.offer(new Edge(
                planets.get(i).no,
                planets.get(i + 1).no,
                Math.abs(planets.get(i).x  - planets.get(i + 1).x)
            ));
        }



        // B
        planets.sort((o1, o2) -> {
            return Integer.compare(o1.y, o2.y);
        });
        for(int i = 0; i < N -1; i++){
            pq.offer(new Edge(
                    planets.get(i).no,
                    planets.get(i + 1).no,
                    Math.abs(planets.get(i).y  - planets.get(i + 1).y)
            ));
        }


        // A
        planets.sort((o1, o2) -> {
            return Integer.compare(o1.z, o2.z);
        });

        for(int i = 0; i < N -1; i++){
            pq.offer(new Edge(
                    planets.get(i).no,
                    planets.get(i + 1).no,
                    Math.abs(planets.get(i).z  - planets.get(i + 1).z)
            ));
        }


        int cnt = 0;
        boolean[] visited = new boolean[N];

        while (true){
            Edge edge = pq.poll();

            if(edge == null){
                break;
            }

            if(union(edge.from, edge.to)){
                result += edge.weight;

                if(++cnt == N -1){
                    break;
                }
            }

        }
        System.out.println(result);

    }

    static void makeSet(){
        parents = new int[N+1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(parents[a] == a){
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
        long weight;

        public Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    static class Planet{
        int no, x, y, z;

        public Planet(int no, int x, int y, int z) {
            this.no = no;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
