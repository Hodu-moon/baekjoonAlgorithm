import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = 0;
        while(st.hasMoreTokens()){
            arr[k++] = Integer.parseInt(st.nextToken());
        }

        // 정렬 해야함
        Arrays.sort(arr);

        // 처리 로직
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i] * n;
            n--;
        }

        System.out.println(sum);

    }
}

