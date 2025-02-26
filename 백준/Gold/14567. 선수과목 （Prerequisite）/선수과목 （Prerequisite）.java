
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> lists;
    static int[] inDegree;
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        // 들어오는 값
        inDegree = new int[N + 1];
        result = new int[N + 1];
        lists = new ArrayList<>();

        // 과목 수 만큼 리스트 생성
        // list 0 번 인덱스 안씀
        for(int i = 0; i <= N; i++){
            lists.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int before = sc.nextInt();
            int next = sc.nextInt();
            // 1 2
            // 1번에 2번 추가
            lists.get(before).add(next);

            inDegree[next]++;
        }

//        printLists();
        topologySort();

        for(int i = 1; i <= N; i++){
            int x = result[i] != 0 ? result[i] : 1 ;
            System.out.print(x + " ");
        }
    }

    static void topologySort(){
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i < N; i++){
            if(inDegree[i] == 0){
                queue.add(i);
                result[i] = 1;
            }
        }

        while(!queue.isEmpty()){
            int before = queue.poll();

            for(int next : lists.get(before)){
                inDegree[next]--;

                if(inDegree[next] == 0){
                    queue.add(next);
                    result[next] = result[before] + 1;
                }
            }
        }

        // 끝나고


    }
    static void printLists(){
        int i = 1;
        for(List<Integer> list : lists){
            System.out.print( i++ + " :");
            for(int x : list){
                System.out.print( x + " ");
            }
            System.out.println();
        }
    }
}

// 3 2
//2 3
//1 2

//1 2 3
