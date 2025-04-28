

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] map = new int[128];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map['-'] = 0;
		map['\\'] = 1;
		map['('] = 2;
		map['@'] = 3;
		map['?'] = 4;
		map['>'] = 5;
		map['&'] = 6;
		map['%'] = 7;
		map['/'] = -1;

		
		while(true) {
			String input = br.readLine();
			
			if(input.equals("#"))
				break;
			
			int result = 0;
			int start = input.length() - 1;
			for(int i = 0; i < input.length(); i++) {
				double pow = Math.pow(8, start--);
			
				result += (pow * map[input.charAt(i)]);
				
			}
			
			sb.append(result).append("\n");

		}
		System.out.println(sb);
		
		

	}

}
