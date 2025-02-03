
import java.util.*;

/**   - 소스코드 상단에 문제풀이를 위한 아이디어 주석 달기
- 소스코드에 수행 후 소스코드 상단에 메모리, 시간 주석 달기, 본인의 문제에 대한 난이도 표시하기
- 문제 구현하기전에 문제 최소 3번 먼저 정독하고 문제 풀이를 위한 아이디어 정리하기!!!!
- 소스코드에 라인별 주석 달기
- 최종 제출하기 전에 :
    - 요구사항 누락은 없는지,
    - 입력데이터는 올바르게 가져왔는지,
    - 출력형식은 올바른지,
    - 수행 후에 반례 사례는 없는지(특히, 숨어있는 반례 사례까지 꼼꼼하게 체킹!!)
    - 메모리, 시간 초과에 제약 사항에 부합하는지,
    - 수행 결과 다시 한번 더 확인하기!!!!

 */

 // 부분 문자열 -  서로 다른 -> Set
 // 부분문자열 다 구해서 Set 에 넣기
public class Main {
    

    static Set<String> set = new HashSet<>();
    static int M;
    static char[] arr;
    static String user;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        user = sc.nextLine();
        // a b a b c
        // ab ba ab bc
        // aba bab abc 
        //  abab babc 
        // ababc
        
        int n = user.length();
        
        for(int i = 0; i < n; i++){
             for(int j = 0; j < n - i; j++){
                StringBuilder sb = new StringBuilder();
                for(int k = j; k < j + i+ 1; k++){
                    sb.append(user.charAt(k));
                }
                String s = sb.toString().trim();
                if(!s.equals("") && set.add(s)){

                }
            }
        }

        System.out.println(set.size());

    }



}
