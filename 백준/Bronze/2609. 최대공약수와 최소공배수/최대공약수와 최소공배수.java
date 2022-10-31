import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int min_gong =1;

        for(int i = 2; i <= (Math.max(num1, num2)); i++ ){
            while(true) {
                if(num1 % i != 0 | num2 % i != 0 ){
                    break;
                }
                num1 /= i;
                num2 /= i;
                min_gong *= i;

            }
        }
        System.out.println(min_gong);
        System.out.println(min_gong * num1 * num2);
    }
}
