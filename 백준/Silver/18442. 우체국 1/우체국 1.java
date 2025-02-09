
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int V, P;
    static long L;
    static long[] villages;
    // 조합 뽑아내기 용
    static long[] tempVillages;

    // 대충
    static long[] resultPost;
    static long resultMin = Long.MAX_VALUE;

    static long[] realPost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        P = sc.nextInt();
        L = sc.nextLong();

        villages = new long[V];
        tempVillages = new long[P];
        resultPost = new long[P];
        realPost = new long[P];

        for (int i = 0; i < V; i++) {
            villages[i] = sc.nextLong();
        }

        // V개의 마을 중 순서를 고려하지 않고 P개를 뽑음
        back(0, 0);

        System.out.println(resultMin);
        for(long x : realPost){
            System.out.print(x + " ");
        }

    }

    static void back(int depth, int start) {
        // 기저 부분
        if(depth == P){
            checkDiff();
            return;
        }

        // 유도 부분
        for(int i = start; i < V; i++){
            resultPost[depth] = villages[i];
            back(depth + 1, i + 1);
        }
    }

    // resultPost 우체극들의 위치
    //resultMin 결과
    static void checkDiff(){
        long sumDist = 0;
        for(int i = 0; i < V; i++){ // 각 마을을 돌면서
            long minDist = Long.MAX_VALUE;
            for(int p = 0; p < P; p++){ // 우체국과의 거리를 셈
                long diff1 = Math.abs(villages[i] - resultPost[p]); // 9 3 이면 |9 - 3|, |3 - 9|
                long diff2 = L - Math.max(villages[i], resultPost[p] ) + Math.min(villages[i], resultPost[p] ) ; // L 12 , 3, 9
                // 12 - 9 + 3

                long realDiff = Math.min(diff1, diff2);
                if(realDiff < minDist){
                    minDist = realDiff;
                }

            }
            sumDist += minDist;

        }


        if(sumDist < resultMin){
            resultMin = sumDist;
            realPost = resultPost.clone();
        }

    }


}
// N  V  L
// 10 5 200
//1 2 3 6 7 9 11 22 44 50
