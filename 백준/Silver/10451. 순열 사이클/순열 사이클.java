import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());

       int[] result = new int[T];

       for(int i = 0; i < T; i++){
           int N = Integer.parseInt(br.readLine());
           int[] arr = new int[N + 1];

           StringTokenizer st = new StringTokenizer(br.readLine());

           for(int j = 1; j <= N; j++){
               arr[j] = Integer.parseInt(st.nextToken());
           }

           int count = dfs(arr);
           result[i] = count;
       }


       for(int a : result){
           System.out.println(a);
       }
    }

    static int dfs(int[] arr ){
        // 1 ~ N 까지 수
        int count = 0;

        boolean[] check = new boolean[arr.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(arr[1]);
        check[1] = true;


        for(int i = 1; i < arr.length; i++){
            if(  !check[i] ){
                queue.offer(arr[i]);
            }

            while(!queue.isEmpty()){
                int current = queue.poll();
                int x = arr[current];
                check[current] = true;
                if(i == x){
                    count++;
                    break;
                }

                queue.offer(x);

            }
        }



        return count;
    }
}
