
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char[] chars = new char['Z' + 1];
		char[] target = "CAMBRIDGE".toCharArray();
		for (int i = 0; i < target.length; i++) {
			chars[target[i]] = 1;
		}

		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length; i++) {
			char current = input[i];

			if (chars[current] == 1)
				continue;

			sb.append(input[i]);
		}

		System.out.println(sb);

	}

}
