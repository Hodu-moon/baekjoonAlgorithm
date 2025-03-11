
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> lans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        long max = 0;
        for(int i = 0; i < N;i++){
            int lan = sc.nextInt();
            lans.add(lan);

            max = Math.max(max, lan);
        }

        max++;
        long min = 0;
        long mid = 0;

        while(min < max){

            mid = (min + max) / 2;

            long count = 0;
            for(int lan : lans){
                count += (lan / mid);
            }

            // 800 400  인데 3개로 자르라함
            // 800으로 자름 그러면 1임
            // 부족함 줄여야함
            if(count < M){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(min - 1);



    }

}

//4 11
//802
//743
//457
//539