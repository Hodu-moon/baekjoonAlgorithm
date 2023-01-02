

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> left = new Stack<Character>();
        Stack<Character> right = new Stack<Character>();

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        for(int j = 0; j < s.length(); j++){
            left.push(s.charAt(j));
        }
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            String user = br.readLine();
            switch (user.charAt(0)){
                case 'L':
                    if(!left.empty())
                        right.push(left.pop());
                    break;
                case 'D':
                    if(!right.empty())
                        left.push(right.pop());
                    break;
                case'B':
                    if(!left.empty())
                        left.pop();
                    break;
                case 'P':
                    left.push(user.charAt(2));
                    break;
            }
        }

        while(!left.empty()){
            right.push(left.pop());
        }

        while(!right.empty()){
            sb.append(right.pop());
        }

        System.out.println(sb.toString());
    }
}
