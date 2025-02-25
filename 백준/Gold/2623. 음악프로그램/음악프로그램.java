
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> lists;
    static int[] inDegree;
    static Queue<Integer> result;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        lists = new ArrayList<>();
        inDegree = new int[N + 1];
        for(int i = 1; i <= N + 1; i++){
            lists.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int K = sc.nextInt();
            int before = sc.nextInt();
            for(int j = 1; j < K; j++){
                int s = sc.nextInt();
                lists.get(before).add(s);
                inDegree[s]++;

                before = s;
            }
        }

        topologySort();

        if(result.size() != N){
            System.out.println(0);
        }else{
            while(!result.isEmpty()){
                System.out.println(result.poll() + " ");
            }
        }
        

    }
    static void topologySort(){
        Queue<Integer> queue = new ArrayDeque<>();
        result = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            result.add(now);

            for(int next : lists.get(now)){
                inDegree[next]--;

                if(inDegree[next] == 0)
                    queue.offer(next);
            }
        }



    }

}
