import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 아직 아무 의견이 없다면 문제의 난이도는 0으로 결정한다.
        if(N == 0){
            System.out.println(0);
            return;
        }

        int[] arr = new int[N];

        // 절사평균 숫자 구하기
//         제외되는 사람 구하기
        int except = (int)Math.round(N * 0.15);

        // 의견이 하나 이상 있다면, 문제의 난이도는 모든 사람의 난이도 의견의 30% 절사평균으로 결정한다.
        for (int i = 0; i < N; i++){
            int d = Integer.parseInt(br.readLine());
            arr[i] = d;
        }

        Arrays.sort(arr);

        long sum = 0;

        for (int i = except; i < (N - except); i++){
            sum += arr[i];
        }

        long result = Math.round((float) sum / (N - (except * 2)));

        System.out.println(result);
    }
}

