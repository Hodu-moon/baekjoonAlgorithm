import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	
	// 1. 숫자를 입력받기 
	// 2. 숫자에 맞는 크기 더하기
	// 3. 줄을 입력받고 
	// 4. length 가 4임 그러면 4 전까지 가져와서
	// 5. 1 * 4 더해주고 
	// 6. 각 숫자 크기 만큼 더해주고 
	
	static final String END = "0";
	static StringBuilder sb = new StringBuilder();
	static int[] scales ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		scales = new int[10000];
		Arrays.fill(scales, 3);
		scales[0] = 4;
		scales[1] = 2;
		
		while(true) {
			String input = br.readLine();
			int result = 0;
			if(input.equals(END))
				break;
			
			result += (input.length() );
			result += 1;
			for(int i = 0; i < input.length(); i++) {
				int num = input.charAt(i) - '0';
				result += scales[num];
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
