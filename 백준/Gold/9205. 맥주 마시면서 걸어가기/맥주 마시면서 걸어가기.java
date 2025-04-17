import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;

	static Position[] positionList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
//			sb.append("t : ").append(t).append("\n");
			N = Integer.parseInt(br.readLine());
			positionList = new Position[N + 2];

			for (int i = 0; i <  N + 2 ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				positionList[i] = new Position(x, y);
			}

			solve();

		}

		System.out.println(sb);

	}

	static void solve() {
		boolean[] visited = new boolean[N + 2];
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
		
			if(getDistance(positionList[now], positionList[N + 1]) <= 1000) {
				sb.append("happy").append("\n");
				return;
			}
			
			for(int i = 0; i < N + 1; i++) {
				if(visited[i])
					continue;
				
				if(getDistance(positionList[now], positionList[i]) <= 1000) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		sb.append("sad").append("\n");
		
	
	
	}


	static class Position {
		int x, y;

		public Position( int x, int y) {
			this.x = x;
			this.y = y;
		}

		
	}

	static int getDistance(Position p1, Position p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}
