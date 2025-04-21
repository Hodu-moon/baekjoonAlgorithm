
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static long result;
    static Worm[] worms;

    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            worms = new Worm[N];
            isSelected = new boolean[N];
            result = Long.MAX_VALUE;

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                worms[i] = new Worm(x, y);
            }

            back(0, 0);



            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb);

    }
    static void back(int depth, int selectedCount){
        if(selectedCount == N / 2){

            long rowSum = 0;
            long colSum = 0;

            for(int i = 0; i < N; i++){

                if(isSelected[i]){
                    rowSum += worms[i].x;
                    colSum += worms[i].y;
                }else{
                    rowSum -= worms[i].x;
                    colSum -= worms[i].y;
                }



            }

            long temp = rowSum * rowSum + colSum * colSum;
            result = Math.min(result, temp);


            // 계산
            return;
        }

        // 다 봤으면 종료
        if(depth == N){
            return;
        }


        isSelected[depth] = true;
        back(depth + 1, selectedCount + 1);

        isSelected[depth] = false;
        back(depth + 1, selectedCount );
    }

    static class Worm{
        int x, y;

        public Worm(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
//2
//4
//6 0
//3 3
//-7 2
//-4 -1
//2
//-100000 100000
//100000 -100000
