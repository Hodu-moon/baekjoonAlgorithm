
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M, K, result;
	static int[][] map;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };
	static Shark[] sharks;
	static boolean[] isDied;
	static Position[][] posMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sharks = new Shark[M + 1];
		isDied = new boolean[M + 1];
		result = -1;
		map = new int[N][N];
		posMap = new Position[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int idx = Integer.parseInt(st.nextToken());
				if (idx > 0) {
					posMap[i][j] = new Position(i, j, idx, K);
					sharks[idx] = new Shark(i, j, idx);
				}
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++) {
			sharks[i].setDir(Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i <= M; i++) {
			for (int dir = 1; dir <= 4; dir++) {
				st = new StringTokenizer(br.readLine(), " ");
				int[] temp = new int[4];
				for (int to = 0; to < 4; to++) {
					temp[to] = Integer.parseInt(st.nextToken());
				}
				sharks[i].setPriorityDir(dir, temp);
			}
		}

		solve();
		System.out.println(result);
	}

	static void solve() {
		int time = 0, dieCount = 0;

		while (time++ < 1000) {
			List<Integer> nonMovedShark = new ArrayList<>();
			Map<Position, PriorityQueue<Position>> samePosition = new HashMap<>();
			List<Position> positions = new ArrayList<>();
			Set<Position> current = new HashSet<>();

			for (int i = 1; i <= M; i++) {
				if (isDied[i]) continue;
				Shark shark = sharks[i];
				boolean flag = false;

				for (int d = 0; d < 4; d++) {
					int nDir = shark.priorityDir[shark.dir][d];
					int nx = shark.x + dx[nDir];
					int ny = shark.y + dy[nDir];
					if (!isIn(nx, ny) || posMap[nx][ny] != null) continue;

					Position pos = new Position(nx, ny, i, K);
					samePosition.computeIfAbsent(pos, k -> new PriorityQueue<>()).add(pos);
					positions.add(pos);
					shark.dir = nDir;
					shark.x = nx;
					shark.y = ny;
					flag = true;
					break;
				}

				if (!flag) nonMovedShark.add(i);
			}

			for (int idx : nonMovedShark) {
				if (isDied[idx]) continue;
				Shark shark = sharks[idx];

				for (int i = 0; i < 4; i++) {
					int nDir = shark.priorityDir[shark.dir][i];
					int nx = shark.x + dx[nDir];
					int ny = shark.y + dy[nDir];
					if (!isIn(nx, ny)) continue;

					if (posMap[nx][ny] != null && posMap[nx][ny].sharkIdx == idx) {
						shark.dir = nDir;
						shark.x = nx;
						shark.y = ny;
						Position pos = new Position(nx, ny, idx, K);
						positions.add(pos);
						samePosition.computeIfAbsent(pos, k -> new PriorityQueue<>()).add(pos);
						break;
					}
				}
			}

			for (Position position : positions) {
				Queue<Position> pq = samePosition.get(position);
				int size = pq.size();
				for (int i = 0; i < size; i++) {
					Position pos = pq.poll();
					if (i == 0) {
						posMap[pos.x][pos.y] = pos;
						current.add(pos);
					} else {
						isDied[pos.sharkIdx] = true;
						if (++dieCount == M - 1) {
							result = time;
							return;
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (current.contains(new Position(i, j ,-1, -11))) continue;
					if (posMap[i][j] != null) {
						posMap[i][j].k--;
						if (posMap[i][j].k == 0) posMap[i][j] = null;
					}
				}
			}
		}
		result = -1;
	}

	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static class Position implements Comparable<Position> {
		int x, y, k, sharkIdx;
		public Position(int x, int y, int sharkIdx, int k) {
			this.x = x; this.y = y; this.k = k; this.sharkIdx = sharkIdx;
		}
		@Override public int compareTo(Position o) {
			return this.sharkIdx - o.sharkIdx;
		}
		@Override public boolean equals(Object obj) {
			Position p = (Position) obj;
			return this.x == p.x && this.y == p.y;
		}
		@Override public int hashCode() {
			return x * 31 + y;
		}
	}

	static class Shark {
		int x, y, idx, dir;
		int[][] priorityDir = new int[5][4];
		public Shark(int x, int y, int idx) {
			this.x = x; this.y = y; this.idx = idx;
		}
		void setDir(int dir) { this.dir = dir; }
		void setPriorityDir(int i, int[] dirs) { priorityDir[i] = dirs; }
	}
}