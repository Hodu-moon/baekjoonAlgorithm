
import java.util.Scanner;

public class Main {

	static int[] sang = {'A', 'B', 'C'};
	static int[] chang = {'B', 'A', 'B', 'C'};
	static int[]hyun = {'C', 'C', 'A', 'A', 'B', 'B'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		
		int sangCount = 0;
		int changCount = 0;
		int hyunCount = 0;
		
		for(int i = 0; i < input.length(); i++) {
			
			int next = input.charAt(i);
			
			if(next == sang[ i % sang.length ]) {
				sangCount++;
			}
			
			if(next == chang[ i % chang.length]) {
				changCount++;
			}
			
			if(next == hyun[i % hyun.length]) {
				hyunCount++;
			}
			
		}
		StringBuilder sb = new StringBuilder(); 
		int maxScore = Math.max(sangCount, Math.max(changCount, hyunCount));
		
		sb.append(maxScore).append("\n");
		
		if(sangCount == maxScore) {
			sb.append("Adrian").append("\n");
		}
		
		if(changCount == maxScore) {
			sb.append("Bruno").append("\n");
		}
		
		if(hyunCount == maxScore) {
			sb.append("Goran").append("\n");
		}
		
		System.out.println(sb);
		

	}

}
