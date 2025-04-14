import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int start = N -1;
		int end = N - 1;
		
		for(int i = 0; i < N ; i++) {
			int cnt = 1;
			for(int j = 0; j < 2 * N; j++) {
				if(j < start) {
					System.out.print(" ");
				}else if(start <= j  && j <= end ) {
					if(cnt++ % 2 == 1  ) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
			start--; end++;
		}

	}

}
