
import java.util.Scanner;

public class Main {
	
	
	static int[] materials = {8, 8, 4, 1, 9};
	static int[] topings = {1, 30, 25, 10};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int result = 0;
			sc.nextLine();
			
			double minDough = Double.MAX_VALUE;
			for(int i =  0; i < 5; i++) {
				minDough = Math.min(minDough, sc.nextInt() / (double)materials[i]) ;
			}
			
			int topingCount = 0;
			
			int dough = (int)Math.floor(minDough * 16);
			
			
			for(int i = 0; i < 4; i++) {
				topingCount += (sc.nextInt() / topings[i]  );
			}

			result = Math.min(dough, topingCount);			
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
		
	}

	//팬케이크를 만들기 위해서는 먼저 반죽을 해야 한다. 우유 8컵, 계란 노른자 8개, 
	//설탕 4스푼, 소금 1스푼, 밀가루 9컵이 있으면 팬케이크 반죽 16개를 만들 수 있다. 
	//어떤 0 이상의 실수 x에 대해 모든 재료가 앞에 주어진 양의 x배 이상 있다면 은주는 ⌊16x⌋개의 반죽을 만들 수 있다.

//그 다음 반죽에 토핑을 얹고 구우면 팬케이크가 만들어진다. 은주가 만들 수 있는 팬케이크의 종류와 각각에 필요한 토핑의 목록은 다음과 같다.
//
//바나나 팬케이크: 바나나 1개
//딸기 팬케이크: 딸기잼 30그램
//초콜릿 팬케이크: 초콜릿 스프레드 25그램
//호두 팬케이크: 호두 10개
}

//2

//16 16 8 2 17
//10 47 100 19

