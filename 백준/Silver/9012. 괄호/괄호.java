

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            if(isVPS(br.readLine())){
                sb.append("YES").append('\n');
            }else
                sb.append("NO").append('\n');
        }
        System.out.println(sb);
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
