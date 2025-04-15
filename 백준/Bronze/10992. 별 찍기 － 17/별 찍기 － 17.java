import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		
		int start = N - 1;
		int end = N - 1;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2 * N - 1; j++) {
				
				if(i == N - 1) {
					sb.append("*");
				}else {
					if( j < start ) {
						sb.append(" ");
					}else if( j == start) {
						sb.append("*");
					}else if( start < j && j < end) {
						sb.append(" ");
					}else if(j == end) {
						sb.append("*");
					}else if(end < j) {
						break;
					}
				}
				
				
				
			}
			sb.append("\n");
			start--; end++;
		}
		System.out.println(sb);
	}

}
