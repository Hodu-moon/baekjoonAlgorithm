import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int V, E, result;

    static List<Edge> edges;
    static int[] parents;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        edges = new ArrayList<>();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, weight));
        }

        Collections.sort(edges);
        makeSet();

        solve();

        System.out.println(result);

    }

    static void solve(){
        int cnt = 0;

        for(Edge edge : edges){


            if(union(edge.from, edge.to)){

                if(++cnt == V - 1){
                    return;
                }

                result += edge.weight;

            }

        }


    }

    static void makeSet(){
        parents = new int[V + 1];
        for(int i = 0; i <= V; i++){
            parents[i] = i;
        }
    }

    static boolean union(int a, int b){
        int aParent = find(a);
        int bParent = find(b);

        if(aParent == bParent){
            return false;
        }

        parents[bParent] = aParent;

        return true;
    }

    static int find(int a){
        if(parents[a] == a){
            return a;
        }

        return parents[a] = find(parents[a]);
    }


    static class Edge implements  Comparable<Edge>{
        int from, to , weight;

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

//7 12
//1 2 3
//1 3 2
//3 2 1
//2 5 2
//3 4 4
//7 3 6
//5 1 5
//1 6 2
//6 4 1
//6 5 3
//4 5 3
//6 7 4
