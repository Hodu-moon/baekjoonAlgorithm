
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int su = scanner.nextInt();
        for(int s = 0; s < su; s++) {
            int count = 1;

            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int x = scanner.nextInt()-1;
            int y = scanner.nextInt()-1;
            //  3 4 달력 3 2가 무슨값인지 찾고싶으면
            //  x에서 + M 하면 x값이 동일하다 y에서 + N하면 y값이 동일하다
            //   i % N  6 % 4 == 2  <3, 2> 값이나온다.
            //  <1 ,1>  <1, 4> <1 ,3> <1 ,2>
            //  <2 ,2>  <2, 1> <2 ,4> <2 ,3>
            //  <3 ,3>  <3, 2> <3 ,1> <3 ,4>
            boolean check;

                check = false;
                for(int i = x; i < (M * N); i += M){
                    if(i % N == y){
                        System.out.println(i+1);
                        check = true;
                        break;
                    }
                }
                if(!check){
                    System.out.println(-1);
                }


//            while (true) {
//                if (m_count == x && n_count == y) {
//                    break;
//                }
//
//                if( ++m_count  > M){
//                    m_count = 1;
//                }
//                if(++n_count > N){
//                    n_count = 1;
//                }
//                //m_count = (m_count + 1) % M;
//                //n_count = (n_count + 1) % N;
//                count++;
//                if(m_count == M -1 && n_count == N -1){
//                    count = -1;
//                    break;
//                }
//            }
//            System.out.println(count);
        }

    }
}
