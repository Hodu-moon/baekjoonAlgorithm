
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아이디어
// 1. 줄 세우기 할 때 1 2 3 4 5 로 세워야한다.
//        2 3 1 4 5
//        -> 2 3 4 5 이게 되니까 1만 앞으로 옮기면 된다.
//        1 3 4 2
//        -> 3, 4 를 뒤로 옮기드나
//           1 2 를 앞으로 빼든
//           중요하지 않음 그냥  1 2,  | 3,4 이렇게 연결되어 있는 숫자를 아는게 중요함
// 2. 아이들의 숫자에서 저렇게 연속적인 숫자를 빼주면 된다.
//
public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int kidCount;
    static int result;
    static int[] kidArray;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            kidCount = Integer.parseInt(br.readLine());
            kidArray = new int[kidCount];
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < kidCount; i++){
                kidArray[i] = Integer.parseInt(st.nextToken());
            }


            solve();



            sb.append("#").append(t).append(" ").append(kidCount - result).append("\n");
        }

        System.out.println(sb);
    }

    static void solve(){
        int[] consecutiveKidArray = new int[kidCount + 1];

        for(int i = 0; i < kidCount; i++){
            int currentKidNum = kidArray[i];


            consecutiveKidArray[currentKidNum] = consecutiveKidArray[currentKidNum - 1] +1;

            result = Math.max(result, consecutiveKidArray[currentKidNum]);

        }

    }

}

//1
//5
//5 2 4 1 3