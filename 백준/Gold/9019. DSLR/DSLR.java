
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int T;
    static StringBuilder sb = new StringBuilder();

    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Arrays.fill(visited, false);
            sb.append(BFS(A, B)
            ).append("\n");
        }


        System.out.println(sb);
    }


    static String BFS(int A, int B){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(A, ""));
        visited[A] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(current.value == B){
                return current.path;
            }

            int D = (current.value * 2) % 10000;
            int S = current.value == 0 ? 9999 : current.value - 1;
            int L = (current.value % 1000) * 10 + current.value / 1000;
            int R = (current.value % 10 ) * 1000 + (current.value / 10) ;

            if(!visited[D]){
                visited[D] = true;
                queue.offer(new Node(D, current.path + "D"));
            }

            if(!visited[S]){
                visited[S] = true;
                queue.offer(new Node(S, current.path + "S"));
            }

            if(!visited[L]){
                visited[L] = true;
                queue.offer(new Node(L, current.path + "L") );
            }

            if(!visited[R]){
                visited[R] = true;
                queue.offer(new Node(R, current.path +"R"));
            }
        }

        return "";
    }

    static class Node{
        int value;
        String path ;

        public Node(int current, String path) {
            this.value = current;
            this.path = path;
        }
    }
}


//3
//1234 3412
//1000 1
//1 16
