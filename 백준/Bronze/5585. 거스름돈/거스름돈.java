
import java.util.Scanner;

public class Main {

	static int[] m = {500, 100, 50, 10, 5, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		int remain = 1000 - input;
		
		int result = 0;
		for(int i = 0; i < m.length; i++) {
			int cnt = remain / m[i];
			result += cnt;
			remain %= m[i];
		}
		
		System.out.println(result);
		
		
		
		
	}
}
