
import java.util.Scanner;

public class Main {
    static int[] input;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        input = new int[N];

        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }


        if(np()){
            for(int x : input){
                System.out.print(x + " ");
            }
        }else{
            System.out.println(-1);
        }

    }

    static boolean np(){
        // step 1 : 꼭대기 찾기 i - 1
        int i = N - 1;
        while(i > 0 && input[i - 1] >= input[i])
            i--;

        //
        if( i == 0)
            return false;

        // step2 : i -1 보다 살짝  큰놈 찾기
        int j = N - 1;
        while(input[i - 1] >= input[j])
            j--;

        // step3 swap~
        swap(i-1, j);

        // step4 : 오른쪽 정렬해주면 됌
        int k = N-1;
        while(i < k )
            swap(i++, k--);

        return true;
    }

    public static void swap(int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}

//5
//5 4 3 2 1
