
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[][] students = new int[2][6];

        for(int i = 0; i < N; i++){
            int S = sc.nextInt();
            int G = sc.nextInt();

            students[S][G - 1] += 1;
        }

        int result = 0;

        for(int i = 0; i < students.length; i++){
            for(int j = 0; j < students[1].length; j++){
                result += students[i][j] / k;

                int mod = students[i][j] % k;
                if(mod > 0){
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
//16 2
//1 1
//0 1
//1 1
//0 2
//1 2
//0 2
//0 3
//1 3
//1 4
//1 3
//1 3
//0 6
//1 5
//0 5
//1 5
//1 6
