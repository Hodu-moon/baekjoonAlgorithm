
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> poketmon = new HashMap<>();
        String[] namea = new String[N+1];
        for(int i = 1; i < N+1; i++){
            String name = br.readLine();
            poketmon.put(name, i);
            namea[i] = name;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            String user = br.readLine();
            if(isInteger(user)){
                int a = Integer.parseInt(user);
                sb.append(namea[a]).append("\n");
            }else {
                sb.append(poketmon.get(user)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
