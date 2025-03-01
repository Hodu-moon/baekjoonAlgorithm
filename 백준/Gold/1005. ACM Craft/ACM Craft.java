

import java.util.*;

public class Main {
    static int[] inDegree, times, result;

    static int N, K, W;
    static List<List<Integer>> lists;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            N = sc.nextInt();
            K = sc.nextInt();
            inDegree = new int[N + 1];
            times = new int[N + 1];
            result = new int[N + 1];

            lists = new ArrayList<>();
            lists.add(new ArrayList<>());
            for(int i = 1; i <= N; i++){
                times[i] = sc.nextInt();
                lists.add(new ArrayList<>());
            }

            for(int i = 0; i < K; i++){
                int before = sc.nextInt();
                int next = sc.nextInt();
                lists.get(before).add(next);
                inDegree[next]++;
            }

            W = sc.nextInt();

            topologySort();
            System.out.println(result[W]);
        }

    }
    static void topologySort(){
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                queue.add(i);
                result[i] = times[i];
            }
        }

        while (!queue.isEmpty()){
            int before = queue.poll();

            for(int next : lists.get(before)){
                inDegree[next]--;

                result[next] = Math.max(result[next], result[before] + times[next]);

                if(inDegree[next] == 0){
                    queue.add(next);
                }

            }
        }



    }
}

// 4 4
//10 1 100 10
//1 2
//1 3
//2 4
//3 4
//4
//8 8