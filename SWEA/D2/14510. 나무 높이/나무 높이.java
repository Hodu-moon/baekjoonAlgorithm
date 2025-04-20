
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, maxHeight, result;
    static int[] trees;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            trees = new int[N];
            maxHeight = 0;
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }

            solve();


            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb);

    }

    static void solve(){

        int even = 0;
        int odd = 0;

        for(int i = 0; i < N; i++){
            int difference =  maxHeight - trees[i];

            if(difference == 0)
                continue;

            even += difference / 2;
            odd += difference % 2;

        }

        if(odd < even){
            while(Math.abs(even - odd)  > 1){
                even--;
                odd += 2;
            }
        }

        // 계산 시작
        if(odd > even){
            result = odd * 2 - 1;
        }else if(odd < even){
            result = even * 2;
        }else { // odd == even
            result = even + odd;
        }



    }

}

//50
//2
//5 5
