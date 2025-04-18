import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M, R, order;
	static int[] visited;
	static List<List<Integer>> edges;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visited = new int[N+1];
		
		edges = new ArrayList<>();
		
		order =1;
		for(int i = 0; i <= N; i++) {
			edges.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			edges.get(from).add(to);
			edges.get(to).add(from);
			
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(edges.get(i));
		}
		
		dfs(R);

		for(int i =1; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int idx) {
		if(visited[idx] > 0)
			return;
		
		visited[idx] = order++;
		
		for(int next : edges.get(idx)) {
			
			if(visited[next] > 0)
				continue;
			
			dfs(next);
		}
		
		
		
	}
	static class Edge{
		int from, to;
		Edge(int from, int to){
			this.from = from ;
			this.to = to;
			
		}
	}
}
