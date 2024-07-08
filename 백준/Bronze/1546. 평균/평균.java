import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int sum = 0;
        for(int i = 0; i < N; i++){
            int v = Integer.parseInt(st.nextToken());

            // max값 찾기
            if(v > max){
                max = v;
            }

            sum += v;
        }

        double avg = (double) sum / N;
        System.out.println(avg / max * 100);

    }
}

