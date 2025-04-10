import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Solution {

	static int[][] map;
	static int N, result;
	static final int L = 1000;
	static boolean[] checked;
	
	// 상 - 0, 하 - 1, 좌 - 2, 우 - 3
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();
	
	// atom 관리 배열 
	static List<Atom> atomList;
	// 1초 뒤에 같은 자리에 만나는 친구들
	static Map<Position, List<Atom>> nextMeet;
	// 2명 이상 같은애들 만나는 곳!
	static Set<Position> meetPositions;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			atomList = new ArrayList<>();
			atomList.add(new Atom(-1, -1, -1, -1, -1));
			map = new int[2 * L + 1][2 * L + 1];
			checked = new boolean[N+1];
			
			result = 0;
			
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()) + L;
				int y = Integer.parseInt(st.nextToken()) + L;
				int dir = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				atomList.add(new Atom(i, x, y,dir,  k));
				
				map[x][y] = i;
			}
			
			
			solve();
			
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static void solve() {
		
		int time = 0;
		int cnt = 0;
		
		nextMeet = new HashMap<>();
		meetPositions = new HashSet<>();
		
		
		while(true) {
			
			if(time >= 3000) {
				break;
			}
			
			
			nextMeet.clear();
			meetPositions.clear();
			
			
			for(int i = 1; i <= N; i++) {
				Atom atom = atomList.get(i);
				
				

				if(checked[atom.no])
					continue;
				
				
				//  다음 것을 봐야함 
				// 1. 다음것이  0.5초 뒤에 만날 때 !!!!!!!!!
				int nx = atom.x + dx[atom.dir];
				int ny = atom.y + dy[atom.dir];
				
				
				// 다음 갈 곳이 밖이면 처리해버림 
				if(!isIn(nx, ny)) {
				
					
					
					checked[atom.no] = true;
					cnt++;
					map[atom.x][atom.y] = 0;
					continue;
				}
				
				// 바로 앞에 뭐가 있음 
				if(map[nx][ny] != 0) {
					int nextDir = atomList.get(map[nx][ny]).dir;
					// 0.5초 뒤에 만나는 거임!! 
					if(is180(atom.dir, nextDir) ) {
						checked[atom.no] = checked[map[nx][ny]] = true;
						
						result += atom.weight;
						result += atomList.get(map[nx][ny]).weight;
						cnt += 2;
						map[atom.x][atom.y] = 0;
						map[nx][ny] = 0;
						continue;
					}
				}
				
				// 다음 갈 곳 처리 
				Position current = new Position(nx, ny);
				
				List<Atom> next = nextMeet.get(current);
				if(Objects.isNull(next)) {
					next = new ArrayList<>();
					next.add(atom);
				    nextMeet.put(current, next); 
				}else { // 이미 어떤놈이 들어가있음
					next.add(atom);
					meetPositions.add(current);
				}
			}
			
			
			
			// 같은 곳에서 만나는 친구들 컷
			for(Position meet : meetPositions) {
				List<Atom>list = nextMeet.get(meet);
				
				for(Atom a : list) {
					checked[a.no] = true;
					result += a.weight;
					map[a.x][a.y] = 0;
					cnt++;
				}
			}
			
			// move
			for(int i = 1; i <= N; i++ ) {
				Atom atom = atomList.get(i);
				if(checked[atom.no])
					continue;
			
				map[atom.x][atom.y] = 0;
				atom.x = atom.x + dx[atom.dir];
				atom.y = atom.y + dy[atom.dir];
				map[atom.x][atom.y] = atom.no;
			}
			
			if(cnt == N ) {
				return;
			}
			
			time++;
		}
		
		
	}
	
	static boolean is180(int d1, int d2) {
		if(d1 == 0) {
			d1 = 1;
		}else if(d1 == 1) {
			d1 = 0;
		}else if(d1 == 2) {
			d1 = 3;
		}else if(d1 == 3) {
			d1 = 2;
		}
		
		return d1 == d2;
	}
	
	static boolean isIn(int x, int y) {
		return 0 <= x && x < 2 * L + 1 && 0 <= y && y < 2 * L + 1;
	}
	
	static class Atom{
		int no, x, y, weight, dir;

		public Atom(int no, int x, int y, int dir, int weight) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Atom [no=" + no + ", x=" + x + ", y=" + y + ", weight=" + weight + ", dir=" + dir + "]";
		}
		
		
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
			return this.x == p.x && this.y == p.y;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.x * 31 + this.y  * 31;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
	}
	
	

}
































//
//2
//4
//-1000 0 3 5
//1000 0 2 3
//0 1000 1 7
//0 -1000 0 9