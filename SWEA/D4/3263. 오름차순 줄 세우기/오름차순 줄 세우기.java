import java.io.*;
import java.util.*;

public class Solution {

	static int N, result;
	static int[] kidArray;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			kidArray = new int[N];
			
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				kidArray[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] consecutiveLengthArray = new int[N + 1];
			
			for(int i = 0; i < N; i++) {
				int currentKidNumber = kidArray[i];
	
				consecutiveLengthArray[currentKidNumber] = 
						consecutiveLengthArray[currentKidNumber - 1] + 1;
				
				result = Math.max(result, consecutiveLengthArray[currentKidNumber]);
			}
			
		
			
			
			
			sb.append("#").append(t).append(" ").append(N - result).append("\n");
		}
		System.out.println(sb);
		

	}

}
//1
//5
//5 2 4 1 3
