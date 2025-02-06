
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int winner; // 검 1 흰 2
    static int winnerX;
    static int winnerY;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[19][19];

        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(checkWinner(i, j)){
                    System.out.println(winner);
                    System.out.println(winnerX + " " + winnerY);
                    return;
                }
            }
        }

        System.out.println(0);



    }

    static boolean checkWinner(int x, int y) {
        int temp = arr[x][y];

        if (temp == 0)
            return false;

        if (checkWinner1(x, y, temp) || checkWinner2(x, y, temp) || checkWinner3(x, y, temp)
                || checkWinner4(x, y, temp)) {
            winner = temp;
            winnerX = x + 1;
            winnerY = y + 1;
            return true;
        }


        return false;
    }
        static boolean checkWinner1(int x, int y, int temp){
        for(int i = 1; i < 5; i++){
            int nx = x + i;
            // 세로
            if(!isIn(nx, y) || temp != arr[nx][y] )
                return false;
        }


        if(isIn(x + 5, y) && arr[x + 5][y] == temp){
            return false;
        }

        if(isIn(x - 1, y) && arr[x - 1][y] == temp){
            return false;
        }

        return true;
    }



        static boolean checkWinner2(int x, int y, int temp){

        for(int i = 1; i < 5; i++){
            int ny = y + i;
            if(!isIn(x, ny) || temp != arr[x][ny])
                return false;
        }
        // 1 1 1 1 1 1
        //   1 2 3 4 5
        if(isIn(x, y + 5) && temp == arr[x][y + 5]) {
            return false;
        }

        if(isIn(x, y -1) && temp == arr[x][y - 1]){
            return false;
        }

        return true;

    }

        static boolean checkWinner3(int x, int y, int temp){
        for(int i = 1; i < 5; i++){
            int nx = x + i;
            int ny = y + i;

            if(!isIn(nx, ny) || temp != arr[nx][ny ])
                return false;
        }

        if(isIn(x + 5, y + 5) && arr[x + 5][y + 5] == temp){
            return false;
        }

        if(isIn(x - 1, y - 1) && arr[x - 1][y - 1] == temp){
            return false;
        }

        return true;
    }





    static boolean checkWinner4(int x, int y, int temp){
        for(int i = 1; i < 5; i++){
            int nx = x - i;
            int ny = y + i;

            if(!isIn(nx, ny) || temp != arr[nx][ny ])
                return false;
        }

        if(isIn(x -5, y + 5) && arr[x -5][y + 5] == temp){
            return false;
        }

        if(isIn(x + 1, y -1 ) && arr[x + 1][y -1 ] == temp){
            return false;
        }

        return true;
    }
    static boolean isIn(int x, int y){
        return x >= 0 && x < 19 && y >=0 && y < 19;
    }
}

//        2 2 2 2 2 2 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0
//        0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0
//        0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 1 1 0 1 0 0 0 0 0 0 1 0 0 0 0 0 0
//        0 0 0 0 0 0 2 1 0 0 0 1 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 2 2 2
