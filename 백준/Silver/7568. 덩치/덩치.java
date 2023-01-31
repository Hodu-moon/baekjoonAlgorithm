
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size [][] = new int[n][2];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            size[i][0] = Integer.parseInt(st.nextToken());
            size[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n;i++){
            int rank = 1;

            for(int j = 0; j < n; j++){
                if(i == j ) continue;
                if(size[i][0] < size[j][0] && size[i][1] < size[j][1]){
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
}
