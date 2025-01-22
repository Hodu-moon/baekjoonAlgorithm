
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        int C = sc.nextInt();;
        int R = sc.nextInt();
        int user = sc.nextInt();



        int[][] map = new int[R][C];

        // 좌석 배정 X
        if( user > C * R){
            System.out.println(0);
            return;
        }

        int count = 0;

        int left = 0;
        int right = C -1;
        int bottom = 0;
        int top = R -1;

        int x = 0, y = 0;

        while(left <= right && bottom <= top ){

            for(int i = bottom; i <= top; i++){
                map[i][left] = ++count;

                if(count == user){
                    x = i;
                    y = left;
                }
            }

            left++;

            for(int i = left; i <= right; i++){
                map[top][i] = ++count;

                if(count == user){
                    x = top;
                    y = i;
                }
            }
            top--;
            for(int i = top; i >= bottom; i--){
                map[i][right] = ++count;

                if(count == user){
                    x = i;
                    y = right;
                }
            }
            right--;

            for(int i = right;  i >= left ; i--){
                map[bottom][i] = ++count;

                if(count == user){
                    x = bottom;
                    y = i;
                }
            }
            bottom++;
        }

        x ++;
        y++;
        System.out.println( y  + " " + x );




    }
}
