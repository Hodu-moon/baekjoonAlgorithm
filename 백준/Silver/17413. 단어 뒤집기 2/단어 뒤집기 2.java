
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String user = bf.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < user.length(); i++){
            stack.push(user.charAt(i));
            if(user.charAt(i) == ' '){
                stack.pop();
                while(!stack.empty())
                    sb.append(stack.pop());

                sb.append(' ');
            } else if (i == user.length()-1 ) {
                while(!stack.empty())
                    sb.append(stack.pop());
            }else if(user.charAt(i) == '<'){
                stack.pop();
                while(!stack.empty())
                    sb.append(stack.pop());

                while(user.charAt(i) != '>'){
                    sb.append(user.charAt(i));
                    i++;
                }
                sb.append('>');

            }
        }
        System.out.println(sb.toString());
    }
}
