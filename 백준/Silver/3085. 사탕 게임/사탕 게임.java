
import java.util.Scanner;

public class Main {
    static char [][]Candy;
    public static int MaxCOUNT = 0;

    public static void main(String []args){
        makeCandy();
        for(int i = 0; i < Candy.length; i++){
            checkLow(i);
            checkCol(i);
        }

        swapCandyAndColCheck();
        swapCandyAndLowCheck();
        System.out.println(MaxCOUNT);

    }
    public static void swapCandyAndLowCheck(){
        for(int i = 0; i < Candy.length; i++){
            for(int j= 0; j < Candy.length-1; j++){
                if(Candy[i][j] != Candy[i][j+1]){
                    char tmp = Candy[i][j];
                    Candy[i][j] = Candy[i][j+1];
                    Candy[i][j+1] = tmp;

                    checkCol(j);
                    checkCol(j+1);
                    checkLow(i);

                    Candy[i][j+1] = Candy[i][j];
                    Candy[i][j] = tmp;
                }
            }
        }
    }
    public static void swapCandyAndColCheck(){
        for(int i = 0; i < Candy.length-1; i++){
            for(int j = 0; j < Candy.length; j++){
                if(Candy[i][j] != Candy[i+1][j]){
                    char tmp = Candy[i][j];
                    Candy[i][j] = Candy[i+1][j];
                    Candy[i+1][j] = tmp;

                    checkLow(i);
                    checkLow(i+1);
                    checkCol(j);

                    Candy[i+1][j] = Candy[i][j];
                    Candy[i][j] = tmp;

                }
            }
        }
    }

    public static void checkLow(int x){
        int count = 1;
        for(int y = 0; y < Candy.length-1; y++){
            if(Candy[x][y] == Candy[x][y+1]){
                count++;
            }
            else
                count = 1;
            MaxCOUNT = Math.max(MaxCOUNT, count);
        }
    }
    public static void checkCol(int y){
        int count = 1;
        for(int x = 0; x < Candy.length-1; x++){
            if(Candy[x][y] == Candy[x+1][y]){
                count++;
            }
            else
                count = 1;
            MaxCOUNT = Math.max(MaxCOUNT, count);
        }
    }
    public static void makeCandy(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Candy = new char[n][n];
        for(int i = 0; i < Candy.length; i++){
            String s = scanner.next();
            for(int j = 0; j < Candy[i].length; j++){
                Candy[i][j] = s.charAt(j);
            }
        }
    }
    public static void printCandy(){
        for (char[] chars : Candy) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
