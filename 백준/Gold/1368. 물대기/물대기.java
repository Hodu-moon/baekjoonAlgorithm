
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, min, result;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            int weight = Integer.parseInt(br.readLine());
            pq.offer(new Edge(0, i, weight ));

        }

        result = 0;

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++){
                int no = Integer.parseInt(st.nextToken());
                if(i != j)
                    pq.offer(new Edge(i, j, no));
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

                if( ++cnt == N + 1 ){
                    break;
                }
            }

        }

        System.out.println( result  );
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
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }


    }
}
//4
//5
//4
//4
//3
//0 2 2 2
//2 0 3 3
//2 3 0 4
//2 3 4 0
