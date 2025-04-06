
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, trueKnow, result;
    static boolean[] know, resultBoolean, partyKnow;
    static List<Integer> trueList;
    static List<List<Integer>> parties, people;
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = M;
        resultBoolean = new boolean[M + 1];
        partyKnow = new boolean[M + 1];

        //
        st = new StringTokenizer(br.readLine(), " ");
        trueKnow = Integer.parseInt(st.nextToken());
        trueList = new ArrayList<>();
        know = new boolean[N + 1];

        for(int i = 0; i < trueKnow; i++){
            int no = Integer.parseInt(st.nextToken());
            trueList.add(no);
            know[no] = true;
        }


        // 1base
        parties = new ArrayList<>();
        parties.add(new ArrayList<>());

        //
        people = new ArrayList<>();

        for(int i = 0; i <=  N; i++){
            people.add(new ArrayList<>());
        }


        for(int partyIdx = 1; partyIdx <= M; partyIdx++){
            st = new StringTokenizer(br.readLine(), " ");

            parties.add(new ArrayList<>());

            List<Integer> list = parties.get(partyIdx);

            int n = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; i++ ){
                int p = Integer.parseInt(st.nextToken());
                list.add(p);
                people.get(p).add(partyIdx);
            }
        }

        if(trueKnow == 0)
            System.out.println(result);
        else{
            solve();

            System.out.println(result);
        }



    }
    static void solve(){

        // 진실을 아는 애들이 파티에 깄음
        Queue<Integer> queue = new ArrayDeque<>();
        for(int no : trueList){
            queue.offer(no);
        }

        while(!queue.isEmpty()){
            int no = queue.poll();



            for(int partyIdx : people.get(no)){

                if(partyKnow[partyIdx])
                    continue;

                for (int p : parties.get(partyIdx) ){

                    if(know[p])
                        continue;

                    queue.offer(p);
                    know[p] = true;


                }

                partyKnow[partyIdx] = true;
                result--;


            }
        }


    }
}

//첫째 줄에 사람의 수 N과 파티의 수 M이 주어진다.
//
//둘째 줄에는 이야기의 진실을 아는 사람의 수와 번호가 주어진다.
// 진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들의 번호가 주어진다.
// 사람들의 번호는 1부터 N까지의 수로 주어진다.
//
//셋째 줄부터 M개의 줄에는 각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어진다.
//4 3
//0
//2 1 2
//1 3
//3 2 3 4
