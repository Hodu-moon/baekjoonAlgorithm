
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
        int []card = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        long sum =card[card.length-1];
        long x = 0;
        for(int i = 0; i < card.length -2 ; i++){
            for(int j = i+1; j < card.length-1; j++){
                for(int k =  j + 1; k < card.length; k++) {
                    sum = card[i] + card[j] + card[k];

                    if(sum == M){
                        System.out.println(sum);
                        return;
                    }

                    if (sum < M && x < sum) {
                        x = sum;


                    }
                }
            }
        }
        System.out.println(x);

    }
}
