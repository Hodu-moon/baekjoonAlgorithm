
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        LinkedList<Integer> List = new LinkedList<>();

        for(int i = 1 ; i <= N; i++){
            List.add(i);
        }

        sb.append("<");
        while(!List.isEmpty()){
            for(int i = 0; i < K-1; i++){
                List.add(List.remove());
            }
            sb.append(List.remove());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");

        System.out.println(sb.toString());

    }
}
