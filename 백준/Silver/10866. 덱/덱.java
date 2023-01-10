
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            String users[] = br.readLine().split(" ");
            if(users.length == 2){
                if(users[0].equals("push_back")){
                    deque.addLast(Integer.parseInt(users[1]));

                } else if (users[0].equals("push_front")) {
                    deque.addFirst(Integer.parseInt(users[1]));
                }
            }else{
                if(users[0].equals("pop_front")){
                    if(deque.isEmpty()){
                        sb.append(-1);
                    }else 
                        sb.append(deque.removeFirst());
                    sb.append("\n");
                } else if (users[0].equals("pop_back")) {
                    if(deque.isEmpty()){
                        sb.append(-1);
                    }else
                        sb.append(deque.removeLast());
                    sb.append("\n");
                } else if (users[0].equals("size")) {
                    sb.append(deque.size());
                    sb.append("\n");
                } else if (users[0].equals("empty")) {
                    if(deque.isEmpty()){
                        sb.append(1);
                    } else  {
                        sb.append(0);
                    }
                    sb.append("\n");
                } else if (users[0].equals("front")) {
                    if(deque.isEmpty()){
                        sb.append(-1);
                    }else
                        sb.append(deque.peekFirst());
                    sb.append("\n");
                } else if (users[0].equals("back")) {
                    if(deque.isEmpty()){
                        sb.append(-1);
                    }else
                        sb.append(deque.peekLast());
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());

    }

}
