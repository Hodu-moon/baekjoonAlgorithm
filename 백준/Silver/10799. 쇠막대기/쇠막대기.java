
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String user = br.readLine();

        Stack<Character>  stack = new Stack<>();
        int N = 0;
        for(int i = 0; i < user.length(); i++){
            if (user.charAt(i) == '(' && user.charAt(i+1) == ')') {
                if(!stack.empty()) {
                    N = N + stack.size();
                    i++;
                }
            }
            else if(user.charAt(i) == '(') {
                stack.push('C');
                N++;
            }
            else if(user.charAt(i) == ')')
                if(!stack.empty())
                    stack.pop();


        }
        System.out.println(N);
    }


}
