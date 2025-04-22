import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, minMoney;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int idx = 1;
		while(true) {
			N = Integer.parseInt(br.readLine().trim());
			if(N == 0) {
				break;
			}
			
			// 1. input
			
			map = new int[N][N];
			minMoney = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 2. solve 다익스트라
			solve();

			sb.append("Problem ").append(idx++).append(": ").append(distances[N-1][N-1]).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static int[][] distances;
	static boolean[][] visited;
	static final int INF = 99999999;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void solve() {
		distances = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				distances[i][j] = INF;
			}
		}
		
		
		PriorityQueue<Position> pq = new PriorityQueue<>();
		pq.offer(new Position(0, 0, map[0][0]));
		distances[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			
			// 1. 미방문 정점 중 출발지에서 가장 가까운 정점 찾기 
			Position current = pq.poll();
//			System.out.println(current);
			
			if(visited[current.x][current.y])
				continue;
			
			visited[current.x][current.y] = true;
			
			if(current.x == N - 1 && current.y == N - 1) {
				break;
			}
			
			
			// 2. 선택된 정점을 경유해서 가는 경로 업데이트
			for(int d = 0; d < 4; d++) {
				int nx = current.x + dx[d];
				int ny = current.y + dy[d];
				
//				System.out.println(nx + " " + ny);
				
				if(!isIn(nx, ny))
					continue;
				
				if(visited[nx][ny])
					continue;
					
				if(distances[nx][ny] > distances[current.x][current.y] + map[nx][ny] ) {
					distances[nx][ny] = distances[current.x][current.y] + map[nx][ny];
					pq.offer(new Position(nx, ny , distances[nx][ny]));
				}
				
				
			}
			
		}
		
		
	}
	
	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	
	
	static class Position implements Comparable<Position>{
		int x, y, weight;

		public Position(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}
		
		
		
	}

}
