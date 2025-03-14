import java.util.*;

public class Main {

	static int K, W, H;
	static int[][] map;
	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[] ddx = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] ddy = { -1, 1, 2, 2, 1, -1, -2, -2 };
	static boolean[][][] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W]; // 5 2 ->
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		visited = new boolean[H][W][K + 1];
		int result = solve();


//		System.out.println(sb.toString());
		System.out.println(result);

	}

	static int solve() {
		Queue<int[]> queue = new ArrayDeque<>();
		// x
		// y
		// count 이동 횟수
		// K횟수
		queue.add(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;
		
		
		
		

		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
//
//			sb.append("=================================================================================").append("\n");
//			printMap();
//			sb.append("=================================================================================").append("\n");


			if (cur[0] == H - 1 && cur[1] == W - 1) {
				return cur[2];
			}

			if (cur[3] < K) {

				// 원숭이 말 가능
				for (int i = 0; i < 4; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];

					if (!isIn(nx, ny))
						continue;

					if (!visited[nx][ny][cur[3]] && map[nx][ny] != 1) {
						visited[nx][ny][cur[3]] = true;
						queue.offer(new int[] { nx, ny, cur[2] + 1, cur[3] });
					}
				}

				// 말처럼 움직이고
				for (int i = 0; i < ddx.length; i++) {
					int nx = cur[0] + ddx[i];
					int ny = cur[1] + ddy[i];

					if (!isIn(nx, ny))
						continue;

					if (!visited[nx][ny][cur[3] + 1] && map[nx][ny] != 1) {
						visited[nx][ny][cur[3] + 1] = true;
						queue.offer(new int[] { nx, ny, cur[2] + 1, cur[3] + 1 });
					}
				}

			} else {
				// 원숭이처럼만 가능
				for (int i = 0; i < 4; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];

					if (!isIn(nx, ny))
						continue;

					if (!visited[nx][ny][cur[3]] && map[nx][ny] != 1) {
						visited[nx][ny][cur[3]] = true;
						queue.offer(new int[] { nx, ny, cur[2] + 1, cur[3] });
					}
				}

			}

		}

		return -1;

	}

	static boolean isIn(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}

	static void printMap() {
		for (int i = 0; i < H; i++) {
			for (int jj = 0; jj < W; jj++) {
				sb.append(String.format("%7s", map[i][jj]));
			}
			for (int k = 0; k <= K; k++) {
				for (int j = 0; j < W; j++) {
					sb.append(String.format("%7s", visited[i][j][k]));
				}
				sb.append("  |  ");
			}
			sb.append("\n");
		}
	}

}

// 1 k 
//4 4 w h
//0 0 0 0
//1 0 0 0
//0 0 1 0
//0 1 0 0