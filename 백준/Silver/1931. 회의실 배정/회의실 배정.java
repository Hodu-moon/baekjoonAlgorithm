import java.io.*;
import java.util.*;

public class Main {

    static boolean[] meeting;
    static int[][] arr;
    static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 선택 활동 Activity Selection
        // 종료 시간을 기준으로 정렬해라 .
        // 끝나는 시간으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int previous_time = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if( previous_time <= arr[i][0]){
                previous_time = arr[i][1];
                count++;
            }
        }

        System.out.println(count);

    }

}
