import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, result;
	static int[][] map;
	static Shark shark;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}

		solve();

		System.out.println(result);
	}

	static void solve() {

		while (true) {
			Queue<Position> queue = new ArrayDeque<>(); // BFS탐색용
			boolean[][] visited = new boolean[N][N];
			List<Position> candidates = new ArrayList<>();
			visited[shark.x][shark.y] = true;
			queue.offer(new Position(shark.x, shark.y, 0));

			int minDistance = Integer.MAX_VALUE;

			while (!queue.isEmpty()) {

				Position current = queue.poll();
				
				// 현재 위치의 distance 가 최소 거리보다 크다면 가치가 없음
				// minDistance 가 2였는데 3을 찾는다면 할 필요 없죠
				if (current.distance > minDistance) {
					break;
				}

				// 물고기 후보에 넣었으면 더이상 BFS 진행하면 안됌
				if (0 < map[current.x][current.y] && map[current.x][current.y] < shark.level) {
					candidates.add(current);
					minDistance = current.distance;
					continue;
				}

				
				
				for (int d = 0; d < 4; d++) {
					int nx = current.x + dx[d];
					int ny = current.y + dy[d];

					if (!isIn(nx, ny) || visited[nx][ny])
						continue;
					
					visited[nx][ny] = true;

					if (map[nx][ny] <= shark.level) {
						
						queue.offer(new Position(nx, ny, current.distance + 1));
					}
				}

			}

					
			if (candidates.isEmpty())
				break;

			candidates.sort((p1, p2) -> {
				if (p1.distance != p2.distance)
					return p1.distance - p2.distance;
				else if (p1.x != p2.x)
					return p1.x - p2.x;
				else
					return p1.y - p2.y;

			});

			Position target = candidates.get(0);

			// 샤크 처리
			if (++shark.totalEat == shark.level) {
				shark.level++;
				shark.totalEat = 0;
			}
			shark.x = target.x;
			shark.y = target.y;

			map[target.x][target.y] = 0;
			// 정답 처리
			result += target.distance;
			
			
//			System.out.println(shark);
//			printMap();
//			System.out.println();

		}
	}

	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	static void printMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == shark.x && j == shark.y) {
					System.out.print("* ");
				}else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Position {
		int x, y, distance;

		public Position(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + ", distance=" + distance + "]";
		}
		
		

	}

	static class Shark {
		int x, y, level, totalEat;

		public Shark(int x, int y, int level, int totalEat) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
			this.totalEat = totalEat;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", level=" + level + ", totalEat=" + totalEat + "]";
		}

		
		
	}

}
