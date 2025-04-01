
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception{
        // V , E
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<List<Vertex>> edgeList = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            edgeList.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.get(from).add(new Vertex(to, weight));
        }

        int[] distance = new int[V+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Vertex > pq = new PriorityQueue<>();
        pq.offer(new Vertex(start, 0));

        boolean[] visited = new boolean[V+1];
        // 1. pq

        while(!pq.isEmpty()){
            Vertex current =  pq.poll();

            if(visited[current.no])
                continue;

            visited[current.no] = true;
            distance[current.no] = current.weight;


            for(Vertex vertex : edgeList.get(current.no)){

                if(visited[vertex.no])
                    continue;

                if(distance[vertex.no] > distance[current.no] + vertex.weight){
                    distance[vertex.no] = distance[current.no] + vertex.weight;

                    pq.offer(new Vertex(vertex.no, distance[vertex.no]));
                }

            }


        }
        for (int i = 1; i <= V; i++){
            System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
        }



    }

    static class Vertex implements Comparable<Vertex>{
        int no, weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(weight, o.weight);
        }
    }
}

//5 6
//1
//5 1 1
//1 2 2
//1 3 3
//2 3 4
//2 4 5
//3 4 6