
import java.util.Scanner;

public class Main {
    static int[][] map;

    static int R, C, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];
        sc.nextLine();

        for(int r = 0; r < R; r++){
            String input = sc.nextLine();
            for(int c = 0; c < C; c++){
                map[r][c] = input.charAt(c) == 'x' ? 1 : 0;
            }
        }

        for(int r = 0; r < R; r++){
            if(check(r, 0))
                result++;
        }
        System.out.println(result);
    }

    static boolean check(int x, int y){
        map[x][y] = 1;

        if(y == C -1){
            return true;
        }

        // 위 직진 아래
        if(0 < x && map[x - 1][y + 1] == 0){
            if(check(x-1, y + 1))
                return true;
        }

        if( map[x][y + 1] == 0){
            if(check(x, y+1))
                return true;
        }

        if(x  < R -1 && map[x + 1][y + 1] == 0){
            if(check(x + 1, y + 1))
                return true;
        }

        return false;
    }
}
// R -> 1 10000
// C -> 5 500

// 5 5
//.xx..
//..x..
//.....
//...x.
//...x.