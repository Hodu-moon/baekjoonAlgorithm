import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= N; i++) {
			int weight = Integer.parseInt(br.readLine());
			pq.offer(new Edge(0, i, weight));
			
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				int no = Integer.parseInt(st.nextToken());
				
				if(i == j)
					continue;
				
				pq.offer(new Edge(i, j, no));
			}
		}
		
		int cnt = 0;
		int result= 0;
		
		makeSet();
		
		while(true) {
			
			Edge current = pq.poll();
			
			if(current == null) {
				break;
			}
			
			if(union(current.from, current.to)) {
				
				result += current.weight;
				
				if(++cnt == N)
					break;
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
	
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		
		return parents[a] = find(parents[a]);
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
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	

}
