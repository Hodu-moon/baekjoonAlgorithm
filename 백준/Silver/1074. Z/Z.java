import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long count = 0;
        while( N > 1){
            N--;
            int n = (int)Math.pow(2, N);
            long m = (long) n * n;
            // n 2 * 2 4
            //
            // 왼쪽 위
            if( r < n & c < n){

            }
            // 오른쪽 위
            else if ( r <  n & c < n * 2){
                count += m;
                c -= n;
            }
            // 왼쪽 아래
            else if (r < n * 2 & c < n ) {
                count += m * 2;
                r -= n;
            }
            // 오른쪽 아래
            else if (r < n * 2 & c < n * 2) {
                count += m * 3;
                r -= n;
                c -= n;
            }


        }

        if( r == 0 & c == 0){
            count += 1;
        } else if (r == 0 & c == 1) {
            count += 2;
        } else if (r == 1 & c == 0) {
            count += 3;
        } else if(r == 1 & c == 1){
            count += 4;
        }

        System.out.println(count - 1);
    }
}

