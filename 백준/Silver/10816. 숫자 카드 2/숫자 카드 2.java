
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int []count = new int[20000001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int []array  = new int [n];

        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            count[array[i] + 10000000]++;
        }
        StringBuilder sb = new StringBuilder();

        int n2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n2; i++){
            int e = Integer.parseInt(st.nextToken());
            sb.append(count[e+10000000]).append(' ');
        }

        System.out.println(sb);


    }
}
