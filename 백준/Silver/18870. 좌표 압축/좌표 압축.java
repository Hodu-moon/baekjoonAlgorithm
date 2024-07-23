import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        sorted = new int[N];

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬해주기
        Arrays.sort(sorted);

//        Map으로 넣기
        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 0;


        for(int i = 0; i < N; i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], val++);
            }
        }

        for(int i = 0; i < N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }


        System.out.println(sb);
    }
}
