import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int []arr = new int[6];

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);
        int i = 0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        int T , P;

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int count = 0;

        for(int j = 0; j < arr.length; j++){
            count += (arr[j] / T) + 1;
            if( arr[j] % T == 0){
                count--;
            }
        }


        System.out.println(count);
        System.out.println(N / P + " " + N % P);

    }
}

