
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static long result;

    static int[] parents;

    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                long weight =  Long.parseLong(st.nextToken());
                if(i != j){
                    pq.offer(new Edge(i+1, j+1, weight));
                }
            }
        }




        makeSet();

        int cnt = 0;
        while(true){

            Edge edge = pq.poll();

            if(Objects.isNull(edge))
                break;


            if(union(edge.from, edge.to)){

                result += edge.weight;

                if(++cnt == N - 1){
                    break;
                }

            }




        }

        System.out.println(result);



    }

    static void makeSet(){
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(parents[a] == a)
            return a;

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
            return Long.compare(weight, o.weight);
        }
    }
}

// 3
//0 2 3
//2 0 1
//3 1 0
