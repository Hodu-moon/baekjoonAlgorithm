import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		back(0);
		
		System.out.println(sb.toString());
		
	}

	static void back(int depth) {
		if(depth == M) {
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			
			arr[depth] = i;
			back(depth + 1);
			
		}
	}
}
