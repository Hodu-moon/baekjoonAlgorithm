
import java.util.Scanner;

public class Main{
    static int[] array;
    static int max = 1;
    static  int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        array = new int[N];
        for(int i = 0;  i < N; i++){
            array[i] = sc.nextInt();
        }

        int in = 1;
        int de = 1;
        for(int i = 1; i < N; i++){
            // 1 2
            if(array[i - 1] <= array[i ]){
                in++;
            }else {
                in = 1;
            }
            // 2 1
            if(array[i] <= array[i - 1]){
                de++;
            }else
                de = 1;

            max = Math.max(max, Math.max(in, de));
        }

        System.out.println(max);
    }


}
