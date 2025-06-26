
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, M;
    static int[] parents;
    static Queue<Edge> pq;
    public static void main(String[] args) throws IOException {
        long sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            sum += cost;

//            System.out.println(A + " " + B  +  " " + cost);

            pq.offer(new Edge(A, B, cost));
            pq.offer(new Edge(B, A, cost));

        }

        makeSet();


        long result = 0;
        int cnt = 0;

        while(true){
            Edge edge = pq.poll();

//            System.out.println(edge);
            if(edge == null)
                break;

            if(union(edge.from, edge.to)){
                result += edge.weight;


                if(edge.from != 0 && ++cnt == N-1) {
                    break;
                }
            }
        }

        for(int i = 1; i <=N; i++){
            find(i);
        }


        if(isComplete())
            System.out.println(sum - result);
        else
            System.out.println(-1);
    }

    static boolean isComplete(){
        int a = parents[1];

        for(int i = 2; i <= N; i++){
            if(a != parents[i])
                return false;
        }
        return true;
    }

    // union, find

    //1. makeSet
    static void makeSet(){
        parents = new int[N + 1];
        for(int i = 0; i <= N; i++){
            parents[i] = i;
        }
    }
    // 2. union

    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) {
            return false;
        }

        parents[parentB] = parentA;

        return true;
    }

    // 3. find
    static int find(int a) {

        if(parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }


    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
}
