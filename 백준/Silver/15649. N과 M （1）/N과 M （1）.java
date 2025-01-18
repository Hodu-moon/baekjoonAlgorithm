import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N];
		arr = new int[M];
		
		back(0);
		
		System.out.println(sb.toString());
	}
	
	public static void back(int depth ) {
		if(depth == M) {
			// 종료 조건
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				
				visited[i] = true;
				arr[depth] = i + 1;
				back(depth + 1);
				visited[i] = false;
				
			}
		}
		
		
		
	}

}
