import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	static int V;
	static int[] parents;
	static int[] x;
	static Node[] nodes;
	static double E, result;
	static List<Edge> edgeList;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			V = Integer.parseInt(br.readLine());
			nodes = new Node[V];
			parents = new int[V];
			edgeList = new ArrayList<>();
			x = new int[V];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			// x좌표 
			for(int i = 0; i < V; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i =0; i < V ; i++) {
				int y = Integer.parseInt(st.nextToken());
				nodes[i] = new Node(x[i], y);
			}
			
			E =  Double.parseDouble(br.readLine());
			
			if(E == 0) {
				sb.append("#").append(t).append(" ").append(0).append("\n");
				continue;
			}
			makeEdges();

			make();
			
			Collections.sort(edgeList);
			
			result = 0;
			solve();
			
//			System.out.println(result);
			
			
			sb.append("#").append(t).append(" ").append(Math.round(result)).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void solve() {
		
		int count =0;
		for(Edge edge : edgeList) {
			
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				
				if(++count == V - 1) {
					return;
				}
				
			}
			
		}
		
	}
	
	static void make() {
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	static void makeEdges() {
		for(int i = 0; i < V; i++) {
			for(int j = i + 1; j < V; j++) {
				edgeList.add(new Edge(i, j, getDistance(nodes[i], nodes[j]) * E));
			}
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		
		return true;
	}
	
	
	static double getDistance(Node before, Node next) {
		return Math.pow(before.x - next.x , 2) + Math.pow(before.y - next.y, 2);
	}
	
	
	
	
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;
		
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}
		
		
	}
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}

}
