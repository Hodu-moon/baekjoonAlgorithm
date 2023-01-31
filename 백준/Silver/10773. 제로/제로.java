
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;
        int recent = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int a = scanner.nextInt();
            if(a == 0){
                sum -= stack.pop();
            }else
                sum += stack.push(a);
        }



//        for(int i = 0; i< N; i++){
//            int a = scanner.nextInt();
//            if(a == 0){
//                sum -= recent;
//            }else {
//                recent = a;
//                sum += a;
//            }
//        }
        System.out.println(sum);
    }
}
