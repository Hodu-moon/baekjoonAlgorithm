import java.util.*;

public class Main {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int max_num = 1,min_num = 1000000;
        for(int i = 0; i < num; i++){
            int input = scanner.nextInt();
            if(max_num < input){
                max_num = input;
            }
            if(min_num > input){
                min_num = input;
            }
        }
        System.out.print(max_num * min_num);
    }
}
