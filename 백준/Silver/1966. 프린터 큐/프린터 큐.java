
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int seq = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < num; j++){
                // {초기위치, 중요도 }
                q.offer(new int[] { j, Integer.parseInt(st.nextToken()) });
            }

            int count = 0;

            while(!q.isEmpty()){

                int []front = q.poll();
                boolean isMax = true;

                for(int j = 0; j < q.size(); j++){

                    // 중요도 부분인것 같다 초기위치는 j에들어가고
                    if(front[1] < q.get(j)[1]){
                        q.offer(front);
                        for(int k = 0; k < j; k++){
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(isMax == false){
                    continue;
                }

                count++;

                if(front[0] == seq){
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }
}
