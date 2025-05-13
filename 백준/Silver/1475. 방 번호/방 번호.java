
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int[] nums = new int[10];
		
		Scanner sc = new Scanner(System.in);
		
		String num = sc.nextLine();
		
		for(int i = 0; i < num.length(); i++) {
			int current = num.charAt(i) - '0';
			nums[current]++;
		}
		
		
		int sixNineCount = (nums[6] + nums[9] + 1) / 2;
		nums[6] = nums[9] = 0;
		int max = sixNineCount
				;

		for(int i = 0; i <= 9; i++) {
			max = Math.max(max, nums[i]);
		}
		
		
		
		System.out.println(max);
		
		
		
	}

}
