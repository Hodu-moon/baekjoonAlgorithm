import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, result;
	static int[][] map;
	static Shark shark;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j= 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		
		
		solve();
		
		System.out.println(result);

	}
	
	static void solve() {
		
		while(true) {
			boolean[][] visited = new boolean[N][N];
			Queue<Position> queue = new ArrayDeque<>();
			
			Queue<Position> candidates = new PriorityQueue<>();
			queue.offer(new Position(shark.x, shark.y, 0));
			visited[shark.x][shark.y] = true;
			
			int minDistance = Integer.MAX_VALUE;
			
			
			
			
			while(!queue.isEmpty()) {
				
				Position current = queue.poll();
				
				if(current.distance > minDistance) {
					break;
				}
				
				if(0 < map[current.x][current.y] && map[current.x][current.y] < shark.level ) {
					candidates.offer(current);
					minDistance = current.distance;
					continue;
				}
				
				
				for(int i = 0; i < 4; i++) {
					int nx = current.x + dx[i];
					int ny = current.y + dy[i];
					
					if(!isIn(nx, ny) || visited[nx][ny]) {
						continue;
					}
					
					if(map[nx][ny] <= shark.level) {
						visited[nx][ny] = true;
						queue.offer(new Position(nx, ny , current.distance + 1));
					}
					
					
					
				}
				

				
			}
			
			if(candidates.isEmpty())
				break;
			
			Position target = candidates.poll();
			
			map[target.x][target.y] = 0;
			
			if(++shark.totalEat == shark.level) {
				shark.totalEat = 0;
				shark.level++;
			}
			
			result += target.distance;
		
			shark.x = target.x;
			shark.y = target.y;
			
			
//			printMap();
			
		}
		
	}
	
	static void printMap() {
		for(int i = 0; i < N; i++) {
			for(int j =0; j < N ;j++) {
				if(i == shark.x && j == shark.y) {
					System.out.print("* ");
				}else {
					System.out.print(map[i][j] + " ");

				}
			}
			System.out.println();
		}
	}
	
	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	static class Position implements Comparable<Position>{
		int x, y, distance;

		public Position(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			if(distance != o.distance)
				return distance - o.distance;
			else if(x != o.x) {
				return this.x - o.x ;
			}else {
				return this.y - o.y ;
			}
		}
		
		
	}
	
	static class Shark{
		int x, y, level, totalEat;

		public Shark(int x, int y, int level, int totalEat) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
			this.totalEat = totalEat;
		}
		
	}
}
