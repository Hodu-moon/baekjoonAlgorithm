

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        for(int i = 0; i < num; i++){
            if(isVPS(in.next())){
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
    }
    static public boolean isVPS(String s){

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}
