
import java.util.Scanner;

public class Main {
    //3
    //3 7
    //15 7
    //5 2
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        map = new int[100][100];

        for(int i = 0; i < N; i++){
            int left = sc.nextInt();
            int bottom = sc.nextInt();

            fillMap(left, bottom);

        }

        int count = 0;
        for(int[] x : map){
            for(int y : x){
                if(y == 1){
                    count++;
                }
            }
        }

        System.out.println(count);

    }


    public static void fillMap(int left, int bottom){
        for(int i = left; i < left + 10; i++){
            for(int j = bottom; j < bottom + 10; j++){
                map[i][j] = 1;
            }
        }
    }
}
