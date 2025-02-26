
import java.util.*;

public class Main {
    static int N;
    static int[] result, inDegree, origin;
    static List<List<Integer>> lists;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        lists = new ArrayList<>();


        for(int i = 0; i <= N; i++){
            lists.add(new ArrayList<>());
        }
        result = new int[N + 1];
        inDegree = new int[N + 1];
        origin = new int[N + 1];
        for(int i = 1; i <= N; i++){
            int time = sc.nextInt();
            result[i] = time;
            origin[i] = time;

            while(true){
                int before = sc.nextInt();
                if(before == -1){
                    break;
                }

                lists.get(before).add(i);
                inDegree[i]++;
            }
        }

        topologySort();

        for(int i = 1; i <= N; i++){
            System.out.println( result[i]);
        }

    }

    static void topologySort(){
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int before = queue.poll();

            for(int next : lists.get(before)){
                inDegree[next]--;
//                result[next] += result[before];

                if(result[before] + origin[next] > result[next] ){
                    result[next] = result[before] + origin[next];
                }

                if(inDegree[next] == 0){
                    queue.add(next);
                }
            }

        }
    }
}

//5
//10 -1
//10 1 -1
//4 1 -1
//4 3 1 -1
//3 3 -1