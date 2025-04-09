import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static final int INF = 10000000;
	static int[][] graph, result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];

		result = new int[N + 1][N + 1];
		// 초기화 무한대로
		for (int[] g : graph) {
			Arrays.fill(g, INF);
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int before = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			graph[before][next] = 1;
			result[before][next] = -1;
			result[next][before] = 1;
			
		}

//		printMap();

		
		// 플로이드 워샬
		// 경유지, 출발지, 도착지
		for (int k = 1; k <= N; k++) {

			for (int i = 1; i <= N; i++) {
				if (k == i)
					continue;

				for (int j = 1; j <= N; j++) {

					if (k == j || i == j)
						continue;

					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					
					if(graph[i][j] < INF - 50000) {
						result[i][j] = -1;
						result[j][i] = 1;
					}
				}
			}

		}
//		printMap();

		int x = Integer.parseInt(br.readLine());
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int before = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			sb.append(result[before][next]).append("\n");
		}
		
		System.out.println(sb);
	}

	
	static void printMap() {
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <= N; j++) {
				System.out.printf("%14d", graph[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
