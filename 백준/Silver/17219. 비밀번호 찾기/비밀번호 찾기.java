
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> password = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            password.put(st.nextToken(), st.nextToken());

        }

        StringBuilder sb = new StringBuilder();
        while(N --> 0){
            sb.append(password.get(br.readLine())).append("\n");

        }
        System.out.println(sb);

    }
}
