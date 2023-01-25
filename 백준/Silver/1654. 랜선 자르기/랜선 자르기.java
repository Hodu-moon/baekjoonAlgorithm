
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        long []array = new long[K];

        long max = 0;
        for(int i = 0; i < K; i++){
            array[i] = scanner.nextInt();
            if(max < array[i])
                max = array[i];
        }
        //??
        max++;

        long min = 0;
        long mid = 0;

        while(min < max){
            mid = (min + max) / 2 ; //이게 이진탐색이다.
            long 몫 = 0;
            for (int i = 0; i < K; i++) {
                몫 += array[i] / mid;
            }
            if( 몫 < N ){
                max = mid;
            }else {
                min = mid + 1; //
            }
        }
        //upper bound 라고 하는데 정말이지 무슨소린지. 모르겠다.

        System.out.println(min -1);




        //2 흐음 이진 탐색을 제대로 이해하지 못하고 있따.
//        while(true) {
//            몫 = 0;
//            for (int i = 0; i < K; i++) {
//                몫 += array[i] / mid;
//            }
//            if (몫 == N) {
//                System.out.println(mid);
//                return;
//            } else if (몫 < N) {
//                max = mid +1;
//                mid = (mid + min) / 2;
//
//            } else if (몫 > N) {
//                min = mid +1;
//                mid = (mid + max) / 2;
//            }
//        }




        /*
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        long []array = new long[K];
        long sum = 0;

        for(int i = 0; i < K; i++){
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        sum = sum/K;

        long 몫 = 0;

        for(long i = sum; i > 0; i--){
            몫 = 0;

            for(int j = 0; j < K; j++){
                몫 += array[j]/i;
            }

            if(몫 == N){
                System.out.println(i);
                return;
            }

        }
           */

    }
}
