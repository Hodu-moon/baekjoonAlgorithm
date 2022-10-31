import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        long sum = 0;
        for(int i = 1; i <= x; i++){
            for(int j = 0; j < x / i; j++){
                sum += i;
            }
        }


        /*
        for(int i= 1; i<= x ; i++){
            for(int j = 1; j<= Math.sqrt(i); j++){
                if(i % j == 0 ){
                    if(i != 1 & i/j != j) {
                        sum += i / j;
                    }
                    sum += j;
                }
            }
        }
        // --------------------------------


        for(int i=1; i <= x; i++){
            for(int j = 1; j <= i; j++){
                if( i % j == 0){
                    sum += j;
                }
            }
        }
         */

        System.out.print(sum);
    }
}
