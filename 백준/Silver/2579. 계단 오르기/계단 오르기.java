import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //1번째 전
        int[] dp1 = new int[N + 1];
        //2번째 전
        int[] dp2 = new int[N + 1];

        dp1[0] = 0;
        dp2[0] = 0;

        if(N >= 1) {
            dp1[1] = arr[1];
        }
        if(N >= 2) {
            dp1[2] = arr[1] + arr[2];
            dp2[2] = arr[2];
        }

        for( int i = 3; i <= N; i++){
            // 바로 뒤에서 온놈 -> dp1
            dp1[i] = dp2[i-1] + arr[i];

            // 두번째 뒤에서 온놈 -> dp2
            int dp_max = dp1[i-2];
            if(dp_max < dp2[i-2]){
                dp_max = dp2[i-2];
            }

            // ->
//            dp1[i-2] > dp2[i-2] ? dp_max = dp1[i-2] : dp_max = dp2[i-2] ;
            dp2[i] = arr[i] + dp_max;
        }


        System.out.println(dp2[N] > dp1[N] ? dp2[N] : dp1[N]);

    }
}

