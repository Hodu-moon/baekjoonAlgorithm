import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visited = new boolean[N + 1];
	
		back(0, 1);
		
		System.out.println(sb);
	}

	public static void back(int depth , int start) {
			if(depth == M){
				for(int a : arr) {
					sb.append(a).append(" ");
				}
				sb.append("\n");
				
				return;
			}
		
			for(int i = start; i <= N; i++) {
				
				if(visited[i] == false ) {
					
					visited[i] = true;
					arr[depth] = i;
					back(depth + 1, i + 1);
					visited[i] = false;
					
				}
				
			}
	}
}
