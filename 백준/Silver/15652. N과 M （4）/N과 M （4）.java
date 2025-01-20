
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
	
		back(0, 1);
		System.out.println(sb.toString());
	}
	
	static void back(int depth, int startWith) {
		if(depth == M ) {
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = startWith; i <= N; i++) {
			arr[depth] = i;
			back(depth + 1, i);
			
		}
		
	}
	

}
