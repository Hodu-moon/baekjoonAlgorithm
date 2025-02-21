
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        int bitset = 0;
        int num = 0;
        while (N --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String user = st.nextToken();
            switch (user){
                case "add":
                    num  = Integer.parseInt(st.nextToken());
                    bitset |= (1 << (num-1));
                // 19 번째 자리가 20번을 뜻함
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bitset = bitset &  ~(1 << (num - 1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((bitset & (1 << (num-1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    bitset ^= (1 << (num - 1));
                    break;
                case "all":
                    bitset |= (~0);
                    break;
                case "empty":
                    bitset &= 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
