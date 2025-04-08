import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

			
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			int[] LIS = new int[N];
			int result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i =0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 0; i < N; i++) {
				LIS[i] = 1;
				for(int j = 0; j < i; j++) {
					
					if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1 ) {
						LIS[i] = LIS[j] + 1;
					}
				}
				result = Math.max(result, LIS[i]);
			}
			
			System.out.println(result);
			
	}

}
