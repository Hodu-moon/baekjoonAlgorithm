
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, TARGET;
    static long start, end;

    static int[] lans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        start = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        TARGET = Integer.parseInt(st.nextToken());

        lans = new int[N];


        for(int i = 0; i < N; i++){
            lans[i] = Integer.parseInt(br.readLine());
            end = Math.max(lans[i], end);
        }

        end++;
        solve();


        System.out.println(end - 1);

    }

    static void solve(){

        while(start < end){
            long mid = (start + end )/ 2;

//            System.out.println(getCount(mid));
            if(getCount(mid)  >= TARGET){
                start = mid +1;

            }else{ // count < target
                end = mid;
            }
        }

    }

    static int getCount(long mid){
        int count = 0;

        for(int lan : lans){
            count += lan / mid;
        }

        return count;
    }
}
//4 11
//802
//743
//457
//539
