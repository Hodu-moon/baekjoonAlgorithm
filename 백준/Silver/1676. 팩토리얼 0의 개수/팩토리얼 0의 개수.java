import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        fac(N);

        System.out.println(count);

    }
    static int fac(int n){
        if( n == 1){
            return 1;
        }else if( n > 1) {

            int temp = n;
            while(true){

                if(temp % 5 == 0) {
                    count++;
                }else
                    break;


                if(temp == 5){
                    break;
                }

                temp = temp / 5;
            }

            return n * fac(n - 1);
        }

        return 0;
    }
}

