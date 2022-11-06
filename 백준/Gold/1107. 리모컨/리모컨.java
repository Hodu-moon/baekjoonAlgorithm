
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();
        int m = scanner.nextInt();

        //기본값 false
        boolean []remote = new boolean[10];
        for(int i = 0; i < m; i++){
            int n = scanner.nextInt();
            remote[n] = true;
        }

        int result = Math.abs(target - 100);
        //만약 리모컨이 9빼고 다 고장이 났다면 999999로 가서 내려갸함.
        for(int i = 0; i <= 999999; i++){
            //나는 Math.log10()+1 로 자리수를 구했는데. 허무하다.

            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j < len; j++){
                // 무슨 초기값을 이렇게 주니..... 와....
                if(remote[str.charAt(j) - '0']){
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak){
                int min = Math.abs(target-i) + len;
                result = Math.min(min, result);
            }

        }
        System.out.println(result);
    }
}
