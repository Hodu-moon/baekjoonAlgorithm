
import java.util.*;

import static java.util.Arrays.sort;

public class Main {
    public static int su = 9;
    public static int[] dwarf;
    public static void main(String []args){

        makeDwarf();
        findDwarf();


    }
    public static void findDwarf(){
        int sum = 0;
        for(int i = 0; i < dwarf.length; i ++){
            sum += dwarf[i];
        }

        for(int i = 0; i < su; i++){
            for(int j = 0; j < su; j++){
                if(i != j) {
                    int sum1 = sum - dwarf[i] - dwarf[j];
                    if (sum1 == 100) {
                        for(int k = 0; k < su; k++){
                            if( ( k != i) & (k != j)){ // 여기까지
                                System.out.println(dwarf[k]);
                            }
                        }
                        return;
                    }
                }
            }
        }
    }
    public static void makeDwarf(){
        dwarf = new int[su];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < su; i++){
            dwarf[i] = scanner.nextInt();
        }

        sort(dwarf);
    }
    public static void printDwarf(){
        for(int i = 0; i < su; i++){
            System.out.print(" "+ dwarf[i]);
        }
    }
}
