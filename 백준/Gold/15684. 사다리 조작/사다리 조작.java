import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {

	static int N, M , H, result;
	static boolean[][] visited;
	static int[][] go;
	static int force;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		visited = new boolean[H][N];
		go = new int[H][N];
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int line = Integer.parseInt(st.nextToken()) - 1;
			int connect = Integer.parseInt(st.nextToken()) - 1;
			
			
			visited[line][connect] = visited[line][connect + 1] = true; 
			
			go[line][connect] = connect + 1;
			go[line][connect + 1] = connect;
			
		}
		
		result = Integer.MAX_VALUE;
		
		back(0, 0);
		
		
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);

		
	}
	
	// 1. 조합뽑기
	static void back(int depth, int startWith) {
		
//		if(++force == 20) {
//			flag = true;
//		}
//		
//		if(flag)
//			return;
		// 기저조건
		
//		System.out.println(" map ");
//		printMap();
	
		if(solve()) {
//			System.out.println("success!!!!!!  :" + depth);
			result = Math.min(result, depth);
		}
		
		if(depth == 3) {
			return;
		}
		
		
		// 유도조건
		for(int i = startWith; i < H * N; i++) {
			
			if(i % N == N - 1) {
				continue;
			}
			
			int x = i / N;
			int y = i % N;
			
			
			if(visited[x][y] || visited[x][y + 1]) {
				continue;
			}
			
			
			visited[x][y] = true;
			visited[x][y + 1] = true;
			go[x][y] = y + 1;
			go[x][y + 1] = y;
//			System.out.println("depth : " + (depth + 1) + " x : " + x + " y : " + y);
			back(depth + 1, i + 1);
			
			
			visited[x][y] = false;
			visited[x][y + 1] = false;	
			go[x][y] = 0;
			go[x][y + 1] = 0;
			
		}
		
		
	}
	
	// 2. 시뮬레이션 
	
	static boolean solve() {
		
	
		
		for(int i = 0; i < N; i++) {
			int returnIdx = simulation(i);
			
			if(returnIdx != i )
				return false;
			
			
		}
		
		return true;
	}
	
	static int simulation(int n) {
		
		int level = 0;
//		System.out.println("start  n : " + n);
		
		while(level < H) {
			
			if(!visited[level][n]) { // 사다리 연결이 안되어있겠죠
				level++;
			}else {  // 사다리 연결이 되어있음
				
				// check 왼쪽이야 오른쪽이야
				
				// 1. 범위 나갔으면 자동적으로 다음것이 된다 
				int left = n - 1;
				int right = n + 1;
				if(!isIn(left)) {
					n++;
//					System.out.println("move right empty");
				}else if(!isIn(right)) {
					n--;
//					System.out.println("move left empty");
				}else if(visited[level][n]) {
//					System.out.println("move to " + go[level][n]);
					n = go[level][n];
				}
				
				level++;
				
				
			}
			
//			System.out.println("level down : " + level);
//			System.out.println(" n : " + n);
			
		}
		
//		System.out.println(n);
		
		
		return n ;
	}

	static boolean isIn(int n) {
		return 0 <= n && n < N;
	}
	static void printMap() {
		for(boolean[] v : visited) {
			System.out.println(Arrays.toString(v));
		}
	}
}

//2 1 3
//1 1