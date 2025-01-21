import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
                Scanner sc = new Scanner(System.in);

        int sum = 0;

        int[] arr = new int[9];
        for(int i = 0; i < 9; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        Arrays.sort(arr);        

        int first = 0, second  = 0;

        

        for(int i = 0; i < 9; i++){
            first = i;
            for(int j = 0; j < 9; j++){
                int sum1 = sum;

                if(i != j){
                    sum1 -= arr[i];
                    sum1 -= arr[j];
                    second = j;
                }                


                if(sum1 == 100){
                    for(int k = 0; k < 9; k++){
                        if(k != first && k != second){
                         System.out.println(arr[k] );
                        }
                     }

                    return;
                }
            }
            
        }
    
 
        
        

        


    }
}
