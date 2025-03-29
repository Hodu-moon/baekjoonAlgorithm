
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int V;
    static double  E;
    static int[] x, y, parents;
    static List<Edge> edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            V = Integer.parseInt(br.readLine());
            x = new int[V];
            y = new int[V];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < V; i++){
                x[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < V; i++){
                y[i] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());

            makeEdge();
            Collections.sort(edges);

            makeSet();

            double result = 0;

            for(Edge edge : edges){
                if(union(edge.from, edge.to)){
                    result += edge.weight;
                }
            }

            sb.append("#").append(t).append(" ").append(Math.round(result)).append("\n");

        }

        System.out.println(sb);

    }

    public static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot ){
            return false;
        }

        parents[bRoot] = aRoot;

        return true;
    }

    public static int find(int a){
        if(parents[a] == a){
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    static  void makeSet(){
        parents = new int[V];
        for(int i = 0; i < V; i++){
            parents[i]= i;
        }
    }

    static void makeEdge(){
        edges = new ArrayList<>();
        for(int i = 0; i < V; i++){
            for(int j = i + 1; j < V; j++){
                double distance = Math.pow(x[i] - x[j] , 2) + Math.pow(y[i] - y[j] , 2);
                edges.add( new Edge(i, j, distance * E ));
            }
        }
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
            return Double.compare(this.weight, o.weight);
        }
    }
}
//2
//0 0
//0 100
//1.0
