
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int start =0;
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());

            if(start < value) {
                for (int j = start + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append("+").append('\n');
                }
                start = value;
            }
            else if(stack.peek() != value) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }

            stack.pop();
            sb.append("-").append('\n');
        }

        System.out.println(sb.toString());
    }
}
