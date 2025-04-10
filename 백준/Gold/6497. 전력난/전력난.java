import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int[] parents;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0)
				break;
			
			
			
			long originSum = 0;
			for(int i = 0; i < M; i++) {
				
					st = new StringTokenizer(br.readLine(), " ");
					int from = Integer.parseInt(st.nextToken());
					int to = Integer.parseInt(st.nextToken());
					int weight = Integer.parseInt(st.nextToken());
					originSum += weight;
					pq.offer(new Edge(from, to, weight));
					
				
			}
			
			// makeSet
			makeSet();
			
			int cnt = 0;
			long result = 0;
			while(true) {
				
				Edge edge = pq.poll();
				if(edge == null)
					break;
				
				if(union(edge.from, edge.to)) {

					result += edge.weight;
					
					
					if(++cnt == N - 1) {
						break;
					}
				}
				
			}
			
			sb.append(originSum - result).append("\n");
			
		}
		
		
		
		System.out.println(sb);
		
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
		
	}

}
