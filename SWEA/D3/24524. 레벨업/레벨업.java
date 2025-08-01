import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

// 68 개중 60개 맞춤
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T ; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getResult(arr)).append("\n");


        }

        System.out.println(sb);
    }

    private static int getResult(int[] arr){

        int sum = 0;
        int maxAdvantage = 0;

        for(int i = 0; i < arr.length - 1; i++){
            sum += getDistance(arr[i],  arr[i + 1]);

            // 일때만
            if( 1 <= i && i < arr.length - 1){
                int totalDistance = getDistance(arr[i - 1], arr[i]) + getDistance(arr[i], arr[i + 1]);
                int ifAdvantage = getDistance(arr[i - 1] , arr[i + 1]);


                if(maxAdvantage < totalDistance - ifAdvantage ){
                    maxAdvantage = totalDistance - ifAdvantage;

//                    System.out.println("max Advantage change i :" + i);
//                    System.out.println("max advantage : " + maxAdvantage);
//                    System.out.println("totalDistance : " + totalDistance);
//                    System.out.println("ifAdvantage : " + ifAdvantage );
//                    System.out.println();
                }
                maxAdvantage = Math.max(maxAdvantage, totalDistance - ifAdvantage);
            }
        }

//        System.out.println("total distance = " + sum);
//        System.out.println("max Advantage = " + maxAdvantage);



        return sum - maxAdvantage;
    }

    private static int getDistance(int x, int y){
        return Math.abs(y - x);
    }



}


//3
//5
//1 -1 2 -2 3
//3
//1 2 3
//3
//1 -1 3

// 2 + 3 + 4 + 5
// 4 + 5 -> 1    -8

// 6
// 2
// 2