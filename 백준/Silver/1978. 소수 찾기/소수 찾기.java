import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = num;

        for(int i = 0; i < num; i++){
            int x = scanner.nextInt();
            //if 소수이면 카운트 +1
            if(x == 1){
                count--;
            }
            for(int j = 2; j < x; j++){
                if(x % j == 0){
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);

    }
}
