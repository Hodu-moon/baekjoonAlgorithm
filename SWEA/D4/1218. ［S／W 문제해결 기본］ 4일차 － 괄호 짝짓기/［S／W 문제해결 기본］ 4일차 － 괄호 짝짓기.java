
import java.util.*;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static Set<Character> left = new HashSet<>();
    static Set<Character> right = new HashSet<>();

    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        left.add('<');
        left.add('{');
        left.add('(');
        left.add('[');

        right.add('>');
        right.add('}');
        right.add(')');
        right.add(']');


        for(int t = 1; t <= 10; t++){
            Deque<Character> stack = new ArrayDeque<>();
            int N = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();
            flag = false;
            sb.append("#").append(t).append(" ");

            for(int i = 0; i < N; i++){
                char a = input.charAt(i);
                if(left.contains(a)){
                    stack.push(a);
                }else{ // right
                    char x  = stack.pop();
                    if(a == '>'){
                        if(x != '<'){
                            flag = true;
                            break;
                        }
                    }else if(a == '}'){
                        if(x != '{'){
                            flag = true;
                            break;
                        }
                    }else if(a == ')'){
                        if(x != '('){
                            flag = true;
                            break;
                        }
                    }else if(a == ']'){
                        if (x != '[') {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            if(flag){
                sb.append(0);
            }else
                sb.append(1);
    
            sb.append("\n");
        }
        System.out.println(sb.toString());
        
    }

    
}

//10
// P{{:LM>?M>?}}