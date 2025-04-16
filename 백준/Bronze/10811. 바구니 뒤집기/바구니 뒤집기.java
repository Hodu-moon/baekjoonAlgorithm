import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			array[i] = i;
		}
		
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			while(i < j) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i++; j--;
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(array[i]).append(" ");
		}
		
		System.out.println(sb);
		
		
	}

}
