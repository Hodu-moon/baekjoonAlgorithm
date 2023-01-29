
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tri[] = new int[3];
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < tri.length; i++){
                tri[i] = Integer.parseInt(st.nextToken());
            }
            if(tri[0] == 0){
                break;
            }
            Arrays.sort(tri);
            if(tri[2] * tri[2] == tri[0] * tri[0] + tri[1] * tri[1] ){
                sb.append("right").append("\n");
            }else
                sb.append("wrong").append("\n");
        }
        System.out.println(sb);


    }
}
