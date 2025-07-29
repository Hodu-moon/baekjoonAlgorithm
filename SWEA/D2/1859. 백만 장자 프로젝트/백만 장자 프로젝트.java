
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//  쌀 때 사서, 비쌀 때 팔자

// 규칙 1. 오히려 뒤에서 부터 오면서 갯수를 세볼까
// max = list[lastIndex]
public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++){
            int N  = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            sb.append("#").append(t).append(" ").append(solve(array, N)).append("\n");
        }

        System.out.println(sb);
    }

    static long solve(int[] array, int N){
        long result = 0;
        long cost = 0;
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(int i = N - 1; i >= 0; i--){
            // 1. 원래 값보다 높은 값이 있다면
            if(max < array[i]){
                result += ((long) max * cnt) - cost;

                max = array[i];
                cnt = 0;
                cost = 0;
                continue;
            }

            cost += array[i];
            cnt++;

        }

        if(cnt > 0){
            result += ((long)max * cnt) - cost;
        }


        return result;
    }
}
//3
//3
//10 7 6
//3
//3 5 9
//5
//1 1 3 1 2

// 1 1 2 1 2
