import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Queue<Integer> queue;

    static int[] count;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        queue.offer(N);
        count =  new int[100001];
        check = new boolean[1000001];
        Arrays.fill(count, 200000);

        count[N] = 0;
        check[N] = true;


        while(true){
            int x = queue.poll();

            if(x == K){
                System.out.println(count[K]);
                break;
            }

            bfs(x - 1, x );
            bfs(x + 1, x);
            bfs( x * 2, x);


        }

    }
    static void bfs( int nx, int x){

        if( nx >= 0 && nx <= 100000 && !check[nx]) {
            check[nx] = true;

            queue.offer(nx);
            int new_count = count[x] + 1;
            if (count[nx] > new_count) {
                count[nx] = new_count;
            }
        }

    };
}
