
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, TARGET;
    static long result, end;
    static int[] trees;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        TARGET = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new int[N];
        for(int i = 0; i < N; i++ ){
            trees[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, trees[i]);
        }

        solve();

        System.out.println(end - 1);
    }

    static void solve(){
        long start = 0;
        long sum = 0;

        while(start < end){
            long mid = (start + end) / 2;

            // mid로 자른 나무 합 구하기
            sum = cutTree(mid);
//            System.out.println("here");


            if(TARGET <= sum){
                start = mid + 1;
            }else{ // TARGET > sum
                 end = mid;
            }
        }



    }

    static long cutTree(long mid){

        long sum = 0;
        for(int i = 0; i < N; i++){
            sum += Math.max(trees[i] - mid, 0);
        }
        return sum;
    }
}


//4 7
//20 15 10 17