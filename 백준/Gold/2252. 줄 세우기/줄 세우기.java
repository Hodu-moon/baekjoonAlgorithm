
import java.util.*;

public class Main{
    static int[] inDegree;
    static int N, M;
    static List<List<Integer>> lists = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        inDegree = new int[N + 1];

        for(int i = 0; i <= N; i++){
            lists.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int before = sc.nextInt();
            int next = sc.nextInt();

            lists.get(before).add(next);
            inDegree[next]++;

        }

        topologySort();

        System.out.println(sb);
    }

    public static void topologySort(){
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                queue.add(i);
                sb.append(i).append(" ");
            }
        }

        while(!queue.isEmpty()){
            int before = queue.poll();

            for(int next : lists.get(before)){
                inDegree[next]--;

                if(inDegree[next] == 0){
                    sb.append(next).append(" ");
                    queue.add(next);
                }
            }
        }

    }
}
//3 2
//1 3
//2 3

// 1 2 3
