
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{


    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return  a - b;
        } );

        for(int i = 0; i < N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        long sum = 0;

        while(pq.size() != 1){
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b);
            sum += (a + b);

        }

        System.out.println(sum);
    }

}
//3
//10
//20
//40
