
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb =new StringBuilder();
        while(true){
            String user = br.readLine();
            if(user.equals(".")){
                break;
            }

            sb.append(solve(user)).append("\n");
        }
        System.out.println(sb);
    }

    public static String solve(String user){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < user.length();i++){
            char c = user.charAt(i);

            if(c == '(' || c == '['){
                stack.push(c);

            } else if (c == ')') {

                if(stack.empty() || stack.peek() != '('){
                    return "no";
                }else
                    stack.pop();

            } else if (c == ']') {

                if(stack.empty() ||  stack.peek() != '['){
                    return "no";
                }else
                    stack.pop();

            }

        }

        if(stack.empty()){
            return "yes";
        }else
            return "no";
    }
}
