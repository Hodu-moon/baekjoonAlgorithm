import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, cnt, result;
	static int start, end;
	static int[] belt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N];
		
		start = 0; end = N - 1;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
	
		
		
		solve();
		System.out.println(result);
	}

	
	static void solve() {
		
		boolean[] robot = new boolean[N];
		
		int time = 0;
		while(true) {
			time++;
//			System.out.println(time);
			//1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			start = (start - 1 + 2*N ) % (2*N);
			end = (end - 1 + 2*N ) % (2*N);
			
			for(int i = N - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false;
			robot[N - 1] = false; // 마지막칸 도착하면 언제든지 내림 
			
			
			//2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			for(int i = N - 2; i > 0; i--) {
				
				
				if(robot[i] && !robot[i + 1]) {
					int nextPos = (start + i + 1 ) % (2 * N);
					
					if(belt[nextPos] >= 1) {
						robot[i] = false;
						robot[i + 1] = true;
						
						belt[nextPos]--;
						if(belt[nextPos] == 0)
							cnt++;
						
					}
				}
				
				
			}
			
			
			// 3. 올리는 위치가 0 이 아니라면 로봇을 올림
			
			
			if(belt[start] > 0) {
				robot[0] = true;
				belt[start]--;
				
				if(belt[start] == 0)
					cnt++;
			}
			
			// 4. 
			if( cnt >= K) {
				result = time;
				break;
			}
				
			
			
		}
		
	}
	
	
}

//컨베이어 벨트에 박스 모양 로봇을 하나씩 올리려고 한다. 로봇은 올리는 위치에만 올릴 수 있다. 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다. 로봇은 컨베이어 벨트 위에서 스스로 이동할 수 있다. 로봇을 올리는 위치에 올리거나 로봇이 어떤 칸으로 이동하면 그 칸의 내구도는 즉시 1만큼 감소한다.
//
//컨베이어 벨트를 이용해 로봇들을 건너편으로 옮기려고 한다. 로봇을 옮기는 과정에서는 아래와 같은 일이 순서대로 일어난다.
//
//1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
//2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
//2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
//3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
//4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.

//3 2
//1 2 1 2 1 2