
import java.util.Scanner;

public class Main {

    static int[] OPPOSITE = {5, 3, 4, 1,2, 0  }; // A - F , B - D, C - E

    // MAXSide

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] dices = new int[N][6];


        for(int i = 0; i < N; i++){
            for(int j = 0; j < 6; j++){
                dices[i][j] = sc.nextInt();
            }
        }

        int maxDiceSum = 0;

        for(int topIdx = 0; topIdx < 6; topIdx++){
            int topValue = dices[0][topIdx]; // 주사위의 윗면 값
            int bottomValue = dices[0][OPPOSITE[topIdx]]; // 주사위의 아랫면 값

            int sum = getMaxSide(dices[0], OPPOSITE[topIdx] , topIdx);

            for(int dicesNum = 1; dicesNum < N; dicesNum++){
                int newBottomIdx = findIndex(dices[dicesNum], topValue);
                topValue = dices[dicesNum][OPPOSITE[newBottomIdx]];

                sum += getMaxSide(dices[dicesNum], newBottomIdx, OPPOSITE[newBottomIdx]);

            }
            maxDiceSum = Math.max(maxDiceSum, sum);

        }


        System.out.println(maxDiceSum);
    }

    static int getMaxSide(int[] dice, int bottomIdx, int topIdx){
        int max = 0;
        for(int i = 0; i < 6; i++){
            if(i != bottomIdx &&  i != topIdx){
                max = Math.max(max, dice[i]);
            }
        }
        return max;
    }

    static int findIndex(int[] dice, int value){
        for(int i = 0; i < dice.length; i++){
            if(dice[i] == value){
                return i;
            }
        }

        return 0;
    }


}
