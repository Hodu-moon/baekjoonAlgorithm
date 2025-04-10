import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	static int[] parents;
	static int N, M, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K ; i++) {
			int no = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(0, no, 0));
		
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			pq.offer(new Edge(from, to, weight));
			
		}
		
		makeSet();
		
		long result = 0;
		int cnt = 0;
		while(true) {
			
			Edge edge = pq.poll();
			
			if(edge == null)
				break;
			
			if(union(edge.from, edge.to)) {
				result += edge.weight;
	
				if(edge.from != 0 && ++cnt == N-1) {
					break;
				}
				
			}
			
		}
		
		
		System.out.println(result);
		
	}

	
	static void makeSet() {
		parents = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA == parentB) {
			return false;
		}
		
		parents[parentB] = parentA;
		
		return true;
	}
	
	static int find(int a) {
		
		if(parents[a] == a) {
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
	
	
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		Edge(int from, int to, int weight){
			this.from =from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
		
	}
}
