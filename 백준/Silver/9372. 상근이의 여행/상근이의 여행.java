import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			for(int i = 0; i < M; i++) {
				sc.nextInt();
				sc.nextInt();
			}
			
			System.out.println(N - 1);
		}
		
		
	}

}
