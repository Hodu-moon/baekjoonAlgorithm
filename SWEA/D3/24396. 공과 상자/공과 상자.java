import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T;t++){
            int B, W, blackCost, whiteCost, changeCost;
            StringTokenizer st = new StringTokenizer(br.readLine());
            B = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            blackCost = Integer.parseInt(st.nextToken());
            whiteCost = Integer.parseInt(st.nextToken());
            changeCost = Integer.parseInt(st.nextToken());

            int firstCondition = (B * blackCost) + (W * whiteCost);

            int secondCondition;

            if(B < W){
                // 4 1
                //
                int wRemain = W - B;
                secondCondition = changeCost * B * 2 + wRemain * whiteCost;
            }else if(W < B){
                int bRemain = B - W;
                secondCondition = changeCost * W * 2 + bRemain * blackCost;
            }else{
                secondCondition = changeCost * B * 2;
            }




            sb.append(Math.max(firstCondition, secondCondition)).append("\n");
        }

        System.out.println(sb);
    }
}

//
//
//3
//        2 2 1 1 0
//        9 9 -11 -11 11
//        15 19 -2 4 -3
