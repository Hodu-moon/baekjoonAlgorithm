

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static long start, end, max, TARGET;

    static long[] budget;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        budget = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long curSum = 0;
        for(int i = 0; i < N; i++){
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
            curSum += budget[i];
        }

        TARGET = Integer.parseInt(br.readLine());


        if(curSum <= TARGET){
            System.out.println(max);
        }else{
            solve();

            System.out.println(end - 1);
        }

    }

    static void solve(){
        start = 0;
        end = 100001L;

        while(start < end){
            long mid = start + (end - start) / 2;

            long sum = calc(mid);

//            System.out.println(start + " " + end + " " + sum);
            if( sum <= TARGET){
                start = mid + 1;
            }else{
                end = mid;
            }

        }


    }

    static long calc(long limit){

        long sum = 0;
        for(int i = 0; i < N; i++){
            if(budget[i] < limit){
                sum += budget[i];
            }else{ // budget[i] >= limit
                sum += limit;
            }
        }


        return sum;

    }
}
