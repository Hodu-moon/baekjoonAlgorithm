
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] map = new int[1002][1002];

        for(int i = 0; i < N; i++){
            int x,y,p,q;
            x = sc.nextInt();
            y = sc.nextInt();
            p = sc.nextInt();
            q = sc.nextInt();

            for(int j = x; j < x + p  ; j++){
                for(int k = y; k < y + q; k++){
                    map[j][k] = i + 1;
                }
            }

        }

        int[] arr = new int[N + 1];
        int count = 1;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                arr[map[i][j]] += 1;
            }
        }

        for(int i = 1; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
// 2
//0 0 10 10
//2 2 6 6
