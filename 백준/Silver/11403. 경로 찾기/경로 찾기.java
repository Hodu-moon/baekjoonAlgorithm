import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 10000;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][]map = new int[N][N];

		
		
		
		for(int i =0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(map[i][j] == 0)
					map[i][j] = INF;
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
//				if(i == k)
//					continue;
				for(int j = 0; j < N; j++) {
//					if(j == k || i == j)
//						continue;
//					
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j] );
					
					
				}
			}
		}

		

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(( map[i][j] == INF ? 0 : 1) + " ");
			}
			System.out.println();
		}
		
		
	}
	


}
