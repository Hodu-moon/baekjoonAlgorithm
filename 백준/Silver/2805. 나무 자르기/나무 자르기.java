
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long tree[] = new long[N];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            tree[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(tree);

        long mid = 0;
        long hi = tree[tree.length-1];
        long lo = 0;
        while(lo < hi){
            mid = (hi + lo) / 2;
            long sum = 0;

            for(int k = 0; k < tree.length; k++){
                long e = tree[k] - mid ;
                if(e > 0)
                    sum = sum + e;
            }

            if( sum < M ){
                hi = mid;
            }else
                lo = mid + 1;
        }
        System.out.println(lo-1);

    }
}
