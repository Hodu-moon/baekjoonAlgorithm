import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static  int[][] map;
    static Map<Integer, int[]> hashMap;
    static int[][] bingo;
    static int count = 0;
    static int bingoCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[5][5];
        hashMap = new HashMap<>();

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                map[i][j] = sc.nextInt();
                hashMap.put(map[i][j], new int[]{i, j});
            }
        }

        bingo = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                bingo[i][j] = sc.nextInt();
            }
        }

        // bingo 횟수 


        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                count++;
                int[] xy = hashMap.get(bingo[i][j]);


                map[xy[0]][xy[1]] = 0;


                // check 

                checkColumn(xy[1]);
                if(bingoCount == 3){
                    System.out.println(count);
                    return;
                }

                

                checkRow(xy[0]);
                if(bingoCount == 3){
                    System.out.println(count);
                    return;
                }

                if(xy[0] == xy[1] ){
                    checkCross1();
                    if(bingoCount == 3){
                        System.out.println(count);
                        return;
                    }
                }

                if(xy[0] + xy[1] == 4 ){
                    checkCross2();
                    if(bingoCount == 3){
                        System.out.println(count);
                        return;
                    }
                }



            }
        }
    }

    public static void checkCross1(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i == j && map[i][j] != 0){
                    return;
                }
            }
        }
        // System.out.println("_2578.checkCross1()");
        bingoCount++;
    }

    public static void checkCross2(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i + j == 4 && map[i][j] != 0){
                    return;
                }
            }
        }
        // System.out.println("_2578.checkCross2()");
        bingoCount++;
    }

    public static boolean isCorss(int x, int y) {
        
        return x == y || x + y == 4;
    }



    public static void checkColumn(int c){
         for(int i = 0; i < 5; i++){
            if(map[i][c]  != 0){
                return;
            }
        }    
        // System.out.println("_2578.checkColumn()");
        bingoCount++;
    }

    public static void checkRow(int c){
        for(int i = 0; i < 5; i++){
            if(map[c][i]  != 0){
                return;
            }
        }    
        // System.out.println("_2578.checkRow()");
        bingoCount++;
    }

    static void printMap(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.printf("%4d" , map[i][j]);
            }
            System.out.println();
        }
    }

  
}
