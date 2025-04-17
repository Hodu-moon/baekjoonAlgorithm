import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] array = new char[5][];
		for(int i = 0; i < 5; i++) {
			char[] cArray = br.readLine().toCharArray();
			
			array[i] = cArray;

		}
		
//		for(int i =0; i < 5; i++) {
//			
//			for(int j = 0; j < array[i].length; j++) {
//				System.out.print(array[i][j] +  " ");
//			}
//			
//			System.out.println();
//		}
//	
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0;  j < 5; j++) {
				if( i >= array[j].length) {
					continue;
				}
				
				sb.append(array[j][i]);
			}
		}
		
		System.out.println(sb);
		
		
		
		
	}
}

//ABCDE
//abcde
//01234
//FGHIJ
//fghij