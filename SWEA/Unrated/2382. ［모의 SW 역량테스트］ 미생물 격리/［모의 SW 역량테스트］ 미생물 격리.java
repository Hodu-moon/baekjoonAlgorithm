import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.*;

public class  Solution {

	static int N, M, K, result;

	static StringBuilder sb = new StringBuilder();

	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };
	static Germ[] germs;
	static boolean[] died;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			germs = new Germ[K];
			died = new boolean[K];
			result = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				germs[i] = new Germ(x, y, size, dir);
				result += size;
			}

			solve();

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	static void solve() {

		for (int m = 0; m < M; m++) {
//			System.out.println("---------- m ----------" );
			Map<Position, List<Integer>> map = new HashMap<>();

			for (int i = 0; i < K; i++) {
				
				
//				System.out.println(germs[i] + " " + (died[i] ? "died" : "alive"));
				
				if( died[i])
					continue;
				
				Germ germ = germs[i];
				
				int nx = germ.x + dx[germ.dir];
				int ny = germ.y + dy[germ.dir];
				
				germ.x = nx;
				germ.y = ny;
				
				// 똑같은건 존재하지 않을거임 
				if(!isIn(nx, ny)) {
					int origin = germ.size;
					//5 
					int after = germ.size / 2;

					germ.size = after;
					germ.changeDir180();
					
					result -= (origin - after);
					
					
					continue;
				}
				
				// 
				Position position = new Position(nx, ny);
				if(map.containsKey(position)) {
					map.get(position).add(i);
				}else {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(i);
					map.put(position, list);
				}

			}
			
			for(Position position : map.keySet()) {
//				System.out.println("key " + position );
				
				List<Integer> list = map.get(position);
				// 혼자임 
				if(list.size() == 1) {
					continue;
				}
				
				int maxIdx = Integer.MIN_VALUE;
				int maxSize = Integer.MIN_VALUE;
				int sum = 0;
				for(int idx : list) {
//					System.out.println(germs[idx]);
					if(germs[idx].size > maxSize) {
						maxIdx = idx;
						maxSize = germs[idx].size;
					}
					sum += germs[idx].size;
					died[idx] = true;
				}
				
				
//				System.out.println("max");
//				System.out.println(germs[maxIdx]);
				died[maxIdx] = false;
				germs[maxIdx].size = sum;
//				System.out.println(germs[maxIdx]);

				
				
			}
			
			
		}

	}

	
	
	
	static boolean isIn(int x, int y) {
		return 0 < x && x < N -1 && 0 < y && y < N-1 ;
	}

	static class Position{
		int x, y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Position p = (Position)obj;
			return this.x == p.x && this.y == p.y ;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.x * 31 + y;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
		
	}
	static class Germ {
		int x, y, size, dir;

		public Germ(int x, int y, int size, int dir) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.dir = dir;
		}
		
		void changeDir180() {
			if(this.dir == 1)
				this.dir = 2;
			else if(this.dir == 2)
				this.dir = 1;
			else if(this.dir == 3) 
				this.dir = 4;
			else if(this.dir == 4) 
				this.dir = 3;
			
			
		}

		@Override
		public String toString() {
			return "Germ [x=" + x + ", y=" + y + ", size=" + size + ", dir=" + dir + "]";
		}

		
	}
	
	
	

}
